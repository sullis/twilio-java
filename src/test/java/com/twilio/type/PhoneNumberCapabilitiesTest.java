package com.twilio.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Test class for {@link PhoneNumberCapabilities}.
 */
public class PhoneNumberCapabilitiesTest extends TypeTest {

    @Test
    public void testFromJson() throws IOException {
        String json = "{\n" +
            "    \"MMS\": true,\n" +
            "    \"SMS\": false,\n" +
            "    \"voice\": true\n" +
            "}";

        PhoneNumberCapabilities pnc = fromJson(json, PhoneNumberCapabilities.class);
        Assertions.assertTrue(pnc.getMms());
        Assertions.assertTrue(pnc.getVoice());
        Assertions.assertFalse(pnc.getSms());
    }

    @Test
    public void testFromJsonExtraField() throws IOException {
        String json = "{\n" +
            "    \"MMS\": true,\n" +
            "    \"SMS\": false,\n" +
            "    \"voice\": true,\n" +
            "    \"foo\": true\n" +
            "}";

        PhoneNumberCapabilities pnc = fromJson(json, PhoneNumberCapabilities.class);
        Assertions.assertTrue(pnc.getMms());
        Assertions.assertTrue(pnc.getVoice());
        Assertions.assertFalse(pnc.getSms());
    }
}
