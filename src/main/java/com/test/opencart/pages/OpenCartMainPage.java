package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenCartMainPage {

   public OpenCartMainPage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }
    @FindBy(xpath = "//h2[.='12K']")
    WebElement totalOrders;
    @FindBy(xpath = "//h2[.='11.8M']")
    WebElement totalSales;
    @FindBy(xpath = "//h2[.='145K']")
    WebElement totalCustomers;

    public void validationOrdersSalesCustomers(String orders, String sales, String customers){
        Assert.assertEquals(this.totalOrders.getText().trim(),orders);
        Assert.assertEquals(this.totalSales.getText().trim(),sales);
        Assert.assertEquals(this.totalCustomers.getText().trim(),customers);
    }

}
