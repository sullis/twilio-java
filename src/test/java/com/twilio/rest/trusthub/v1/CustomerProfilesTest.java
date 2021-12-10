/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trusthub.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class CustomerProfilesTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @BeforeEach
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.TRUSTHUB.toString(),
                                          "/v1/CustomerProfiles");
            request.addPostParam("FriendlyName", serialize("friendly_name"));
            request.addPostParam("Email", serialize("email"));
            request.addPostParam("PolicySid", serialize("RNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            CustomerProfiles.creator("friendly_name", "email", "RNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"policy_sid\": \"RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"status\": \"draft\",\"email\": \"email\",\"status_callback\": \"http://www.example.com\",\"valid_until\": null,\"date_created\": \"2019-07-30T22:29:24Z\",\"date_updated\": \"2019-07-31T01:09:00Z\",\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"customer_profiles_entity_assignments\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/EntityAssignments\",\"customer_profiles_evaluations\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Evaluations\",\"customer_profiles_channel_endpoint_assignment\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ChannelEndpointAssignments\"}}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        CustomerProfiles.creator("friendly_name", "email", "RNXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.TRUSTHUB.toString(),
                                          "/v1/CustomerProfiles");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            CustomerProfiles.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"results\": [],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://trusthub.twilio.com/v1/CustomerProfiles?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"results\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(CustomerProfiles.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"results\": [{\"sid\": \"BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"policy_sid\": \"RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"status\": \"provisionally-approved\",\"email\": \"email\",\"status_callback\": \"http://www.example.com\",\"valid_until\": \"2020-07-31T01:00:00Z\",\"date_created\": \"2019-07-30T22:29:24Z\",\"date_updated\": \"2019-07-31T01:09:00Z\",\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"customer_profiles_entity_assignments\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/EntityAssignments\",\"customer_profiles_evaluations\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Evaluations\",\"customer_profiles_channel_endpoint_assignment\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ChannelEndpointAssignments\"}}],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://trusthub.twilio.com/v1/CustomerProfiles?Status=draft&FriendlyName=friendly_name&PolicySid=RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles?Status=draft&FriendlyName=friendly_name&PolicySid=RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa&PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"results\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(CustomerProfiles.reader().read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.TRUSTHUB.toString(),
                                          "/v1/CustomerProfiles/BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            CustomerProfiles.fetcher("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"policy_sid\": \"RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"status\": \"draft\",\"valid_until\": null,\"email\": \"email\",\"status_callback\": \"http://www.example.com\",\"date_created\": \"2019-07-30T22:29:24Z\",\"date_updated\": \"2019-07-31T01:09:00Z\",\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"customer_profiles_entity_assignments\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/EntityAssignments\",\"customer_profiles_evaluations\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Evaluations\",\"customer_profiles_channel_endpoint_assignment\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ChannelEndpointAssignments\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(CustomerProfiles.fetcher("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.TRUSTHUB.toString(),
                                          "/v1/CustomerProfiles/BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            CustomerProfiles.updater("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"policy_sid\": \"RNaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"status\": \"draft\",\"email\": \"email\",\"status_callback\": \"http://www.example.com\",\"valid_until\": null,\"date_created\": \"2019-07-30T22:29:24Z\",\"date_updated\": \"2019-07-31T01:09:00Z\",\"url\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"links\": {\"customer_profiles_entity_assignments\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/EntityAssignments\",\"customer_profiles_evaluations\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Evaluations\",\"customer_profiles_channel_endpoint_assignment\": \"https://trusthub.twilio.com/v1/CustomerProfiles/BUaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/ChannelEndpointAssignments\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        CustomerProfiles.updater("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.TRUSTHUB.toString(),
                                          "/v1/CustomerProfiles/BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            CustomerProfiles.deleter("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testDeleteResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("null", TwilioRestClient.HTTP_STATUS_CODE_NO_CONTENT);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        CustomerProfiles.deleter("BUXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }
}