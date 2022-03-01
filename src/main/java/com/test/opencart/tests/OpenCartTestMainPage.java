package com.test.opencart.tests;

import com.test.opencart.TestBaseOpenCart;
import com.test.opencart.pages.OpenCartLoginPage;
import com.test.opencart.pages.OpenCartMainPage;
import org.testng.annotations.Test;

public class OpenCartTestMainPage extends TestBaseOpenCart {
@Test
        public void validOrdSalCustIsSame() throws InterruptedException {
    OpenCartLoginPage openCartLoginPage = new OpenCartLoginPage(driver);
    openCartLoginPage.logIn("demo","demo");
    OpenCartMainPage openCartMainPage = new OpenCartMainPage(driver);Thread.sleep(1000);
    openCartMainPage.validationOrdersSalesCustomers("12K","11.8M","145K");Thread.sleep(1000);
}

}
