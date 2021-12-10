package com.twilio.base;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallReader;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ReaderTest {

    @Test
    public void testNoPagingDefaults() {
        Reader<Call> reader = new CallReader();
        Assertions.assertNull(reader.getLimit());
        Assertions.assertNull(reader.getPageSize());
    }

    @Test
    public void testSetPageSize() {
        Reader<Call> reader = new CallReader().pageSize(100);
        Assertions.assertEquals(100, reader.getPageSize().intValue());
        Assertions.assertNull(reader.getLimit());
    }

    @Test
    public void testMaxPageSize() {
        Reader<Call> reader = new CallReader().pageSize(Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, reader.getPageSize().intValue());
        Assertions.assertNull(reader.getLimit());
    }

    @Test
    public void testSetLimit() {
        Reader<Call> reader = new CallReader().limit(100);
        Assertions.assertEquals(100, reader.getLimit().intValue());
        Assertions.assertEquals(100, reader.getPageSize().intValue());
    }

    @Test
    public void testSetLimitMaxPageSize() {
        Reader<Call> reader = new CallReader().limit(Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, reader.getLimit().intValue());
        Assertions.assertEquals(Integer.MAX_VALUE, reader.getPageSize().intValue());
    }

    @Test
    public void testSetPageSizeLimit() {
        Reader<Call> reader = new CallReader().limit(1000).pageSize(5);
        Assertions.assertEquals(1000, reader.getLimit().intValue());
        Assertions.assertEquals(5, reader.getPageSize().intValue());
    }

    @Test
    public void testNoPageLimit(@Mocked final TwilioRestClient client, @Mocked final Page<Call> page) {
        new Expectations() {{
            page.getRecords(); result = Collections.emptyList();
        }};

        Reader<Call> reader = new CallReader();
        ResourceSet<Call> set = new ResourceSet<>(reader, client, page);
        Assertions.assertEquals(Long.MAX_VALUE, set.getPageLimit());
    }

    @Test
    public void testHasPageLimit(@Mocked final TwilioRestClient client, @Mocked final Page<Call> page) {
        new Expectations() {{
            page.getRecords(); result = Collections.emptyList();
            page.getPageSize(); result = 50;
        }};

        Reader<Call> reader = new CallReader().limit(100);
        ResourceSet<Call> set = new ResourceSet<>(reader, client, page);
        Assertions.assertEquals(2, set.getPageLimit());
    }

    @Test
    public void testUnevenHasPageLimit(@Mocked final TwilioRestClient client, @Mocked final Page<Call> page) {
        new Expectations() {{
            page.getRecords(); result = Collections.emptyList();
            page.getPageSize(); result = 50;
        }};

        Reader<Call> reader = new CallReader().limit(125);
        ResourceSet<Call> set = new ResourceSet<>(reader, client, page);
        Assertions.assertEquals(3, set.getPageLimit());
    }

}
