package com.test.orangehrm.tests;

import com.test.orangehrm.pages.PIMPage;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTest extends TestBase {
    LoginPage loginPage;
    MainPage mainPage;
    PIMPage pimPage;
    @BeforeMethod
    public void initialiazingPages(){
         loginPage = new LoginPage(driver);
         mainPage = new MainPage(driver);
         pimPage = new PIMPage(driver);
    }
@Test
    public void ValidateTheCreationOfEmployee() throws InterruptedException {
   // LoginPage loginPage = new LoginPage(driver);
    loginPage.login("Admin","admin123");
  //  MainPage mainPage = new MainPage(driver);
    mainPage.clickPIMBut();
   // PIMPage pimPage = new PIMPage(driver);
    pimPage.addEmployeeForPIM("Ce","Doo","2213","/Users/alexreva/Desktop/USA.png");
    Assert.assertEquals(pimPage.validateFirstName(),"Ce");
    Assert.assertEquals(pimPage.validateLastName(),"Doo");
    Assert.assertTrue(pimPage.validateEmployeeId("2213"));
}
    @Test
    public void ValidatePersonalDetailElement() throws InterruptedException {
        loginPage.login("Admin","admin123");
        mainPage.clickPIMBut();
        pimPage.addEmployeeForPIM("ahmet","Baldir","1991","/Users/alexreva/Desktop/USA.png");
        pimPage.editPersonalDetails("Turkish","1991-08-13","Single");
        Assert.assertEquals(pimPage.validateTheNationality(),"Turkish");
    }

}
