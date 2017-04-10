package com.revature.caliber.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Project: caliber
 *
 * @author d4k1d23
 * @date 1/25/17
 */
public class SalesforceLoginPage {
    private final String usernameBoxId = "username";
    private final String passwordBoxId = "password";
    private final String loginButtonId = "Login";

    private WebDriver driver;
    public SalesforceLoginPage(WebDriver driver){
        this.driver = driver;
        driver.get("http://localhost:8080/");
    }

    public void setUsername(String username) {
        driver.findElement(By.id(usernameBoxId)).sendKeys(username);
        implicitwait();
    }

    public void setPassword(String password) {
        driver.findElement(By.id(passwordBoxId)).sendKeys(password);
        implicitwait();
    }

    public void clickLogin(){
        driver.findElement(By.id(loginButtonId)).click();
        implicitwait();
    }

    private void implicitwait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
