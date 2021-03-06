/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WorkerReader extends Reader<Worker> {
    private final String pathWorkspaceSid;
    private String activityName;
    private String activitySid;
    private String available;
    private String friendlyName;
    private String targetWorkersExpression;
    private String taskQueueName;
    private String taskQueueSid;

    /**
     * Construct a new WorkerReader.
     *
     * @param pathWorkspaceSid The SID of the Workspace with the Workers to read
     */
    public WorkerReader(final String pathWorkspaceSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
    }

    /**
     * The `activity_name` of the Worker resources to read..
     *
     * @param activityName The activity_name of the Worker resources to read
     * @return this
     */
    public WorkerReader setActivityName(final String activityName) {
        this.activityName = activityName;
        return this;
    }

    /**
     * The `activity_sid` of the Worker resources to read..
     *
     * @param activitySid The activity_sid of the Worker resources to read
     * @return this
     */
    public WorkerReader setActivitySid(final String activitySid) {
        this.activitySid = activitySid;
        return this;
    }

    /**
     * Whether to return only Worker resources that are available or unavailable.
     * Can be `true`, `1`, or `yes` to return Worker resources that are available,
     * and `false`, or any value returns the Worker resources that are not
     * available..
     *
     * @param available Whether to return Worker resources that are available or
     *                  unavailable
     * @return this
     */
    public WorkerReader setAvailable(final String available) {
        this.available = available;
        return this;
    }

    /**
     * The `friendly_name` of the Worker resources to read..
     *
     * @param friendlyName The friendly_name of the Worker resources to read
     * @return this
     */
    public WorkerReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Filter by Workers that would match an expression on a TaskQueue. This is
     * helpful for debugging which Workers would match a potential queue..
     *
     * @param targetWorkersExpression Filter by Workers that would match an
     *                                expression on a TaskQueue
     * @return this
     */
    public WorkerReader setTargetWorkersExpression(final String targetWorkersExpression) {
        this.targetWorkersExpression = targetWorkersExpression;
        return this;
    }

    /**
     * The `friendly_name` of the TaskQueue that the Workers to read are eligible
     * for..
     *
     * @param taskQueueName The friendly_name of the TaskQueue that the Workers to
     *                      read are eligible for
     * @return this
     */
    public WorkerReader setTaskQueueName(final String taskQueueName) {
        this.taskQueueName = taskQueueName;
        return this;
    }

    /**
     * The SID of the TaskQueue that the Workers to read are eligible for..
     *
     * @param taskQueueSid The SID of the TaskQueue that the Workers to read are
     *                     eligible for
     * @return this
     */
    public WorkerReader setTaskQueueSid(final String taskQueueSid) {
        this.taskQueueSid = taskQueueSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Worker ResourceSet
     */
    @Override
    public ResourceSet<Worker> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Worker ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Worker> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workers"
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Worker ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Worker> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Worker> nextPage(final Page<Worker> page,
                                 final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Worker> previousPage(final Page<Worker> page,
                                     final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Worker Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Worker> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Worker read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
           throw new ApiException(restException);
        }

        return Page.fromJson(
            "workers",
            response.getContent(),
            Worker.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (activityName != null) {
            request.addQueryParam("ActivityName", activityName);
        }

        if (activitySid != null) {
            request.addQueryParam("ActivitySid", activitySid);
        }

        if (available != null) {
            request.addQueryParam("Available", available);
        }

        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }

        if (targetWorkersExpression != null) {
            request.addQueryParam("TargetWorkersExpression", targetWorkersExpression);
        }

        if (taskQueueName != null) {
            request.addQueryParam("TaskQueueName", taskQueueName);
        }

        if (taskQueueSid != null) {
            request.addQueryParam("TaskQueueSid", taskQueueSid);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}