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

package com.twilio.rest.numbers.v2.authorizationdocument;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class DependentHostedNumberOrderReader
    extends Reader<DependentHostedNumberOrder> {

    private String pathSigningDocumentSid;
    private DependentHostedNumberOrder.Status status;
    private com.twilio.type.PhoneNumber phoneNumber;
    private String incomingPhoneNumberSid;
    private String friendlyName;
    private Integer pageSize;

    public DependentHostedNumberOrderReader(
        final String pathSigningDocumentSid
    ) {
        this.pathSigningDocumentSid = pathSigningDocumentSid;
    }

    public DependentHostedNumberOrderReader setStatus(
        final DependentHostedNumberOrder.Status status
    ) {
        this.status = status;
        return this;
    }

    public DependentHostedNumberOrderReader setPhoneNumber(
        final com.twilio.type.PhoneNumber phoneNumber
    ) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public DependentHostedNumberOrderReader setPhoneNumber(
        final String phoneNumber
    ) {
        return setPhoneNumber(Promoter.phoneNumberFromString(phoneNumber));
    }

    public DependentHostedNumberOrderReader setIncomingPhoneNumberSid(
        final String incomingPhoneNumberSid
    ) {
        this.incomingPhoneNumberSid = incomingPhoneNumberSid;
        return this;
    }

    public DependentHostedNumberOrderReader setFriendlyName(
        final String friendlyName
    ) {
        this.friendlyName = friendlyName;
        return this;
    }

    public DependentHostedNumberOrderReader setPageSize(
        final Integer pageSize
    ) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public ResourceSet<DependentHostedNumberOrder> read(
        final TwilioRestClient client
    ) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    public Page<DependentHostedNumberOrder> firstPage(
        final TwilioRestClient client
    ) {
        String path =
            "/v2/HostedNumber/AuthorizationDocuments/{SigningDocumentSid}/DependentHostedNumberOrders";
        path =
            path.replace(
                "{" + "SigningDocumentSid" + "}",
                this.pathSigningDocumentSid.toString()
            );

        Request request = new Request(
            HttpMethod.GET,
            Domains.NUMBERS.toString(),
            path
        );

        addQueryParams(request);
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        return pageForRequest(client, request);
    }

    private Page<DependentHostedNumberOrder> pageForRequest(
        final TwilioRestClient client,
        final Request request
    ) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "DependentHostedNumberOrder read failed: Unable to connect to server"
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
            "items",
            response.getContent(),
            DependentHostedNumberOrder.class,
            client.getObjectMapper()
        );
    }

    @Override
    public Page<DependentHostedNumberOrder> previousPage(
        final Page<DependentHostedNumberOrder> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(Domains.NUMBERS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<DependentHostedNumberOrder> nextPage(
        final Page<DependentHostedNumberOrder> page,
        final TwilioRestClient client
    ) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(Domains.NUMBERS.toString())
        );
        return pageForRequest(client, request);
    }

    @Override
    public Page<DependentHostedNumberOrder> getPage(
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
        if (phoneNumber != null) {
            request.addQueryParam("PhoneNumber", phoneNumber.toString());
        }
        if (incomingPhoneNumberSid != null) {
            request.addQueryParam(
                "IncomingPhoneNumberSid",
                incomingPhoneNumberSid
            );
        }
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
