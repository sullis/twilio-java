package com.twilio.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Test class for {@link OutboundPrefixPrice}.
 */
public class OutboundPrefixPriceTest extends TypeTest {

    @Test
    public void testFromJson() throws IOException {
        String json = "{\n" +
            "    \"prefixes\": [\n" +
            "        \"abc\",\n" +
            "        \"xyz\"\n" +
            "    ],\n" +
            "    \"friendly_name\": \"name\",\n" +
            "    \"base_price\": 1.00,\n" +
            "    \"current_price\": 2.00\n" +
            "}";

        OutboundPrefixPrice opp = fromJson(json, OutboundPrefixPrice.class);
        Assertions.assertEquals(Arrays.asList("abc", "xyz"), opp.getPrefixes());
        Assertions.assertEquals("name", opp.getFriendlyName());
        Assertions.assertEquals(1.00, opp.getBasePrice(), 0.00);
        Assertions.assertEquals(2.00, opp.getCurrentPrice(), 0.00);
    }
}
