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
 * Test class for {@link Siprec}
 */
public class SiprecTest {
    @Test
    public void testEmptyElement() {
        Siprec elem = new Siprec.Builder().build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec/>",
            elem.toXml()
        );
    }

    @Test
    public void testEmptyElementUrl() {
        Siprec elem = new Siprec.Builder().build();

        Assertions.assertEquals("%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%3CSiprec%2F%3E", elem.toUrl());
    }

    @Test
    public void testElementWithParams() {
        Siprec elem = new Siprec.Builder()
            .name("name")
            .connectorName("connector_name")
            .track(Siprec.Track.INBOUND_TRACK)
            .build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec connectorName=\"connector_name\" name=\"name\" track=\"inbound_track\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithExtraAttributes() {
        Siprec elem = new Siprec.Builder().option("foo", "bar").option("a", "b").build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec a=\"b\" foo=\"bar\"/>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithChildren() {
        Siprec.Builder builder = new Siprec.Builder();

        builder.parameter(new Parameter.Builder().name("name").value("value").build());

        Siprec elem = builder.build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec>" +
                "<Parameter name=\"name\" value=\"value\"/>" +
            "</Siprec>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithTextNode() {
        Siprec.Builder builder = new Siprec.Builder();

        builder.addText("Hey no tags!");

        Siprec elem = builder.build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec>" +
            "Hey no tags!" +
            "</Siprec>",
            elem.toXml()
        );
    }

    @Test
    public void testMixedContent() {
        GenericNode.Builder child = new GenericNode.Builder("Child");
        child.addText("content");

        Siprec.Builder builder = new Siprec.Builder();

        builder.addText("before");
        builder.addChild(child.build());
        builder.addText("after");

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec>" +
            "before" +
            "<Child>content</Child>" +
            "after" +
            "</Siprec>",
            builder.build().toXml()
        );
    }

    @Test
    public void testElementWithGenericNode() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        genericBuilder.addText("Some text");
        GenericNode node = genericBuilder.build();

        Siprec.Builder builder = new Siprec.Builder();
        Siprec elem = builder.addChild(node).build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec>" +
            "<genericTag>" +
            "Some text" +
            "</genericTag>" +
            "</Siprec>",
            elem.toXml()
        );
    }

    @Test
    public void testElementWithGenericNodeAttributes() {
        GenericNode.Builder genericBuilder = new GenericNode.Builder("genericTag");
        GenericNode node = genericBuilder.option("key", "value").addText("someText").build();

        Siprec.Builder builder = new Siprec.Builder();
        Siprec elem = builder.addChild(node).build();

        Assertions.assertEquals(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<Siprec>" +
            "<genericTag key=\"value\">" +
            "someText" +
            "</genericTag>" +
            "</Siprec>",
            elem.toXml()
        );
    }

    @Test
    public void testXmlAttributesDeserialization() {
        final Siprec elem = new Siprec.Builder()
            .name("name")
            .connectorName("connector_name")
            .track(Siprec.Track.INBOUND_TRACK)
            .build();

        Assertions.assertEquals(
            Siprec.Builder.fromXml("<Siprec connectorName=\"connector_name\" name=\"name\" track=\"inbound_track\"/>").build().toXml(),
            elem.toXml()
        );
    }

    @Test
    public void testXmlChildrenDeserialization() {
        final Siprec.Builder builder = new Siprec.Builder();

        builder.parameter(new Parameter.Builder().name("name").value("value").build());

        final Siprec elem = builder.build();

        Assertions.assertEquals(
            Siprec.Builder.fromXml("<Siprec>" +
                "<Parameter name=\"name\" value=\"value\"/>" +
            "</Siprec>").build().toXml(),
            elem.toXml()
        );
    }
}