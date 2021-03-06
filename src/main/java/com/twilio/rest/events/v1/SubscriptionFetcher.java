/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SubscriptionFetcher extends Fetcher<Subscription> {
    private final String pathSid;

    /**
     * Construct a new SubscriptionFetcher.
     *
     * @param pathSid A string that uniquely identifies this Subscription.
     */
    public SubscriptionFetcher(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Subscription
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Subscription fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.EVENTS.toString(),
            "/v1/Subscriptions/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Subscription fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Subscription.fromJson(response.getStream(), client.getObjectMapper());
    }
}