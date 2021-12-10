/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.document;

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

public class DocumentPermissionTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @BeforeEach
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SYNC.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Documents/ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Permissions/identity");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            DocumentPermission.fetcher("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"document_sid\": \"ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"identity\",\"read\": true,\"write\": true,\"manage\": true,\"url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Permissions/identity\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(DocumentPermission.fetcher("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").fetch());
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.SYNC.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Documents/ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Permissions/identity");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            DocumentPermission.deleter("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").delete();
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

        DocumentPermission.deleter("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity").delete();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.SYNC.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Documents/ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Permissions");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            DocumentPermission.reader("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"permissions\": [],\"meta\": {\"first_page_url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/sidOrUniqueName/Permissions?PageSize=50&Page=0\",\"key\": \"permissions\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/sidOrUniqueName/Permissions?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(DocumentPermission.reader("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"permissions\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"document_sid\": \"ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"identity\",\"read\": true,\"write\": true,\"manage\": true,\"url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Permissions/identity\"}],\"meta\": {\"first_page_url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/sidOrUniqueName/Permissions?PageSize=50&Page=0\",\"key\": \"permissions\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/sidOrUniqueName/Permissions?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(DocumentPermission.reader("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.SYNC.toString(),
                                          "/v1/Services/ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Documents/ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Permissions/identity");
            request.addPostParam("Read", serialize(true));
            request.addPostParam("Write", serialize(true));
            request.addPostParam("Manage", serialize(true));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            DocumentPermission.updater("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", true, true, true).update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"service_sid\": \"ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"document_sid\": \"ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"identity\": \"identity\",\"read\": true,\"write\": true,\"manage\": true,\"url\": \"https://sync.twilio.com/v1/Services/ISaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Documents/ETaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Permissions/identity\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        DocumentPermission.updater("ISXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "ETXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "identity", true, true, true).update();
    }
}