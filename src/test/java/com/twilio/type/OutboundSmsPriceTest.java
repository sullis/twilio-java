package com.twilio.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;

/**
 * Test class for {@link OutboundSmsPrice}.
 */
public class OutboundSmsPriceTest extends TypeTest {

    @Test
    public void testFromJson() throws IOException {
        String json = "{\n" +
            "    \"mcc\": \"mcc\",\n" +
            "    \"mnc\": \"mnc\",\n" +
            "    \"carrier\": \"att\",\n" +
            "    \"prices\": [{\n" +
            "        \"type\": \"local\",\n" +
            "        \"base_price\": 1.00,\n" +
            "        \"current_price\": 2.00\n" +
            "    }]\n" +
            "}";

        OutboundSmsPrice osp = fromJson(json, OutboundSmsPrice.class);
        Assertions.assertEquals("mcc", osp.getMcc());
        Assertions.assertEquals("mnc", osp.getMnc());
        Assertions.assertEquals("att", osp.getCarrier());
        Assertions.assertEquals(Collections.singletonList(
            new InboundSmsPrice(1.00, 2.00, InboundSmsPrice.Type.LOCAL)
        ), osp.getPrices());
    }
}
