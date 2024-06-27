package org.example.owner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.object.BaseUrl;
import org.example.object.Hooks;
import org.example.page.DashboardPage;
import org.example.page.InputDataPage;
import org.example.page.KandangPage;
import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class ViewAllKandang {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage;
    DashboardPage dashboardPage;
    KandangPage kandangPage;
    @Given("the user is on the main dashboard as an owner")
    public void userIsOnMainDashboard() {
        try{
            driver.get(BaseUrl.getBaseUrl() + "login");
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("Whyaziz");
            loginPage.enterPassword("kkny5056");
            loginPage.clickLoginButton();
//        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"dashboard");
            dashboardPage = new DashboardPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Hooks.loginTest.pass("Aziz Login");
        }
        catch (Exception e){
            Hooks.loginTest.fail("login fail");
        }
    }

    @When("the user clicks the Kandang section")
    public void userClicksInputDataSection() {
        dashboardPage.clickKandang();
        kandangPage = new KandangPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Then("the user should be redirected to the Kandang page")
    public void userEntersData() {
        try{
            Assert.assertTrue(kandangPage.checkData());
            Hooks.viewKandangTest.pass("ada kandang 1");
        }
        catch (Exception e){
            Hooks.viewKandangTest.fail("kandang tidak terdeteksi");
        }
    }


}
