/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.call;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RecordingReader extends Reader<Recording> {

    private String pathCallSid;
    private String pathAccountSid;
    private LocalDate dateCreated;
    private LocalDate dateCreatedBefore;
    private LocalDate dateCreatedAfter;
    private Long pageSize;

    public RecordingReader(final String pathCallSid) {
        this.pathCallSid = pathCallSid;
    }

    public RecordingReader(
        final String pathAccountSid,
        final String pathCallSid
    ) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
    }

    public RecordingReader setDateCreated(final LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public RecordingReader setDateCreatedBefore(
        final LocalDate dateCreatedBefore
    ) {
        this.dateCreatedBefore = dateCreatedBefore;
        return this;
    }

    public RecordingReader setDateCreatedAfter(
        final LocalDate dateCreatedAfter
    ) {
        this.dateCreatedAfter = dateCreatedAfter;
        return this;
    }

    public RecordingReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Recording> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Recording> firstPage(final TwilioRestClient client) {
        String path =
            "/2010-04-01/Accounts/{AccountSid}/Calls/{CallSid}/Recordings.json";
        this.pathAccountSid =
            this.pathAccountSid == null
                ? client.getAccountSid()
                : this.pathAccountSid;
        path =
            path.replace(
                "{" + "AccountSid" + "}",
                this.pathAccountSid.toString()
            );
        path = path.replace("{" + "CallSid" + "}", this.pathCallSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Recording> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Recording read failed: Unable to connect to server"
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
            "recordings",
            response.getContent(),
            Recording.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Recording> previousPage(
        final Page<Recording> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Recording> nextPage(
        final Page<Recording> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.API.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Recording> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (dateCreated != null) {
            request.addQueryParam(
                "DateCreated",
                dateCreated.format(
                    DateTimeFormatter.ofPattern(
                        Request.QUERY_STRING_DATE_FORMAT
                    )
                )
            );
        } else if (dateCreatedAfter != null || dateCreatedBefore != null) {
            request.addQueryDateRange(
                "DateCreated",
                dateCreatedAfter,
                dateCreatedBefore
            );
        }
        if (pageSize != null) {
            request.addQueryParam("PageSize", pageSize.toString());
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}
