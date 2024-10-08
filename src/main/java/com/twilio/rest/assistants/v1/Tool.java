/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Assistants
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.assistants.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Map;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Tool extends Resource {

    private static final long serialVersionUID = 250744757874592L;

    @ToString
    public static class AssistantsV1ServiceCreatePolicyRequest {

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("description")
        @Getter
        @Setter
        private String description;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("id")
        @Getter
        @Setter
        private String id;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("name")
        @Getter
        @Setter
        private String name;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("policy_details")
        @Getter
        @Setter
        private Map<String, Object> policyDetails;

        public String getPolicyDetails() {
            return Converter.mapToJson(policyDetails);
        }

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("type")
        @Getter
        @Setter
        private String type;

        public static AssistantsV1ServiceCreatePolicyRequest fromJson(
            String jsonString,
            ObjectMapper mapper
        ) throws IOException {
            return mapper.readValue(
                jsonString,
                AssistantsV1ServiceCreatePolicyRequest.class
            );
        }
    }

    @ToString
    public static class AssistantsV1ServiceCreateToolRequest {

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("assistant_id")
        @Getter
        @Setter
        private String assistantId;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("description")
        @Getter
        @Setter
        private String description;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("enabled")
        @Getter
        @Setter
        private Boolean enabled;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("meta")
        @Getter
        @Setter
        private Map<String, Object> meta;

        public String getMeta() {
            return Converter.mapToJson(meta);
        }

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("name")
        @Getter
        @Setter
        private String name;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("policy")
        @Getter
        @Setter
        private AssistantsV1ServiceCreatePolicyRequest policy;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("type")
        @Getter
        @Setter
        private String type;

        public AssistantsV1ServiceCreateToolRequest() {}

        public static AssistantsV1ServiceCreateToolRequest fromJson(
            String jsonString,
            ObjectMapper mapper
        ) throws IOException {
            return mapper.readValue(
                jsonString,
                AssistantsV1ServiceCreateToolRequest.class
            );
        }
    }

    @ToString
    public static class AssistantsV1ServiceUpdateToolRequest {

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("assistant_id")
        @Getter
        @Setter
        private String assistantId;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("description")
        @Getter
        @Setter
        private String description;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("enabled")
        @Getter
        @Setter
        private Boolean enabled;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("meta")
        @Getter
        @Setter
        private Map<String, Object> meta;

        public String getMeta() {
            return Converter.mapToJson(meta);
        }

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("name")
        @Getter
        @Setter
        private String name;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("policy")
        @Getter
        @Setter
        private AssistantsV1ServiceCreatePolicyRequest policy;

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        @JsonProperty("type")
        @Getter
        @Setter
        private String type;

        public AssistantsV1ServiceUpdateToolRequest() {}

        public static AssistantsV1ServiceUpdateToolRequest fromJson(
            String jsonString,
            ObjectMapper mapper
        ) throws IOException {
            return mapper.readValue(
                jsonString,
                AssistantsV1ServiceUpdateToolRequest.class
            );
        }
    }

    public static ToolCreator creator(
        final Tool.AssistantsV1ServiceCreateToolRequest assistantsV1ServiceCreateToolRequest
    ) {
        return new ToolCreator(assistantsV1ServiceCreateToolRequest);
    }

    public static ToolDeleter deleter(final String pathId) {
        return new ToolDeleter(pathId);
    }

    public static ToolReader reader() {
        return new ToolReader();
    }

    public static ToolUpdater updater(final String pathId) {
        return new ToolUpdater(pathId);
    }

    /**
     * Converts a JSON String into a Tool object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Tool object represented by the provided JSON
     */
    public static Tool fromJson(
        final String json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Tool.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Tool object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Tool object represented by the provided JSON
     */
    public static Tool fromJson(
        final InputStream json,
        final ObjectMapper objectMapper
    ) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Tool.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    public static String toJson(Object object, ObjectMapper mapper) {
        try {
            return mapper.writeValueAsString(object);
        } catch (final JsonMappingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (JsonProcessingException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String description;
    private final Boolean enabled;
    private final String id;
    private final Map<String, Object> meta;
    private final String name;
    private final Boolean requiresAuth;
    private final String type;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;

    @JsonCreator
    private Tool(
        @JsonProperty("account_sid") final String accountSid,
        @JsonProperty("description") final String description,
        @JsonProperty("enabled") final Boolean enabled,
        @JsonProperty("id") final String id,
        @JsonProperty("meta") final Map<String, Object> meta,
        @JsonProperty("name") final String name,
        @JsonProperty("requires_auth") final Boolean requiresAuth,
        @JsonProperty("type") final String type,
        @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("date_updated") final String dateUpdated
    ) {
        this.accountSid = accountSid;
        this.description = description;
        this.enabled = enabled;
        this.id = id;
        this.meta = meta;
        this.name = name;
        this.requiresAuth = requiresAuth;
        this.type = type;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
    }

    public final String getAccountSid() {
        return this.accountSid;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, Object> getMeta() {
        return this.meta;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getRequiresAuth() {
        return this.requiresAuth;
    }

    public final String getType() {
        return this.type;
    }

    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Tool other = (Tool) o;

        return (
            Objects.equals(accountSid, other.accountSid) &&
            Objects.equals(description, other.description) &&
            Objects.equals(enabled, other.enabled) &&
            Objects.equals(id, other.id) &&
            Objects.equals(meta, other.meta) &&
            Objects.equals(name, other.name) &&
            Objects.equals(requiresAuth, other.requiresAuth) &&
            Objects.equals(type, other.type) &&
            Objects.equals(dateCreated, other.dateCreated) &&
            Objects.equals(dateUpdated, other.dateUpdated)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            accountSid,
            description,
            enabled,
            id,
            meta,
            name,
            requiresAuth,
            type,
            dateCreated,
            dateUpdated
        );
    }
}
