package com.test.orangehrm.tests;

import Utils.ConfigReader;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
public class AdminTest extends TestBase {

    AdminPage adminPage;
    @BeforeMethod
    public void initiliazePages(){
        adminPage = new AdminPage(driver);
    }
    @Test
    public void validateTheCreationOfEmployeeMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("Admin","admin123");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
       // AdminPage adminPage = new AdminPage(driver);
        adminPage.sendingAllInformationForEmployee();Thread.sleep(2000);
        Assert.assertTrue(adminPage.ValidationTheEmployeeIsCreated("AreoMilk6"));Thread.sleep(1000);


        }


    @Test(dataProvider = "UserRoles",dataProviderClass = DataForNegLogin.class)
    public void ValidateTheSelectRoleFunctions(String roleName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAdminButton();
        AdminPage adminPage = new AdminPage(driver);
        adminPage.selectUserRole(roleName,driver);
        Assert.assertTrue(adminPage.validateRoleText(roleName));

    }
//    @Test
//    public void ValidateTheSelectRoleFunctions2() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(ConfigReader.readProperty("orangehrmusername"),ConfigReader.readProperty("orangehrmpassword"));
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickAdminButton();
//        AdminPage adminPage = new AdminPage(driver);
//        adminPage.selectUserRole("ESS",driver);
//        Assert.assertTrue(adminPage.validateRoleText("ESS"));
//
//    }
    }


