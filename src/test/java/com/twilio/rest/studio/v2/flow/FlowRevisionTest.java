/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v2.flow;

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

public class FlowRevisionTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @BeforeEach
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.STUDIO.toString(),
                                          "/v2/Flows/FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Revisions");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            FlowRevision.reader("FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"meta\": {\"previous_page_url\": null,\"next_page_url\": null,\"url\": \"https://studio.twilio.com/v2/Flows/FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Revisions?PageSize=50&Page=0\",\"page\": 0,\"first_page_url\": \"https://studio.twilio.com/v2/Flows/FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Revisions?PageSize=50&Page=0\",\"page_size\": 50,\"key\": \"revisions\"},\"revisions\": [{\"sid\": \"FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"Test Flow\",\"status\": \"published\",\"revision\": 1,\"definition\": null,\"commit_message\": null,\"valid\": null,\"errors\": null,\"date_created\": \"2017-11-06T12:00:00Z\",\"date_updated\": \"2017-11-06T12:00:00Z\",\"url\": \"https://studio.twilio.com/v2/Flows/FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Revisions/1\"}]}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(FlowRevision.reader("FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.STUDIO.toString(),
                                          "/v2/Flows/FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Revisions/revision");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            FlowRevision.fetcher("FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "revision").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"definition\": {\"initial_state\": \"Trigger\"},\"friendly_name\": \"Test Flow\",\"status\": \"published\",\"revision\": 1,\"commit_message\": null,\"valid\": true,\"errors\": [],\"date_created\": \"2017-11-06T12:00:00Z\",\"date_updated\": null,\"url\": \"https://studio.twilio.com/v2/Flows/FWaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Revisions/1\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(FlowRevision.fetcher("FWXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "revision").fetch());
    }
}