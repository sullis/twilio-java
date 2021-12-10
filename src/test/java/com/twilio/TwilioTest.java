package com.twilio;

import com.twilio.exception.ApiException;
import com.twilio.exception.AuthenticationException;
import com.twilio.exception.CertificateValidationException;
import com.twilio.http.HttpMethod;
import com.twilio.http.NetworkHttpClient;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwilioTest {

    public static String serialize(Object object) {
        return object.toString();
    }

    public static String serialize(List list) {
        // NOTE: This relies on the fact that integration tests only ever generate single element lists.
        return list.get(0).toString();
    }

    @Mocked
    private NetworkHttpClient networkHttpClient;

    @Test
    public void testGetExecutorService() {
        assertNotNull(Twilio.getExecutorService());
    }

    @Test
    public void testGetRestClientNullAccountSid() {
        assertThrows(AuthenticationException.class, () -> {
            Twilio.setRestClient(null);
            Twilio.setUsername(null);
            Twilio.setPassword(null);

            Twilio.getRestClient();
            fail("AuthenticationException was expected");
        });
    }

    @Test
    public void testSetAccountSidNull() {
        assertThrows(AuthenticationException.class, () -> {
            Twilio.setUsername(null);
            fail("AuthenticationException was expected");
        });
    }

    @Test
    public void testSetAuthTokenNull() {
        assertThrows(AuthenticationException.class, () -> {
            Twilio.setPassword(null);
            fail("AuthenticationException was expected");
        });
    }

    @Test
    public void testSetExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Twilio.setExecutorService(executorService);
        assertEquals(executorService, Twilio.getExecutorService());
    }

    @Test
    public void testDestroyExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Twilio.setExecutorService(executorService);
        Twilio.destroy();
        assertTrue(Twilio.getExecutorService().isShutdown());
    }

    @Test
    public void testSetRestClient() {
        TwilioRestClient twilioRestClient = new TwilioRestClient.Builder("AC123", "AUTH TOKEN").build();
        Twilio.setRestClient(twilioRestClient);
        assertEquals(twilioRestClient, Twilio.getRestClient());
    }

    @Test
    public void testValidateSslCertificateError() {
        new NonStrictExpectations() {{
            final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
            networkHttpClient.makeRequest(request);
            times = 1;
            result = new Response("", 500);
        }};

        try {
            Twilio.validateSslCertificate();
            fail("Excepted CertificateValidationException");
        } catch (final CertificateValidationException e) {
            assertEquals("Unexpected response from certificate endpoint", e.getMessage());
        }
    }

    @Test
    public void testValidateSslCertificateException() {
        new NonStrictExpectations() {{
            final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
            networkHttpClient.makeRequest(request);
            times = 1;
            result = new ApiException("No");
        }};

        try {
            Twilio.validateSslCertificate();
            fail("Excepted CertificateValidationException");
        } catch (final CertificateValidationException e) {
            assertEquals("Could not get response from certificate endpoint", e.getMessage());
        }
    }

    @Test
    public void testValidateSslCertificateSuccess() {
        new NonStrictExpectations() {{
            final Request request = new Request(HttpMethod.GET, "https://api.twilio.com:8443");
            networkHttpClient.makeRequest(request);
            times = 1;
            result = new Response("", 200);
        }};

        Twilio.validateSslCertificate();
    }
}
