/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

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

public class SimTest {
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
                                          Domains.WIRELESS.toString(),
                                          "/v1/Sims/DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Sim.fetcher("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"commands_callback_method\": \"POST\",\"commands_callback_url\": \"http://www.example.com\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"sms_fallback_method\": \"POST\",\"sms_fallback_url\": \"http://www.example.com\",\"sms_method\": \"POST\",\"sms_url\": \"http://www.example.com\",\"voice_fallback_method\": \"POST\",\"voice_fallback_url\": \"http://www.example.com\",\"voice_method\": \"POST\",\"voice_url\": \"http://www.example.com\",\"links\": {\"data_sessions\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/DataSessions\",\"rate_plan\": \"https://wireless.twilio.com/v1/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_records\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/UsageRecords\"},\"rate_plan_sid\": \"WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"iccid\": \"iccid\",\"e_id\": \"e_id\",\"status\": \"new\",\"reset_status\": null,\"url\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"ip_address\": \"192.168.1.1\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Sim.fetcher("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Sims");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Sim.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sims\": [],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/Sims?Status=new&Iccid=iccid&RatePlan=rate_plan&PageSize=50&Page=0\",\"key\": \"sims\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/Sims?Status=new&Iccid=iccid&RatePlan=rate_plan&PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Sim.reader().read());
    }

    @Test
    public void testReadFullResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sims\": [{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"commands_callback_method\": \"POST\",\"commands_callback_url\": \"http://www.example.com\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"links\": {\"data_sessions\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/DataSessions\",\"rate_plan\": \"https://wireless.twilio.com/v1/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_records\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/UsageRecords\"},\"rate_plan_sid\": \"WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"iccid\": \"iccid\",\"e_id\": \"e_id\",\"status\": \"new\",\"reset_status\": \"resetting\",\"sms_fallback_method\": \"POST\",\"sms_fallback_url\": \"http://www.example.com\",\"sms_method\": \"POST\",\"sms_url\": \"http://www.example.com\",\"voice_fallback_method\": \"POST\",\"voice_fallback_url\": \"http://www.example.com\",\"voice_method\": \"POST\",\"voice_url\": \"http://www.example.com\",\"url\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"ip_address\": \"192.168.1.30\"}],\"meta\": {\"first_page_url\": \"https://wireless.twilio.com/v1/Sims?Status=new&Iccid=iccid&RatePlan=rate_plan&PageSize=50&Page=0\",\"key\": \"sims\",\"next_page_url\": null,\"page\": 0,\"page_size\": 50,\"previous_page_url\": null,\"url\": \"https://wireless.twilio.com/v1/Sims?Status=new&Iccid=iccid&RatePlan=rate_plan&PageSize=50&Page=0\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(Sim.reader().read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Sims/DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Sim.updater("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"commands_callback_method\": \"POST\",\"commands_callback_url\": \"http://www.example.com\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"links\": {\"data_sessions\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/DataSessions\",\"rate_plan\": \"https://wireless.twilio.com/v1/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_records\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/UsageRecords\"},\"rate_plan_sid\": \"WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"iccid\": \"iccid\",\"e_id\": \"e_id\",\"status\": \"new\",\"reset_status\": null,\"sms_fallback_method\": \"POST\",\"sms_fallback_url\": \"http://www.example.com\",\"sms_method\": \"POST\",\"sms_url\": \"http://www.example.com\",\"voice_fallback_method\": \"POST\",\"voice_fallback_url\": \"http://www.example.com\",\"voice_method\": \"POST\",\"voice_url\": \"http://www.example.com\",\"url\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"ip_address\": \"192.168.1.30\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Sim.updater("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testUpdateMoveToSubaccountResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\",\"unique_name\": \"unique_name\",\"commands_callback_method\": \"POST\",\"commands_callback_url\": \"http://www.example.com\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"links\": {\"data_sessions\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/DataSessions\",\"rate_plan\": \"https://wireless.twilio.com/v1/RatePlans/WPbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\",\"usage_records\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/UsageRecords\"},\"rate_plan_sid\": \"WPbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb\",\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"iccid\": \"iccid\",\"e_id\": \"e_id\",\"status\": \"new\",\"reset_status\": null,\"sms_fallback_method\": \"POST\",\"sms_fallback_url\": \"http://www.example.com\",\"sms_method\": \"POST\",\"sms_url\": \"http://www.example.com\",\"voice_fallback_method\": \"POST\",\"voice_fallback_url\": \"http://www.example.com\",\"voice_method\": \"POST\",\"voice_url\": \"http://www.example.com\",\"url\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"ip_address\": \"192.168.1.30\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Sim.updater("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testUpdateResetConnectivityResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"unique_name\": \"unique_name\",\"commands_callback_method\": \"GET\",\"commands_callback_url\": \"http://www.example.com\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"friendly_name\": \"friendly_name\",\"links\": {\"data_sessions\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/DataSessions\",\"rate_plan\": \"https://wireless.twilio.com/v1/RatePlans/WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"usage_records\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/UsageRecords\"},\"rate_plan_sid\": \"WPaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sid\": \"DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"iccid\": \"iccid\",\"e_id\": \"e_id\",\"status\": \"active\",\"reset_status\": \"resetting\",\"sms_fallback_method\": \"POST\",\"sms_fallback_url\": \"http://www.example.com\",\"sms_method\": \"POST\",\"sms_url\": \"http://www.example.com\",\"voice_fallback_method\": \"POST\",\"voice_fallback_url\": \"http://www.example.com\",\"voice_method\": \"POST\",\"voice_url\": \"http://www.example.com\",\"url\": \"https://wireless.twilio.com/v1/Sims/DEaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"ip_address\": \"192.168.1.30\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        Sim.updater("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").update();
    }

    @Test
    public void testDeleteRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.DELETE,
                                          Domains.WIRELESS.toString(),
                                          "/v1/Sims/DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            Sim.deleter("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
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

        Sim.deleter("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").delete();
    }
}