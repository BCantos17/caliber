package com.revature.caliber.salesforce.interfaces;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Martino on 1/25/2017.
 */
public interface Authorization {

    /**
     * Generates authURI with provided parameters
     * @return view of the generated URI
     */
    ModelAndView openAuthURI();
    /**
     * Creates salesforce token and saves it as a session cookie
     * @param code the string returned from the authURI required for getting token from salesforce
     * @param httpServletResponse
     * @return back to the application
     * @throws IOException
     */
    ModelAndView generateSalesforceToken(String code, HttpServletResponse httpServletResponse) throws IOException;
}
