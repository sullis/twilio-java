/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trusthub.v1.customerprofiles;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class CustomerProfilesChannelEndpointAssignment extends Resource {
    private static final long serialVersionUID = 104533299645762L;

    /**
     * Create a CustomerProfilesChannelEndpointAssignmentCreator to execute create.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     * @param channelEndpointType The type of channel endpoint
     * @param channelEndpointSid The sid of an channel endpoint
     * @return CustomerProfilesChannelEndpointAssignmentCreator capable of
     *         executing the create
     */
    public static CustomerProfilesChannelEndpointAssignmentCreator creator(final String pathCustomerProfileSid,
                                                                           final String channelEndpointType,
                                                                           final String channelEndpointSid) {
        return new CustomerProfilesChannelEndpointAssignmentCreator(pathCustomerProfileSid, channelEndpointType, channelEndpointSid);
    }

    /**
     * Create a CustomerProfilesChannelEndpointAssignmentReader to execute read.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     * @return CustomerProfilesChannelEndpointAssignmentReader capable of executing
     *         the read
     */
    public static CustomerProfilesChannelEndpointAssignmentReader reader(final String pathCustomerProfileSid) {
        return new CustomerProfilesChannelEndpointAssignmentReader(pathCustomerProfileSid);
    }

    /**
     * Create a CustomerProfilesChannelEndpointAssignmentFetcher to execute fetch.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     * @param pathSid The unique string that identifies the resource
     * @return CustomerProfilesChannelEndpointAssignmentFetcher capable of
     *         executing the fetch
     */
    public static CustomerProfilesChannelEndpointAssignmentFetcher fetcher(final String pathCustomerProfileSid,
                                                                           final String pathSid) {
        return new CustomerProfilesChannelEndpointAssignmentFetcher(pathCustomerProfileSid, pathSid);
    }

    /**
     * Create a CustomerProfilesChannelEndpointAssignmentDeleter to execute delete.
     *
     * @param pathCustomerProfileSid The unique string that identifies the resource.
     * @param pathSid The unique string that identifies the resource
     * @return CustomerProfilesChannelEndpointAssignmentDeleter capable of
     *         executing the delete
     */
    public static CustomerProfilesChannelEndpointAssignmentDeleter deleter(final String pathCustomerProfileSid,
                                                                           final String pathSid) {
        return new CustomerProfilesChannelEndpointAssignmentDeleter(pathCustomerProfileSid, pathSid);
    }

    /**
     * Converts a JSON String into a CustomerProfilesChannelEndpointAssignment
     * object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return CustomerProfilesChannelEndpointAssignment object represented by the
     *         provided JSON
     */
    public static CustomerProfilesChannelEndpointAssignment fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CustomerProfilesChannelEndpointAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a CustomerProfilesChannelEndpointAssignment
     * object using the provided ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return CustomerProfilesChannelEndpointAssignment object represented by the
     *         provided JSON
     */
    public static CustomerProfilesChannelEndpointAssignment fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CustomerProfilesChannelEndpointAssignment.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String customerProfileSid;
    private final String accountSid;
    private final String channelEndpointType;
    private final String channelEndpointSid;
    private final ZonedDateTime dateCreated;
    private final URI url;

    @JsonCreator
    private CustomerProfilesChannelEndpointAssignment(@JsonProperty("sid")
                                                      final String sid,
                                                      @JsonProperty("customer_profile_sid")
                                                      final String customerProfileSid,
                                                      @JsonProperty("account_sid")
                                                      final String accountSid,
                                                      @JsonProperty("channel_endpoint_type")
                                                      final String channelEndpointType,
                                                      @JsonProperty("channel_endpoint_sid")
                                                      final String channelEndpointSid,
                                                      @JsonProperty("date_created")
                                                      final String dateCreated,
                                                      @JsonProperty("url")
                                                      final URI url) {
        this.sid = sid;
        this.customerProfileSid = customerProfileSid;
        this.accountSid = accountSid;
        this.channelEndpointType = channelEndpointType;
        this.channelEndpointSid = channelEndpointSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.url = url;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The unique string that identifies the CustomerProfile resource..
     *
     * @return The unique string that identifies the CustomerProfile resource.
     */
    public final String getCustomerProfileSid() {
        return this.customerProfileSid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The type of channel endpoint.
     *
     * @return The type of channel endpoint
     */
    public final String getChannelEndpointType() {
        return this.channelEndpointType;
    }

    /**
     * Returns The sid of an channel endpoint.
     *
     * @return The sid of an channel endpoint
     */
    public final String getChannelEndpointSid() {
        return this.channelEndpointSid;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The absolute URL of the Identity resource.
     *
     * @return The absolute URL of the Identity resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerProfilesChannelEndpointAssignment other = (CustomerProfilesChannelEndpointAssignment) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(customerProfileSid, other.customerProfileSid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(channelEndpointType, other.channelEndpointType) &&
               Objects.equals(channelEndpointSid, other.channelEndpointSid) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            customerProfileSid,
                            accountSid,
                            channelEndpointType,
                            channelEndpointSid,
                            dateCreated,
                            url);
    }
}