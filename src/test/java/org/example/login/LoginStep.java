package org.example.login;

import io.cucumber.java.en.*;
import org.example.object.Hooks;
import org.example.object.BaseUrl;
import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStep {
    WebDriver driver;
    BaseUrl baseUrl;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = Hooks.getDriver();
        baseUrl = new BaseUrl(); // Initialize baseUrl object
        driver.get(baseUrl.getBaseUrl() + "/login");
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage = new LoginPage(driver); // Initialize loginPage object
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be redirected to the main dashboard")
    public void the_user_should_be_redirected_to_the_main_dashboard() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("dashboard"));
            String currentUrl = driver.getCurrentUrl();

            assert currentUrl.contains("dashboard");
            Hooks.loginTest.pass("aziz login");
        }
        catch (Exception e){
            Hooks.loginTest.fail("login fail");
        }
    }
}
