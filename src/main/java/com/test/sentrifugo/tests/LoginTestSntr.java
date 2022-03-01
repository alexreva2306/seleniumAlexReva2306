package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPageSntr;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestSntr {
//    @Test
//    public void validateSuperAdmin(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
//        driver.manage().window().maximize();
//        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
//        userName.sendKeys("EMO1");
//        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//        password.sendKeys("sentrifugo");
//        WebElement loginButton  = driver.findElement(By.xpath("//input[@id='loginsubmit']"));
//        loginButton.submit();}
        @Test
       public void ValidateSuperAdmin(){
            WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        driver.manage().window().maximize();
        LoginPageSntr loginPage  = new LoginPageSntr(driver);
        loginPage.dynamicLogin("EMO5","sentrifugo");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://demo.sentrifugo.com/index.php/index/welcome";
            Assert.assertEquals(actualUrl,expectedUrl);
            String actTitle = driver.getTitle();
            String expTitle = "Sentrifugo - Open Source HRMS";
            Assert.assertEquals(actTitle,expTitle);


    }
}
