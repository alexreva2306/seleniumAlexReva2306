package com.test.orangehrm.tests;

import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {

    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("ahmetNewAhmet13"));



    }

}