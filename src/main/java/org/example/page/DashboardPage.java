package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click "Input Data" link
    public void clickInputData() {
        WebElement inputDataLink = driver.findElement(By.id("sidebarInput-Data"));
        inputDataLink.click();
    }

    // Click "Input Panen" link
    public void clickInputPanen() {
        WebElement inputPanenLink = driver.findElement(By.id("sidebarInput-Panen"));
        inputPanenLink.click();
    }
    public void clickKandang(){
        WebElement KandangLink = driver.findElement(By.id("sidebarKandang"));
        KandangLink.click();
    }
    public void clickPanen(){
        WebElement PanenLink = driver.findElement(By.id("sideBarPanen"));
        PanenLink.click();
    }
    //profile
    public void clickProfil(){
        WebElement element = driver.findElement(By.id("dropdownProfile"));
        element.click();

    }
    //logout
    public void clickLogout() {
        WebElement logoutLink = driver.findElement(By.id("optionLogOut"));
        logoutLink.click();
    }
    //yes
    public void clickYes(){
        WebElement yes = driver.findElement(By.id("btnYes"));
        yes.click();
    }
}
