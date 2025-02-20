/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Numbers
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.numbers.v2.regulatorycompliance;

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
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BundleReader extends Reader<Bundle> {

    private Bundle.Status status;
    private String friendlyName;
    private String regulationSid;
    private String isoCountry;
    private String numberType;
    private Boolean hasValidUntilDate;
    private Bundle.SortBy sortBy;
    private Bundle.SortDirection sortDirection;
    private ZonedDateTime validUntilDate;
    private ZonedDateTime validUntilDateBefore;
    private ZonedDateTime validUntilDateAfter;
    private Long pageSize;

    public BundleReader() {}

    public BundleReader setStatus(final Bundle.Status status) {
        this.status = status;
        return this;
    }

    public BundleReader setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public BundleReader setRegulationSid(final String regulationSid) {
        this.regulationSid = regulationSid;
        return this;
    }

    public BundleReader setIsoCountry(final String isoCountry) {
        this.isoCountry = isoCountry;
        return this;
    }

    public BundleReader setNumberType(final String numberType) {
        this.numberType = numberType;
        return this;
    }

    public BundleReader setHasValidUntilDate(final Boolean hasValidUntilDate) {
        this.hasValidUntilDate = hasValidUntilDate;
        return this;
    }

    public BundleReader setSortBy(final Bundle.SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public BundleReader setSortDirection(
        final Bundle.SortDirection sortDirection
    ) {
        this.sortDirection = sortDirection;
        return this;
    }

    public BundleReader setValidUntilDate(final ZonedDateTime validUntilDate) {
        this.validUntilDate = validUntilDate;
        return this;
    }

    public BundleReader setValidUntilDateBefore(
        final ZonedDateTime validUntilDateBefore
    ) {
        this.validUntilDateBefore = validUntilDateBefore;
        return this;
    }

    public BundleReader setValidUntilDateAfter(
        final ZonedDateTime validUntilDateAfter
    ) {
        this.validUntilDateAfter = validUntilDateAfter;
        return this;
    }

    public BundleReader setPageSize(final Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<Bundle> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<Bundle> firstPage(final TwilioRestClient client) {
        String path = "/v2/RegulatoryCompliance/Bundles";

        Request request = new Request(
            HttpMethod.GET,
            Domains.NUMBERS.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<Bundle> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "Bundle read failed: Unable to connect to server"
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
            "results",
            response.getContent(),
            Bundle.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<Bundle> previousPage(
        final Page<Bundle> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.NUMBERS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Bundle> nextPage(
        final Page<Bundle> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.NUMBERS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<Bundle> getPage(
        final String targetUrl,
        final TwilioRestClient client
    ) {
        Request request = new Request(HttpMethod.GET, targetUrl);

        return pageForRequest(client, request);
    }

    private void addQueryParams(final Request request) {
        if (status != null) {
            request.addQueryParam("Status", status.toString());
        }
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        if (regulationSid != null) {
            request.addQueryParam("RegulationSid", regulationSid);
        }
        if (isoCountry != null) {
            request.addQueryParam("IsoCountry", isoCountry);
        }
        if (numberType != null) {
            request.addQueryParam("NumberType", numberType);
        }
        if (hasValidUntilDate != null) {
            request.addQueryParam(
                "HasValidUntilDate",
                hasValidUntilDate.toString()
            );
        }
        if (sortBy != null) {
            request.addQueryParam("SortBy", sortBy.toString());
        }
        if (sortDirection != null) {
            request.addQueryParam("SortDirection", sortDirection.toString());
        }
        if (validUntilDate != null) {
            request.addQueryParam(
                "ValidUntilDate",
                validUntilDate.format(
                    DateTimeFormatter.ofPattern(
                        Request.QUERY_STRING_DATE_TIME_FORMAT
                    )
                )
            );
        } else if (
            validUntilDateAfter != null || validUntilDateBefore != null
        ) {
            request.addQueryDateTimeRange(
                "ValidUntilDate",
                validUntilDateAfter,
                validUntilDateBefore
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
