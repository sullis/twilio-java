/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class WorkspaceReader extends Reader<Workspace> {

    private String friendlyName;
    private Long pageSize;

    public WorkspaceReader() {}

    public WorkspaceReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public WorkspaceReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Workspace> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Workspace> firstPage(final TwilioRestClient client) {
        String path = "/v1/Workspaces";

        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Workspace> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Workspace read failed: Unable to connect to server"
            );
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(
                response.getStream(),
                client.getObjectMapper()
            );
            if (restException == null) {
                throw new ApiException(
                    "Server Error, no content",
                    response.getStatusCode()
                );
            }
            throw new ApiException(restException);
        }

        return Page.fromJson(
            "workspaces",
            response.getContent(),
            Workspace.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Workspace> previousPage(
        final Page<Workspace> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Workspace> nextPage(
        final Page<Workspace> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.TASKROUTER.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Workspace> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
