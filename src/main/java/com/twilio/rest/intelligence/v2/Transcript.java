/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Intelligence
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.intelligence.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Transcript extends Resource {
    private static final long serialVersionUID = 35462753187463L;

    public static TranscriptCreator creator(final String serviceSid, final Map<String, Object> channel){
        return new TranscriptCreator(serviceSid, channel);
    }

    public static TranscriptDeleter deleter(final String pathSid){
        return new TranscriptDeleter(pathSid);
    }

    public static TranscriptFetcher fetcher(final String pathSid){
        return new TranscriptFetcher(pathSid);
    }

    public static TranscriptReader reader(){
        return new TranscriptReader();
    }

    /**
    * Converts a JSON String into a Transcript object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return Transcript object represented by the provided JSON
    */
    public static Transcript fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcript.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a Transcript object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return Transcript object represented by the provided JSON
    */
    public static Transcript fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcript.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }
    public enum Status {
        QUEUED("queued"),
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        FAILED("failed"),
        CANCELED("canceled");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    private final String accountSid;
    private final String serviceSid;
    private final String sid;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Transcript.Status status;
    private final Map<String, Object> channel;
    private final Boolean dataLogging;
    private final String languageCode;
    private final String customerKey;
    private final ZonedDateTime mediaStartTime;
    private final Integer duration;
    private final URI url;
    private final Boolean redaction;
    private final Map<String, String> links;

    @JsonCreator
    private Transcript(
        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("service_sid")
        final String serviceSid,

        @JsonProperty("sid")
        final String sid,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("status")
        final Transcript.Status status,

        @JsonProperty("channel")
        final Map<String, Object> channel,

        @JsonProperty("data_logging")
        final Boolean dataLogging,

        @JsonProperty("language_code")
        final String languageCode,

        @JsonProperty("customer_key")
        final String customerKey,

        @JsonProperty("media_start_time")
        final String mediaStartTime,

        @JsonProperty("duration")
        final Integer duration,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("redaction")
        final Boolean redaction,

        @JsonProperty("links")
        final Map<String, String> links
    ) {
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.sid = sid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.status = status;
        this.channel = channel;
        this.dataLogging = dataLogging;
        this.languageCode = languageCode;
        this.customerKey = customerKey;
        this.mediaStartTime = DateConverter.iso8601DateTimeFromString(mediaStartTime);
        this.duration = duration;
        this.url = url;
        this.redaction = redaction;
        this.links = links;
    }

        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getServiceSid() {
            return this.serviceSid;
        }
        public final String getSid() {
            return this.sid;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final Transcript.Status getStatus() {
            return this.status;
        }
        public final Map<String, Object> getChannel() {
            return this.channel;
        }
        public final Boolean getDataLogging() {
            return this.dataLogging;
        }
        public final String getLanguageCode() {
            return this.languageCode;
        }
        public final String getCustomerKey() {
            return this.customerKey;
        }
        public final ZonedDateTime getMediaStartTime() {
            return this.mediaStartTime;
        }
        public final Integer getDuration() {
            return this.duration;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Boolean getRedaction() {
            return this.redaction;
        }
        public final Map<String, String> getLinks() {
            return this.links;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Transcript other = (Transcript) o;

        return Objects.equals(accountSid, other.accountSid) &&  Objects.equals(serviceSid, other.serviceSid) &&  Objects.equals(sid, other.sid) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(status, other.status) &&  Objects.equals(channel, other.channel) &&  Objects.equals(dataLogging, other.dataLogging) &&  Objects.equals(languageCode, other.languageCode) &&  Objects.equals(customerKey, other.customerKey) &&  Objects.equals(mediaStartTime, other.mediaStartTime) &&  Objects.equals(duration, other.duration) &&  Objects.equals(url, other.url) &&  Objects.equals(redaction, other.redaction) &&  Objects.equals(links, other.links)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid, serviceSid, sid, dateCreated, dateUpdated, status, channel, dataLogging, languageCode, customerKey, mediaStartTime, duration, url, redaction, links);
    }

}

