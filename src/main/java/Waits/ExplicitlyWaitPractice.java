package Waits;

import Utils.BrowserUtils;
import Utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitlyWaitPractice {

    @Test
    public void validateWait() throws InterruptedException {
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        WebElement but = driver.findElement(By.xpath("//button"));
        but.click();//Thread.sleep(5000);
//        WebElement helloWorld = driver.findElement(By.xpath("//h4[.='Hello World!']"));
//        Assert.assertEquals(BrowserUtils.getTextMethod(helloWorld),"Hello World!");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement text1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[.='Hello World!']"))));
        Assert.assertEquals(text1.getText().trim(),"Hello World!");
    }

}
