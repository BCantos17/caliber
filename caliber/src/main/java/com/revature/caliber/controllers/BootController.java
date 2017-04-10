package com.revature.caliber.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.caliber.Helper;
import com.revature.caliber.models.SalesforceToken;
import com.revature.caliber.models.SalesforceUser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;

/**
 * The type Boot controller.
 */
@Controller
@SessionAttributes("token")
public class BootController extends Helper {
    /**
     * The Token.
     */
    SalesforceToken token;
    /**
     * The Http client.
     */
    HttpClient httpClient;

    /**
     * Instantiates a new Boot controller.
     */
    public BootController() {
        httpClient = HttpClientBuilder.create().build();
    }

    /**
     * Gets home page.
     *
     * @param servletRequest  the servlet request
     * @param servletResponse the servlet response
     * @return the home page
     * @throws IOException        the io exception
     * @throws URISyntaxException the uri syntax exception
     */
    @RequestMapping(value = "/")
    public String getHomePage(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException, URISyntaxException {
        Cookie[] cookies = servletRequest.getCookies();
        SalesforceToken salesforceToken = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                salesforceToken = new ObjectMapper().readValue(URLDecoder.decode(cookie.getValue(), "UTF-8"), SalesforceToken.class);
                break;
            }
        }
        //Http request to the salesforce module to get the salesforce user
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme(servletRequest.getScheme())
                .setHost(servletRequest.getServerName())
                .setPort(servletRequest.getServerPort())
                .setPath("/getSalesforceUser/")
                .setParameter("endpoint", salesforceToken.getId())
                .setParameter("accessToken", salesforceToken.getAccessToken());
        URI uri = uriBuilder.build();
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httpGet);
        String user = toJsonString(response.getEntity().getContent());
        SalesforceUser salesforceUser = new ObjectMapper().readValue(user, SalesforceUser.class);
        salesforceUser.setSalesforceToken(salesforceToken);

        //Http request to the training module to get the caliber user
        String email = salesforceUser.getEmail();
        uriBuilder = new URIBuilder();
        uriBuilder.setScheme(servletRequest.getScheme())
                .setHost(servletRequest.getServerName())
                .setPort(servletRequest.getServerPort())
                .setPath("/training/trainers/byemail/" + email + "/");
        uri = uriBuilder.build();
        httpGet = new HttpGet(uri);
        response = httpClient.execute(httpGet);
        String jsonString = toJsonString(response.getEntity().getContent());
        JSONObject jsonObject = new JSONObject(jsonString);
        if (jsonObject.getString("email").equals(salesforceUser.getEmail()))
            salesforceUser.setRole(jsonObject.getJSONObject("tier").getString("tier"));
        else throw new NullPointerException("No such user");
        salesforceUser.setCaliberId(jsonObject.getInt("trainerId"));
        Authentication auth = new PreAuthenticatedAuthenticationToken(salesforceUser, salesforceUser.getUser_id(), salesforceUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        servletResponse.addCookie(new Cookie("role", jsonObject.getJSONObject("tier").getString("tier")));
        return "index";
    }
}
