package com.twilio.jwt.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

/**
 * Test class for {@link IncomingClientScope}.
 */
public class IncomingClientScopeTest {

    @Test
    public void testGenerate() throws UnsupportedEncodingException {
        Scope scope = new IncomingClientScope("foobar");
        Assertions.assertEquals(
            "scope:client:incoming?clientName=foobar",
            scope.getPayload()
        );
    }
}
