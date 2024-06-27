package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputPanenPage {
    private WebDriver driver;

    public InputPanenPage(WebDriver driver) {
        this.driver = driver;
    }
    public void InputTanggalPanen(String tanggal){
        driver.findElement(By.id("inputTanggal_Panen")).sendKeys(tanggal);
    }
    public void InputJumlahPanen(int jumlah){
        driver.findElement(By.id("inputJumlah_Panen")).sendKeys(String.valueOf(jumlah));
    }
    public void InputBobotTotal(int bobot){
        driver.findElement(By.id("inputBobot_Total")).sendKeys(String.valueOf(bobot));
    }
    public void simpanData(){
        driver.findElement(By.id("btnSimpanInputPanen")).click();
    }
    public boolean check(){
        WebElement success = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[2]"));
        if (success == null){
            return false;
        }
        return true;
    }
}
