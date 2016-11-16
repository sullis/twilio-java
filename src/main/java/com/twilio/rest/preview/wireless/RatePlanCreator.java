/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.preview.wireless;

import com.twilio.base.Creator;
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

public class RatePlanCreator extends Creator<RatePlan> {
    private String alias;
    private String friendlyName;
    private List<String> roaming;
    private Integer dataLimit;
    private String dataMetering;
    private Boolean commandsEnabled;
    private Integer renewalPeriod;
    private String renewalUnits;

    /**
     * The alias.
     * 
     * @param alias The alias
     * @return this
     */
    public RatePlanCreator setAlias(final String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public RatePlanCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The roaming.
     * 
     * @param roaming The roaming
     * @return this
     */
    public RatePlanCreator setRoaming(final List<String> roaming) {
        this.roaming = roaming;
        return this;
    }

    /**
     * The roaming.
     * 
     * @param roaming The roaming
     * @return this
     */
    public RatePlanCreator setRoaming(final String roaming) {
        return setRoaming(Promoter.listOfOne(roaming));
    }

    /**
     * The data_limit.
     * 
     * @param dataLimit The data_limit
     * @return this
     */
    public RatePlanCreator setDataLimit(final Integer dataLimit) {
        this.dataLimit = dataLimit;
        return this;
    }

    /**
     * The data_metering.
     * 
     * @param dataMetering The data_metering
     * @return this
     */
    public RatePlanCreator setDataMetering(final String dataMetering) {
        this.dataMetering = dataMetering;
        return this;
    }

    /**
     * The commands_enabled.
     * 
     * @param commandsEnabled The commands_enabled
     * @return this
     */
    public RatePlanCreator setCommandsEnabled(final Boolean commandsEnabled) {
        this.commandsEnabled = commandsEnabled;
        return this;
    }

    /**
     * The renewal_period.
     * 
     * @param renewalPeriod The renewal_period
     * @return this
     */
    public RatePlanCreator setRenewalPeriod(final Integer renewalPeriod) {
        this.renewalPeriod = renewalPeriod;
        return this;
    }

    /**
     * The renewal_units.
     * 
     * @param renewalUnits The renewal_units
     * @return this
     */
    public RatePlanCreator setRenewalUnits(final String renewalUnits) {
        this.renewalUnits = renewalUnits;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created RatePlan
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public RatePlan create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/wireless/RatePlans",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("RatePlan creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return RatePlan.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (alias != null) {
            request.addPostParam("Alias", alias);
        }
        
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (roaming != null) {
            for (String prop : roaming) {
                request.addPostParam("Roaming", prop);
            }
        }
        
        if (dataLimit != null) {
            request.addPostParam("DataLimit", dataLimit.toString());
        }
        
        if (dataMetering != null) {
            request.addPostParam("DataMetering", dataMetering);
        }
        
        if (commandsEnabled != null) {
            request.addPostParam("CommandsEnabled", commandsEnabled.toString());
        }
        
        if (renewalPeriod != null) {
            request.addPostParam("RenewalPeriod", renewalPeriod.toString());
        }
        
        if (renewalUnits != null) {
            request.addPostParam("RenewalUnits", renewalUnits);
        }
    }
}