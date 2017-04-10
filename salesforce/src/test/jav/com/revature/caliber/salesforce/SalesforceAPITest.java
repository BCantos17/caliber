package com.revature.caliber.salesforce;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Project: caliber
 *
 * @author d4k1d23
 * @date 1/25/17
 */
public class SalesforceAPITest {
    Map<String, String> environment = System.getenv();
    private String CHROME_DRIVER_PATH = environment.get("CHROME_DRIVER_PATH");
    private static WebDriver driver;
    private SalesforceLoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @When("^I navigate to the caliber homepage$")
    public void i_navigate_to_the_caliber_homepage() throws Throwable {
        loginPage = new SalesforceLoginPage(driver);
    }

    @When("^I enter my username and my password$")
    public void i_enter_my_username_and_my_password() throws Throwable {
        loginPage.setUsername("testrevature@gmail.com");
        loginPage.setPassword("testing123");
    }

    @Then("^I will be redirected to the caliber homepage$")
    public void i_will_be_redirected_to_the_caliber_homepage() throws Throwable {
        loginPage.clickLogin();
        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
    }
}
