package org.example.anakKandang;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.object.BaseUrl;
import org.example.object.Hooks;
import org.example.page.DashboardPage;
import org.example.page.InputDataPage;
import org.example.page.InputPanenPage;
import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class InputPanenSteps {
    WebDriver driver = Hooks.getDriver();
    LoginPage loginPage;
    DashboardPage dashboardPage = new DashboardPage(driver);
    InputPanenPage inputPanenPage;

    @When("the user clicks the input data panen section")
    public void userClicksInputDataSection() {
        dashboardPage.clickInputPanen();
        inputPanenPage = new InputPanenPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("the user enters the number of chickens and the total weight")
    public void userEntersData() {
        inputPanenPage.InputTanggalPanen("16/5/2024");
        inputPanenPage.InputJumlahPanen(120);
        inputPanenPage.InputBobotTotal(1200);

    }

    @And("the user clicks the submit button")
    public void userClicksButton() {
        inputPanenPage.simpanData();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Then("the system should confirm the data accuracy")
    public void systemConfirmsDataAccuracyAndUpdateCount() {
        // Implementation to verify data accuracy and update count
//        Assert.assertEquals(BaseUrl.getBaseUrl(),BaseUrl.getBaseUrl());
        try{
            Assert.assertTrue(inputPanenPage.check());
            Hooks.inputPanenTest.pass("data sudah tersimpan");
        }catch (Exception e){
            Hooks.inputPanenTest.fail("data belum tersimpan");
        }

    }


}
