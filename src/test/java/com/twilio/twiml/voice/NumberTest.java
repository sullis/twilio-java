/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.List;

/**
 * Test class for {@link Number}
 */
public class NumberTest {
    @Test
    public void testElementWithParams() {
        Number elem = new Number.Builder(new com.twilio.type.PhoneNumber("+15017122661"))
            .sendDigits("send_digits")
            .url(URI.create("https://example.com"))
            .method(HttpMethod.GET)
            .statusCallbackEvents(Promoter.listOfOne(Number.Event.INITIATED))
            .statusCallback(URI.create("https://example.com"))
            .statusCallbackMethod(HttpMethod.GET)
            .byoc("BYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
            .build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Number byoc=\"BYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\" method=\"GET\" sendDigits=\"send_digits\" statusCallback=\"https://example.com\" statusCallbackEvent=\"initiated\" statusCallbackMethod=\"GET\" url=\"https://example.com\">+15017122661</Number>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Number elem = new Number.Builder(new com.twilio.type.PhoneNumber("+15017122661"))
            .sendDigits("send_digits")
            .url(URI.create("https://example.com"))
            .method(HttpMethod.GET)
            .statusCallbackEvents(Promoter.listOfOne(Number.Event.INITIATED))
            .statusCallback(URI.create("https://example.com"))
            .statusCallbackMethod(HttpMethod.GET)
            .byoc("BYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
            .build();

        Assertions.assertEquals(
            Number.Builder.fromXml("<Number byoc=\"BYXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\" method=\"GET\" sendDigits=\"send_digits\" statusCallback=\"https://example.com\" statusCallbackEvent=\"initiated\" statusCallbackMethod=\"GET\" url=\"https://example.com\">+15017122661</Number>").build().toXml(),
            elem.toXml()
        );
    }
}