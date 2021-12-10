package com.twilio.taskrouter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Test class for {@link WorkflowRuleTarget}
 */
public class WorkflowRuleTargetTest {

    @Test
    public void testToJson() throws IOException {
        WorkflowRuleTarget target = new WorkflowRuleTarget.Builder("QS123")
            .expression("1==1")
            .priority(5)
            .timeout(30)
            .orderBy("worker.english_level ASC")
            .skipIf("workers.available == 0")
            .knownWorkerSid("task.requested_agent_id")
            .knownWorkerFriendlyName("task.requested_agent")
            .build();

        Assertions.assertEquals(
            "{\"queue\":\"QS123\",\"expression\":\"1==1\",\"priority\":5,\"timeout\":30,\"order_by\":\"worker.english_level ASC\",\"skip_if\":\"workers.available == 0\",\"known_worker_sid\":\"task.requested_agent_id\",\"known_worker_friendly_name\":\"task.requested_agent\"}",
            target.toJson()
        );
    }

    @Test
    public void testFromJson() throws IOException {
        WorkflowRuleTarget target =
            WorkflowRuleTarget.fromJson("{\"queue\":\"QS123\",\"expression\":\"1==1\",\"priority\":5,\"timeout\":30,\"order_by\":\"worker.english_level ASC\",\"skip_if\":\"workers.available == 0\",\"known_worker_friendly_name\":\"task.requested_agent\",\"known_worker_sid\":\"task.requested_agent_id\"}");

        Assertions.assertEquals("QS123", target.getQueue());
        Assertions.assertEquals("1==1", target.getExpression());
        Assertions.assertEquals(5, (int)target.getPriority());
        Assertions.assertEquals(30, (int)target.getTimeout());
        Assertions.assertEquals("worker.english_level ASC", target.getOrderBy());
        Assertions.assertEquals("workers.available == 0", target.getSkipIf());
        Assertions.assertEquals("task.requested_agent", target.getKnownWorkerFriendlyName());
        Assertions.assertEquals("task.requested_agent_id", target.getKnownWorkerSid());
    }
}
