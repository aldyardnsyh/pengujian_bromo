package org.example.logout;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.example.object.Hooks;
import org.example.object.BaseUrl;
import org.example.page.DashboardPage;


import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;
public class logout {
    WebDriver driver;

    LoginPage loginPage;
    DashboardPage dashboardPage;


    @Given("the user is on the main dashboard")
    public void onDashboard() {
        driver = Hooks.getDriver();
// Initialize baseUrl object
        driver.get(BaseUrl.getBaseUrl() + "login");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("Whyaziz");
        loginPage.enterPassword("kkny5056");
        loginPage.clickLoginButton();
//        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"dashboard");
        dashboardPage = new DashboardPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("the user clicks the Profile Dropdown")
    public void clickProfile() {
        dashboardPage.clickProfil();
    }

    @And("the user clicks the logout button")
    public void clickLogout() {
        dashboardPage.clickLogout();
    }

    @Then("the user clicks the yes button to confirm")
    public void clickYes() {
        dashboardPage.clickYes();
    }
    @And("the user should be redirected to the landing page")
    public void redirect(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.getCurrentUrl(),BaseUrl.getBaseUrl());

    }
}
