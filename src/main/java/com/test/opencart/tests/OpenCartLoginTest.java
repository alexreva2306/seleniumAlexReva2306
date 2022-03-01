package com.test.opencart.tests;

import com.test.opencart.TestBaseOpenCart;
import com.test.opencart.pages.OpenCartLoginPage;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends TestBaseOpenCart {
@Test
    public void lodInPositive() throws InterruptedException {
    OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
    openCartLoginPage.logIn("demo","demo");Thread.sleep(1000);

}
}
