/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1.schema;

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

public class SchemaVersionTest {
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
                                          Domains.EVENTS.toString(),
                                          "/v1/Schemas/id/Versions");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            SchemaVersion.reader("id").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"schema_versions\": [],\"meta\": {\"page\": 0,\"page_size\": 10,\"first_page_url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions?PageSize=10&Page=0\",\"previous_page_url\": null,\"url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions?PageSize=10&Page=0\",\"next_page_url\": null,\"key\": \"schema_versions\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(SchemaVersion.reader("id").read());
    }

    @Test
    public void testReadResultsResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"schema_versions\": [{\"id\": \"Messaging.MessageStatus\",\"schema_version\": 1,\"public\": true,\"date_created\": \"2015-07-30T20:00:00Z\",\"url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions/1\",\"raw\": \"https://events-schemas.twilio.com/Messaging.MessageStatus/1\"},{\"id\": \"Messaging.MessageStatus\",\"schema_version\": 2,\"public\": true,\"date_created\": \"2015-07-30T20:00:00Z\",\"url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions/2\",\"raw\": \"https://events-schemas.twilio.com/Messaging.MessageStatus/2\"}],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"schema_versions\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(SchemaVersion.reader("id").read());
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.EVENTS.toString(),
                                          "/v1/Schemas/id/Versions/1");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            SchemaVersion.fetcher("id", 1).fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"id\": \"Messaging.MessageStatus\",\"schema_version\": 1,\"public\": true,\"date_created\": \"2015-07-30T20:00:00Z\",\"url\": \"https://events.twilio.com/v1/Schemas/Messaging.MessageStatus/Versions/1\",\"raw\": \"https://events-schemas.twilio.com/Messaging.MessageStatus/1\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(SchemaVersion.fetcher("id", 1).fetch());
    }
}