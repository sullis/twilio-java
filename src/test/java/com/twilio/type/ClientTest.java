package com.twilio.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testGetEndpoint() {
        Assertions.assertEquals("client:me", new Client("me").getEndpoint());
        Assertions.assertEquals("client:YOU", new Client("YOU").getEndpoint());
        Assertions.assertEquals("CLIENT:HIM", new Client("CLIENT:HIM").getEndpoint());
        Assertions.assertEquals("cLiEnT:her", new Client("cLiEnT:her").getEndpoint());
    }
}
