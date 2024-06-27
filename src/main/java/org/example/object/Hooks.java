package org.example.object;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;
    private static ExtentReports extent;
    public static ExtentTest loginTest;
    public static ExtentTest logoutTest;
    public static ExtentTest inputDataTest;
    public static ExtentTest inputPanenTest;

    public static ExtentTest viewKandangTest;

    @BeforeAll
    public static void setUp() {
        extent = ExtentReportManager.getInstance();
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        loginTest = extent.createTest("Login test");
        logoutTest = extent.createTest("Logout test");
        inputDataTest = extent.createTest("Input data test");
        inputPanenTest = extent.createTest("Input Panen test");
        viewKandangTest = extent.createTest("View Kandang test");
    }
    public static WebDriver getDriver(){
        if (driver==null){
            Hooks.setUp();
        }
        return driver;
    }
    @AfterAll
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        loginTest.log(Status.INFO, "Close Login ");
        logoutTest.log(Status.INFO, "Close Logout ");
        inputPanenTest.log(Status.INFO,"Close input panen");
        inputDataTest.log(Status.INFO,"Close input data");
        viewKandangTest.log(Status.INFO,"Close view Kandang");
        extent.flush();
    }
}
