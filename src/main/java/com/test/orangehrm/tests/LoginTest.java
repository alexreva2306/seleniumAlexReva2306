package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void initializePage(){
        loginPage = new LoginPage(driver);
    }
    @Test
    public void validateLoginPositive(){
      //  LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    }
    @Test(dataProvider = "pickles", dataProviderClass = DataForNegLogin.class)
    public void validateLoginNegative1(String invalUsName,String invalPassword ,String expected){
     //   LoginPage loginPage = new LoginPage(driver);
        loginPage.login(invalUsName,invalPassword);//correct username but wrong password
        Assert.assertEquals(loginPage.getErrorMessage(),expected);
    }
//    @Test
//    public void validateLoginNegative2(){
////        WebDriverManager.chromedriver().setup();
////        WebDriver driver = new ChromeDriver();
////        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
////        driver.manage().window().maximize();
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("","");
//        String actualErrorMessage=loginPage.getErrorMessage();
//        String expectedErrorMessage="Username cannot be empty";
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
//        String actualColorOfErrorMessage=loginPage.getColorOfTheErrorMessage();
//        String expectedColorOfErrorMessage="rgba(221, 119, 0, 1)";
//        Assert.assertEquals(actualColorOfErrorMessage,expectedColorOfErrorMessage);
//    }
}
