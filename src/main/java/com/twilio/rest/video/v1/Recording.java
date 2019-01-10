/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording extends Resource {
    private static final long serialVersionUID = 75716728838736L;

    public enum Status {
        PROCESSING("processing"),
        COMPLETED("completed"),
        DELETED("deleted"),
        FAILED("failed");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    public enum Type {
        AUDIO("audio"),
        VIDEO("video"),
        DATA("data");

        private final String value;

        private Type(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Type from a string.
         * @param value string value
         * @return generated Type
         */
        @JsonCreator
        public static Type forValue(final String value) {
            return Promoter.enumFromString(value, Type.values());
        }
    }

    public enum Format {
        MKA("mka"),
        MKV("mkv");

        private final String value;

        private Format(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Format from a string.
         * @param value string value
         * @return generated Format
         */
        @JsonCreator
        public static Format forValue(final String value) {
            return Promoter.enumFromString(value, Format.values());
        }
    }

    public enum Codec {
        VP8("VP8"),
        H264("H264"),
        OPUS("OPUS"),
        PCMU("PCMU");

        private final String value;

        private Codec(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Codec from a string.
         * @param value string value
         * @return generated Codec
         */
        @JsonCreator
        public static Codec forValue(final String value) {
            return Promoter.enumFromString(value, Codec.values());
        }
    }

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param pathSid The Recording Sid that uniquely identifies the Recording to
     *                fetch.
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetcher(final String pathSid) {
        return new RecordingFetcher(pathSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader reader() {
        return new RecordingReader();
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param pathSid The Recording Sid that uniquely identifies the Recording to
     *                delete.
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter deleter(final String pathSid) {
        return new RecordingDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Recording.Status status;
    private final DateTime dateCreated;
    private final String sid;
    private final String sourceSid;
    private final Long size;
    private final URI url;
    private final Recording.Type type;
    private final Integer duration;
    private final Recording.Format containerFormat;
    private final Recording.Codec codec;
    private final Map<String, Object> groupingSids;
    private final String trackName;
    private final Long offset;
    private final Map<String, String> links;

    @JsonCreator
    private Recording(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("status")
                      final Recording.Status status, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("source_sid")
                      final String sourceSid, 
                      @JsonProperty("size")
                      final Long size, 
                      @JsonProperty("url")
                      final URI url, 
                      @JsonProperty("type")
                      final Recording.Type type, 
                      @JsonProperty("duration")
                      final Integer duration, 
                      @JsonProperty("container_format")
                      final Recording.Format containerFormat, 
                      @JsonProperty("codec")
                      final Recording.Codec codec, 
                      @JsonProperty("grouping_sids")
                      final Map<String, Object> groupingSids, 
                      @JsonProperty("track_name")
                      final String trackName, 
                      @JsonProperty("offset")
                      final Long offset, 
                      @JsonProperty("links")
                      final Map<String, String> links) {
        this.accountSid = accountSid;
        this.status = status;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.sid = sid;
        this.sourceSid = sourceSid;
        this.size = size;
        this.url = url;
        this.type = type;
        this.duration = duration;
        this.containerFormat = containerFormat;
        this.codec = codec;
        this.groupingSids = groupingSids;
        this.trackName = trackName;
        this.offset = offset;
        this.links = links;
    }

    /**
     * Returns The Twilio Account SID..
     * 
     * @return Twilio Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The status of the Recording..
     * 
     * @return The status of the Recording.
     */
    public final Recording.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The Date when the media recording began writing..
     * 
     * @return Date when the media recording began writing.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The A 34-character string that uniquely identifies this Recording..
     * 
     * @return A 34-character string that uniquely identifies this Recording.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The A 34-character string that uniquely identifies the source of this
     * Recording..
     * 
     * @return A 34-character string that uniquely identifies the source of this
     *         Recording.
     */
    public final String getSourceSid() {
        return this.sourceSid;
    }

    /**
     * Returns The Size of the recorded track, in bytes..
     * 
     * @return Size of the recorded track, in bytes.
     */
    public final Long getSize() {
        return this.size;
    }

    /**
     * Returns The The absolute URL for this resource..
     * 
     * @return The absolute URL for this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The Indicates the media type for this recording..
     * 
     * @return Indicates the media type for this recording.
     */
    public final Recording.Type getType() {
        return this.type;
    }

    /**
     * Returns The Duration of the Recording in seconds..
     * 
     * @return Duration of the Recording in seconds.
     */
    public final Integer getDuration() {
        return this.duration;
    }

    /**
     * Returns The The file format for this Recording..
     * 
     * @return The file format for this Recording.
     */
    public final Recording.Format getContainerFormat() {
        return this.containerFormat;
    }

    /**
     * Returns The The codec used to encode the track..
     * 
     * @return The codec used to encode the track.
     */
    public final Recording.Codec getCodec() {
        return this.codec;
    }

    /**
     * Returns The A list of Sids related to this Recording..
     * 
     * @return A list of Sids related to this Recording.
     */
    public final Map<String, Object> getGroupingSids() {
        return this.groupingSids;
    }

    /**
     * Returns The The name that was given to the source track of this recording..
     * 
     * @return The name that was given to the source track of this recording.
     */
    public final String getTrackName() {
        return this.trackName;
    }

    /**
     * Returns The Offset in milliseconds for this track..
     * 
     * @return Offset in milliseconds for this track.
     */
    public final Long getOffset() {
        return this.offset;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Recording other = (Recording) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(status, other.status) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(sourceSid, other.sourceSid) && 
               Objects.equals(size, other.size) && 
               Objects.equals(url, other.url) && 
               Objects.equals(type, other.type) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(containerFormat, other.containerFormat) && 
               Objects.equals(codec, other.codec) && 
               Objects.equals(groupingSids, other.groupingSids) && 
               Objects.equals(trackName, other.trackName) && 
               Objects.equals(offset, other.offset) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            status,
                            dateCreated,
                            sid,
                            sourceSid,
                            size,
                            url,
                            type,
                            duration,
                            containerFormat,
                            codec,
                            groupingSids,
                            trackName,
                            offset,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("status", status)
                          .add("dateCreated", dateCreated)
                          .add("sid", sid)
                          .add("sourceSid", sourceSid)
                          .add("size", size)
                          .add("url", url)
                          .add("type", type)
                          .add("duration", duration)
                          .add("containerFormat", containerFormat)
                          .add("codec", codec)
                          .add("groupingSids", groupingSids)
                          .add("trackName", trackName)
                          .add("offset", offset)
                          .add("links", links)
                          .toString();
    }
}