package com.twilio.jwt.taskrouter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link UrlUtils}.
 */
public class UrlUtilsTest {

    private static final String WORKSPACE_SID = "WS123";
    private static final String WORKER_SID = "WK123";
    private static final String ACTIVITY_SID = "AC123";
    private static final String TASK_SID = "TK123";
    private static final String TASK_QUEUE_SID = "TQ123";
    private static final String RESERVATION_SID = "WR123";

    @Test
    public void testWorkspaces() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces",
            UrlUtils.workspaces()
        );
    }

    @Test
    public void testAllWorkspaces() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/**",
            UrlUtils.allWorkspaces()
        );
    }

    @Test
    public void testWorkspace() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123",
            UrlUtils.workspace(WORKSPACE_SID)
        );
    }

    @Test
    public void testTaskQueues() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/TaskQueues",
            UrlUtils.taskQueues(WORKSPACE_SID)
        );
    }

    @Test
    public void testAllTaskQueues() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/TaskQueues/**",
            UrlUtils.allTaskQueues(WORKSPACE_SID)
        );
    }

    @Test
    public void testTaskQueue() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/TaskQueues/TQ123",
            UrlUtils.taskQueue(WORKSPACE_SID, TASK_QUEUE_SID)
        );
    }

    @Test
    public void testTasks() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Tasks",
            UrlUtils.tasks(WORKSPACE_SID)
        );
    }

    @Test
    public void testAllTasks() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Tasks/**",
            UrlUtils.allTasks(WORKSPACE_SID)
        );
    }

    @Test
    public void testTask() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Tasks/TK123",
            UrlUtils.task(WORKSPACE_SID, TASK_SID)
        );
    }

    @Test
    public void testActivities() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Activities",
            UrlUtils.activities(WORKSPACE_SID)
        );
    }

    @Test
    public void testAllActivities() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Activities/**",
            UrlUtils.allActivities(WORKSPACE_SID)
        );
    }

    @Test
    public void testActivity() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Activities/AC123",
            UrlUtils.activity(WORKSPACE_SID, ACTIVITY_SID)
        );
    }

    @Test
    public void testWorkers() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers",
            UrlUtils.workers(WORKSPACE_SID)
        );
    }

    @Test
    public void testAllWorkers() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers/**",
            UrlUtils.allWorkers(WORKSPACE_SID)
        );
    }

    @Test
    public void testWorker() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers/WK123",
            UrlUtils.worker(WORKSPACE_SID, WORKER_SID)
        );
    }

    @Test
    public void testReservations() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers/WK123/Reservations",
            UrlUtils.reservations(WORKSPACE_SID, WORKER_SID)
        );
    }

    @Test
    public void testAllReservations() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers/WK123/Reservations/**",
            UrlUtils.allReservations(WORKSPACE_SID, WORKER_SID)
        );
    }

    @Test
    public void testReservation() {
        Assertions.assertEquals(
            "https://taskrouter.twilio.com/v1/Workspaces/WS123/Workers/WK123/Reservations/WR123",
            UrlUtils.reservation(WORKSPACE_SID, WORKER_SID, RESERVATION_SID)
        );
    }

}
