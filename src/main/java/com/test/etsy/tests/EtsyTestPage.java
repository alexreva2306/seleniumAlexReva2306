package com.test.etsy.tests;

import com.test.etsy.EtsyTestBase;
import com.test.etsy.pages.EtsyMainPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyTestPage extends EtsyTestBase {
    @Parameters("itemSearch")
   @Test
public void EtsySearchTest(String item)throws InterruptedException{
    EtsyMainPage etsyMainPage = new EtsyMainPage(driver);
    etsyMainPage.searchItem(item);Thread.sleep(1000);
        Assert.assertTrue(etsyMainPage.validateHeader());

}
}
