package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputDataPage {
    private WebDriver driver;

    public InputDataPage(WebDriver driver) {
        this.driver = driver;
    }
    public void InputPakan(int pakan){
        driver.findElement(By.id("inputPakan")).sendKeys(String.valueOf(pakan));
    }
    public void InputBobot(int bobot){
        driver.findElement(By.id("inputBobot")).sendKeys(String.valueOf(bobot));
    }
    public void InputMinum(int minum){
        driver.findElement(By.id("inputMinum")).sendKeys(String.valueOf(minum));
    }
    public void InputPopulasi(int populasi){
        driver.findElement(By.id("inputPopulasi")).sendKeys(String.valueOf(populasi));
    }
    public void InputAyam(int ayamMati){
        driver.findElement(By.id("inputJumlah_Ayam_Mati")).sendKeys(String.valueOf(ayamMati));
    }

    public void simpanData(){
        driver.findElement(By.id("btnSimpanData")).click();
    }
    public boolean check(){
        WebElement success = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[2]"));
        if (success == null){
            return false;
        }
        return true;
    }
}
