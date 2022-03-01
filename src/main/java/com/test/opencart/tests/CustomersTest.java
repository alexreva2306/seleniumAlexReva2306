package com.test.opencart.tests;

import com.test.opencart.TestBaseOpenCart;
import com.test.opencart.pages.CustomersPage;
import com.test.opencart.pages.OpenCartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomersTest extends TestBaseOpenCart {
    @Test
    public void warningMessageValidation() throws InterruptedException {
        OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
        openCartLoginPage.logIn("demo","demo");Thread.sleep(1000);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.customersMessage("Alex","Bond","bla45465@gmail.com","9043333333","geor","geor");
        Assert.assertEquals(customersPage.valid(), "Warning: You do not have permission to modify customers!\n×".trim());
    }
}
