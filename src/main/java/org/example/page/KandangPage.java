package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KandangPage {
    private WebDriver driver;

    public KandangPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean checkData(){
        WebElement data = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div/div/div/div[2]/table/tbody/tr[1]/td[2]"));
        if (data==null){
            return false;
        }
        return true;
    }
}
