/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trunking
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Fetcher;
import com.twilio.constant.EnumConstants;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class PhoneNumberFetcher extends Fetcher<PhoneNumber> {

    private String pathTrunkSid;
    private String pathSid;

    public PhoneNumberFetcher(final String pathTrunkSid, final String pathSid) {
        this.pathTrunkSid = pathTrunkSid;
        this.pathSid = pathSid;
    }

    @Override
    public PhoneNumber fetch(final TwilioRestClient client) {
        String path = "/v1/Trunks/{TrunkSid}/PhoneNumbers/{Sid}";

        path =
            path.replace("{" + "TrunkSid" + "}", this.pathTrunkSid.toString());
        path = path.replace("{" + "Sid" + "}", this.pathSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUNKING.toString(),
            path
        );
        request.setContentType(EnumConstants.ContentType.FORM_URLENCODED);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "PhoneNumber fetch failed: Unable to connect to server"
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

        return PhoneNumber.fromJson(
            response.getStream(),
            client.getObjectMapper()
        );
    }
}
