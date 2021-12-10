/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.deployedDevices.fleet;

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

public class KeyTest {
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
                                          Domains.PREVIEW.toString(),
                                          "/DeployedDevices/Fleets/FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Keys/KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Key.fetcher("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"fleet_sid\": \"FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"device_sid\": \"THaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"secret\": null,\"date_created\": \"2016-07-30T20:00:00Z\",\"date_updated\": null,\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys/KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Key.fetcher("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.PREVIEW.toString(),
                                          "/DeployedDevices/Fleets/FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Keys/KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Key.deleter("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
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

        Key.deleter("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.PREVIEW.toString(),
                                          "/DeployedDevices/Fleets/FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Keys");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Key.creator("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"fleet_sid\": \"FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"device_sid\": \"THaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"secret\": null,\"date_created\": \"2016-07-30T20:00:00Z\",\"date_updated\": null,\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys/KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Key.creator("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").create();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.PREVIEW.toString(),
                                          "/DeployedDevices/Fleets/FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Keys");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Key.reader("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"keys\": [],\"meta\": {\"first_page_url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys?PageSize=50&Page=0\",\"key\": \"keys\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Key.reader("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"keys\": [{\"sid\": \"KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"fleet_sid\": \"FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"device_sid\": \"THaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"secret\": null,\"date_created\": \"2016-07-30T20:00:00Z\",\"date_updated\": \"2016-07-30T20:00:00Z\",\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys/KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}],\"meta\": {\"first_page_url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys?PageSize=50&Page=0\",\"key\": \"keys\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys?PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Key.reader("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.PREVIEW.toString(),
                                          "/DeployedDevices/Fleets/FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Keys/KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Key.updater("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"friendly_name\": \"friendly_name\",\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"fleet_sid\": \"FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"device_sid\": \"THaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"secret\": null,\"date_created\": \"2016-07-30T20:00:00Z\",\"date_updated\": \"2016-07-30T20:00:00Z\",\"url\": \"https://preview.twilio.com/DeployedDevices/Fleets/FLaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Keys/KYaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Key.updater("FLXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "KYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }
}