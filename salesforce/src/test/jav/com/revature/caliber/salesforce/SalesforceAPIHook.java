package com.revature.caliber.salesforce;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Project: caliber
 *
 * @author d4k1d23
 * @date 1/25/17
 */
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/authentication.feature"})
public class SalesforceAPIHook {
}
