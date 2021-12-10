/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.GenericNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link Hangup}
 */
public class HangupTest {
    @Test
    public void testEmptyElement() {
        Hangup elem = new Hangup.Builder().build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Hangup/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Hangup elem = new Hangup.Builder().build();

        Assertions.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CHangup%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithExtraAttributes() {
        Hangup elem = new Hangup.Builder().option("foo", "bar").option("a", "b").build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Hangup a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Hangup.Builder builder = new Hangup.Builder();

        builder.addText("Hey no tags!");

        Hangup elem = builder.build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Hangup>" +
            "Hey no tags!" +
            "</Hangup>",
            elem.toXml()
        );
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Hangup.Builder builder = new Hangup.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Hangup>" +
            "before" +
            "<Child>content</Child>" +
            "after" +
            "</Hangup>",
            builder.build().toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Hangup.Builder builder = new Hangup.Builder();
        Hangup elem = builder.addChild(node).build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Hangup>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Hangup>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Hangup elem = new Hangup.Builder().build();

        Assertions.assertEquals(
            Hangup.Builder.fromXml("<Hangup/>").build().toXml(),
            elem.toXml()
        );
    }
}