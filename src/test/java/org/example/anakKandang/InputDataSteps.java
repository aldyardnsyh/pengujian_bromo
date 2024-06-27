package org.example.anakKandang;


import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.example.object.BaseUrl;
import org.example.object.Hooks;
import org.example.page.DashboardPage;
import org.example.page.InputDataPage;
import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class InputDataSteps {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage;
    DashboardPage dashboardPage;
    InputDataPage inputDataPage;
    @Given("the user is on the main dashboard anak kandang")
    public void userIsOnMainDashboard() {
        try{
            driver.get(BaseUrl.getBaseUrl() + "login");
            loginPage = new LoginPage(driver);
            loginPage.enterUsername("bimacst");
            loginPage.enterPassword("password");
            loginPage.clickLoginButton();
//        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"dashboard");
            dashboardPage = new DashboardPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Hooks.loginTest.pass("Bima login");
            Hooks.inputDataTest.log(Status.INFO,"Bima berada di Dasboard");
        }
        catch (Exception e){
            Hooks.loginTest.fail("login fail");
        }
    }

    @When("the user clicks the input data section")
    public void userClicksInputDataSection() {
        dashboardPage.clickInputData();
        inputDataPage = new InputDataPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("the user enters the data")
    public void userEntersData() {
        inputDataPage.InputAyam(20);
        inputDataPage.InputPakan(10);
        inputDataPage.InputMinum(20);
        inputDataPage.InputBobot(12);
        inputDataPage.InputPopulasi(150);
    }

    @And("the user clicks the {string} button")
    public void userClicksButton(String buttonName) {
        try {
            inputDataPage.simpanData();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            Hooks.inputDataTest.pass("Input success");
        }
        catch (Exception e){
            Hooks.inputDataTest.fail("Input Fail");
        }
    }

    @Then("the system should confirm the data accuracy and update the total chicken count")
    public void systemConfirmsDataAccuracyAndUpdateCount() {
        // Implementation to verify data accuracy and update count
//        Assert.assertEquals(BaseUrl.getBaseUrl(),BaseUrl.getBaseUrl());
        try{
            Assert.assertTrue(inputDataPage.check());
            Hooks.inputDataTest.pass("data sudah tersimpan");
        }catch (Exception e){
            Hooks.inputDataTest.fail("data belum tersimpan");
        }
    }

}

