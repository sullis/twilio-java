/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link Sim}
 */
public class SimTest {
    @Test
    public void testElementWithParams() {
        Sim elem = new Sim.Builder("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Sim>DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</Sim>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Sim elem = new Sim.Builder("DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").build();

        Assertions.assertEquals(
            Sim.Builder.fromXml("<Sim>DEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</Sim>").build().toXml(),
            elem.toXml()
        );
    }
}