/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.recording.addonresult;

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

public class PayloadTest {
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
                                          Domains.API.toString(),
                                          "/2010-04-01/Accounts/ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Recordings/REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/AddOnResults/XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Payloads/XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.json");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Payload.fetcher("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"reference_sid\": \"REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_sid\": \"XBaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_configuration_sid\": \"XEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_result_sid\": \"XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"label\": \"XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"content_type\": \"application/json\",\"date_created\": \"Wed, 01 Sep 2010 15:15:41 +0000\",\"date_updated\": \"Wed, 01 Sep 2010 15:15:41 +0000\",\"subresource_uris\": {\"data\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads/XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Data.json\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Payload.fetcher("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.API.toString(),
                                          "/2010-04-01/Accounts/ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Recordings/REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/AddOnResults/XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Payloads.json");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Payload.reader("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads.json?PageSize=50&Page=0\",\"next_page_uri\": null,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"payloads\": [{\"sid\": \"XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"reference_sid\": \"REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_sid\": \"XBaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_configuration_sid\": \"XEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"add_on_result_sid\": \"XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"label\": \"XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"content_type\": \"application/json\",\"date_created\": \"Wed, 01 Sep 2010 15:15:41 +0000\",\"date_updated\": \"Wed, 01 Sep 2010 15:15:41 +0000\",\"subresource_uris\": {\"data\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads/XHaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Data.json\"}}],\"start\": 0,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads.json?PageSize=50&Page=0\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Payload.reader("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"end\": 0,\"first_page_uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads.json?PageSize=50&Page=0\",\"next_page_uri\": null,\"page\": 0,\"page_size\": 50,\"previous_page_uri\": null,\"payloads\": [],\"start\": 0,\"uri\": \"/2010-04-01/Accounts/ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Recordings/REaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/AddOnResults/XRaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Payloads.json?PageSize=50&Page=0\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Payload.reader("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.API.toString(),
                                          "/2010-04-01/Accounts/ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Recordings/REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/AddOnResults/XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Payloads/XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX.json");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Payload.deleter("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
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

        Payload.deleter("ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "REXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XRXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XHXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }
}