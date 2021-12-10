package com.twilio.jwt.accesstoken;

import com.twilio.jwt.Jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Test class for {@link AccessToken}.
 */
public class AccessTokenTest {

    private static final String ACCOUNT_SID = "AC123";
    private static final String SIGNING_KEY_SID = "SK123";
    private static final String SECRET = "secretsecretsecretsecretsecret00";

    private void validateToken(Claims claims) {
        Assertions.assertEquals(SIGNING_KEY_SID, claims.getIssuer());
        Assertions.assertEquals(ACCOUNT_SID, claims.getSubject());

        Assertions.assertNotNull(claims.getExpiration());
        Assertions.assertNotNull(claims.getId());
        Assertions.assertNotNull(claims.get("grants"));

        Assertions.assertTrue(claims.getId().startsWith(claims.getIssuer() + "-"));
        Assertions.assertTrue(claims.getExpiration().getTime() > new Date().getTime());
    }

    private Claims getClaimFromJwtToken(Jwt token) {
        return Jwts.parser()
                   .setSigningKey(SECRET.getBytes())
                   .parseClaimsJws(token.toJwt())
                   .getBody();
    }

    private void testVoiceToken(Boolean allow) {
        Map<String, Object> params = new HashMap<>();
        params.put("foo", "bar");

        VoiceGrant pvg = new VoiceGrant()
            .setOutgoingApplication("AP123", params)
            .setIncomingAllow(allow);

        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(pvg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);
        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> pvgGrant = (Map<String, Object>) decodedGrants.get("voice");

        Map<String, Object> incoming = (Map<String, Object>) pvgGrant.get("incoming");
        Assertions.assertEquals(allow, incoming.get("allow"));

        Map<String, Object> outgoing = (Map<String, Object>) pvgGrant.get("outgoing");
        Map<String, Object> outgoingParams = (Map<String, Object>) outgoing.get("params");
        Assertions.assertEquals("AP123", outgoing.get("application_sid"));
        Assertions.assertEquals("bar", outgoingParams.get("foo"));
    }

    @Test
    public void testEmptyToken() {
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);
    }

    @Test
    public void testOptionalValues() {
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .identity(ACCOUNT_SID)
                .nbf(new Date())
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);
        Assertions.assertTrue(claims.getNotBefore().getTime() <= new Date().getTime());
    }

    @Test
    public void testRegion() {
        Jwt token = new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
          .region("foo")
          .build();

        JwsHeader header = Jwts.parser()
            .setSigningKey(SECRET.getBytes())
            .parseClaimsJws(token.toJwt())
            .getHeader();

        Assertions.assertEquals("foo", header.get("twr"));
    }

    @Test
    public void testEmptyRegion() {
        Jwt token = new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET).build();

        JwsHeader header = Jwts.parser()
            .setSigningKey(SECRET.getBytes())
            .parseClaimsJws(token.toJwt())
            .getHeader();

        Assertions.assertEquals(null, header.get("twr"));
    }

    @Test
    public void testVideoGrant() {
        VideoGrant cg = new VideoGrant().setRoom("RM123");
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(cg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("video");
        Assertions.assertEquals("RM123", grant.get("room"));
    }

    @Test
    public void testChatGrant() {
        ChatGrant cg = new ChatGrant()
            .setDeploymentRoleSid("RL123")
            .setEndpointId("foobar")
            .setPushCredentialSid("CR123")
            .setServiceSid("IS123");
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(cg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("chat");
        Assertions.assertEquals("RL123", grant.get("deployment_role_sid"));
        Assertions.assertEquals("foobar", grant.get("endpoint_id"));
        Assertions.assertEquals("CR123", grant.get("push_credential_sid"));
        Assertions.assertEquals("IS123", grant.get("service_sid"));
    }

    @Test
    public void testSyncGrant() {
        SyncGrant sg = new SyncGrant()
                .setEndpointId("foobar")
                .setServiceSid("IS123");
        Jwt token =
                new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                        .grant(sg)
                        .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("data_sync");
        Assertions.assertEquals("foobar", grant.get("endpoint_id"));
        Assertions.assertEquals("IS123", grant.get("service_sid"));
    }

    @Test
    public void testPlaybackGrant() {
        Map<String, Object> grantPayload = new HashMap<>();
        grantPayload.put("requestCredentials", null);
        grantPayload.put("playbackUrl", "https://000.us-east-1.playback.live-video.net/api/video/v1/us-east-000.channel.000?token=xxxxx");
        grantPayload.put("playerStreamerSid", "VJXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        PlaybackGrant pg = new PlaybackGrant().setGrant(grantPayload);
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(pg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("player");
        Assertions.assertNull(grant.get("requestCredentials"));
        Assertions.assertEquals("https://000.us-east-1.playback.live-video.net/api/video/v1/us-east-000.channel.000?token=xxxxx", grant.get("playbackUrl"));
        Assertions.assertEquals("VJXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", grant.get("playerStreamerSid"));
    }

    @Test
    public void testTaskRouterGrant() {
        TaskRouterGrant trg = new TaskRouterGrant()
                .setWorkspaceSid("WS123")
                .setWorkerSid("WK123")
                .setRole("worker");

        Jwt token =
                new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                        .grant(trg)
                        .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("task_router");
        Assertions.assertEquals("WS123", grant.get("workspace_sid"));
        Assertions.assertEquals("WK123", grant.get("worker_sid"));
        Assertions.assertEquals("worker", grant.get("role"));
    }

    @Test
    public void testVoiceTokenWithIncoming() {
      testVoiceToken(true);
      testVoiceToken(false);
    }

    @Test
    public void testVoiceTokenWithoutIncoming() {
        Map<String, Object> params = new HashMap<>();
        params.put("foo", "bar");

        VoiceGrant pvg = new VoiceGrant()
            .setOutgoingApplication("AP123", params);

        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(pvg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);
        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Assertions.assertEquals(1, decodedGrants.size());

        Map<String, Object> pvgGrant = (Map<String, Object>) decodedGrants.get("voice");

        Assertions.assertEquals(null, pvgGrant.get("incoming"));

        Map<String, Object> outgoing = (Map<String, Object>) pvgGrant.get("outgoing");
        Map<String, Object> outgoingParams = (Map<String, Object>) outgoing.get("params");
        Assertions.assertEquals("AP123", outgoing.get("application_sid"));
        Assertions.assertEquals("bar", outgoingParams.get("foo"));
    }

    @Test
    public void testNullValues() {
        ChatGrant cg = new ChatGrant().setDeploymentRoleSid("RL123");
        Jwt token =
            new AccessToken.Builder(ACCOUNT_SID, SIGNING_KEY_SID, SECRET)
                .grant(cg)
                .build();

        Claims claims = getClaimFromJwtToken(token);

        validateToken(claims);

        Map<String, Object> decodedGrants = (Map<String, Object>) claims.get("grants");
        Map<String, Object> grant = (Map<String, Object>) decodedGrants.get("chat");

        Assertions.assertEquals("RL123", grant.get("deployment_role_sid"));
        Assertions.assertFalse(grant.containsKey("endpoint_id"));
    }
}
