/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Events
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.events.v1;

import com.twilio.base.Creator;
import com.twilio.constant.EnumConstants;
import com.twilio.converter.Converter;
import com.twilio.converter.Converter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Map;

public class SubscriptionCreator extends Creator<Subscription> {

    private String description;
    private String sinkSid;
    private List<Map<String, Object>> types;
    private Boolean receiveEventsFromSubaccounts;

    public SubscriptionCreator(
        final String description,
        final String sinkSid,
        final List<Map<String, Object>> types
    ) {
        this.description = description;
        this.sinkSid = sinkSid;
        this.types = types;
    }

    public SubscriptionCreator setDescription(final String description) {
        this.description = description;
        return this;
    }

    public SubscriptionCreator setSinkSid(final String sinkSid) {
        this.sinkSid = sinkSid;
        return this;
    }

    public SubscriptionCreator setTypes(final List<Map<String, Object>> types) {
        this.types = types;
        return this;
    }

    public SubscriptionCreator setTypes(final Map<String, Object> types) {
        return setTypes(Promoter.listOfOne(types));
    }

    public SubscriptionCreator setReceiveEventsFromSubaccounts(
        final Boolean receiveEventsFromSubaccounts
    ) {
        this.receiveEventsFromSubaccounts = receiveEventsFromSubaccounts;
        return this;
    }

    @Override
    public Subscription create(final TwilioRestClient client) {
        String path = "/v1/Subscriptions";

        path =
            path.replace(
                "{" + "Description" + "}",
                this.description.toString()
            );
        path = path.replace("{" + "SinkSid" + "}", this.sinkSid.toString());
        path = path.replace("{" + "Types" + "}", this.types.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.EVENTS.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException(
                "Subscription creation failed: Unable to connect to server"
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

        return Subscription.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }

    private void addPostParams(final Request request) {
        if (description != null) {
            request.addPostParam("Description", description);
        }
        if (sinkSid != null) {
            request.addPostParam("SinkSid", sinkSid);
        }
        if (types != null) {
            for (Map<String, Object> prop : types) {
                request.addPostParam("Types", Converter.mapToJson(prop));
            }
        }
        if (receiveEventsFromSubaccounts != null) {
            request.addPostParam(
                "ReceiveEventsFromSubaccounts",
                receiveEventsFromSubaccounts.toString()
            );
        }
    }
}
