/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v2.flow;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

public class ExecutionCreator extends Creator<Execution> {
    private final String pathFlowSid;
    private final com.twilio.type.PhoneNumber to;
    private final com.twilio.type.PhoneNumber from;
    private Map<String, Object> parameters;

    /**
     * Construct a new ExecutionCreator.
     *
     * @param pathFlowSid The SID of the Flow
     * @param to The Contact phone number to start a Studio Flow Execution
     * @param from The Twilio phone number to send messages or initiate calls from
     *             during the Flow Execution
     */
    public ExecutionCreator(final String pathFlowSid,
                            final com.twilio.type.PhoneNumber to,
                            final com.twilio.type.PhoneNumber from) {
        this.pathFlowSid = pathFlowSid;
        this.to = to;
        this.from = from;
    }

    /**
     * JSON data that will be added to the Flow's context and that can be accessed
     * as variables inside your Flow. For example, if you pass in
     * `Parameters={"name":"Zeke"}`, a widget in your Flow can reference the
     * variable `{{flow.data.name}}`, which returns "Zeke". Note: the JSON value
     * must explicitly be passed as a string, not as a hash object. Depending on
     * your particular HTTP library, you may need to add quotes or URL encode the
     * JSON string..
     *
     * @param parameters JSON data that will be added to the Flow's context
     * @return this
     */
    public ExecutionCreator setParameters(final Map<String, Object> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Execution
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Execution create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.STUDIO.toString(),
            "/v2/Flows/" + this.pathFlowSid + "/Executions"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Execution creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Execution.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to.toString());
        }

        if (from != null) {
            request.addPostParam("From", from.toString());
        }

        if (parameters != null) {
            request.addPostParam("Parameters", Converter.mapToJson(parameters));
        }
    }
}