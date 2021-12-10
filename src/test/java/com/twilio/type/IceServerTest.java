package com.twilio.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Test class for {@link IceServer}.
 */
public class IceServerTest extends TypeTest {

    @Test
    public void testFromJson() throws IOException {
        String json = "{\n" +
            "    \"credential\": \"apn\",\n" +
            "    \"username\": \"twilio\",\n" +
            "    \"url\": \"https://www.twilio.ca\",\n" +
            "    \"urls\": \"https://www.twilio.ca\"\n" +
            "}";

        IceServer is = fromJson(json, IceServer.class);
        assertEquals("https://www.twilio.ca", is.getUrl());
        assertEquals("https://www.twilio.ca", is.getUrls());
        assertEquals(is.getUrls(), is.getUrl());
        assertEquals("apn", is.getCredential());
        assertEquals("twilio", is.getUsername());
    }
}
