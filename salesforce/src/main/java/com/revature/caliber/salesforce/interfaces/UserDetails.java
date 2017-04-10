package com.revature.caliber.salesforce.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * Project: caliber
 *
 * @author d4k1d23
 * @date 1/25/17
 */
public interface UserDetails {
    /**
     * Gets the in salesforce user
     * @param accessToken
     * @param endpoint the id field of the salesforce token
     * @return JSON representation of the salesforce user
     * @throws NullPointerException if the user is not authenticated with salesforce
     * @throws IOException
     */
    String getSalesforceUser(String accessToken, String endpoint) throws NullPointerException, IOException;
}
