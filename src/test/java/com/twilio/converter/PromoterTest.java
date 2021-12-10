package com.twilio.converter;

import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Collections;

/**
 * Test class for {@link Promoter}
 */
public class PromoterTest {

    @Test
    public void testPromoteUri() {
        URI uri = Promoter.uriFromString("https://trunking.twilio.com/v1/Trunks/TK123/OriginationUrls");
        Assertions.assertEquals(
            "https://trunking.twilio.com/v1/Trunks/TK123/OriginationUrls",
            uri.toString()
        );
    }

    @Test
    public void testPhoneNumberFromString() {
        PhoneNumber pn = Promoter.phoneNumberFromString("+12345678910");
        Assertions.assertEquals(new PhoneNumber("+12345678910"), pn);
    }

    @Test
    public void testTwimlFromString() {
        Twiml twiml = Promoter.twimlFromString("<Response><Say>Ahoy!</Say></Response>");
        Assertions.assertEquals(new Twiml("<Response><Say>Ahoy!</Say></Response>"), twiml);
    }

    @Test
    public void testPromoteList() {
        String s = "hi";
        Assertions.assertEquals(
            Collections.singletonList(s),
            Promoter.listOfOne(s)
        );
    }
}
