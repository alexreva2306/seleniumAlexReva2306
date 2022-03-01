package com.test.opencart.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    public CustomersPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[contains(text(),'Customers')]")
    WebElement customers;
    @FindBy(xpath = "//ul[@id='collapse33']//a[contains(text(),'Customers')]")
    WebElement customers1;
    @FindBy(xpath = "//i[@class='fa fa-plus']")
    WebElement addBut;
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement eMail;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement phone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement pasConfirm;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBut;
    @FindBy(xpath = "//div[contains(text(),'Warning')]")
    WebElement message;

    public void customersMessage(String firstName, String lastName, String eMail, String phone, String password, String pasConfirm) throws InterruptedException {
        this.customers.click();Thread.sleep(300);this.customers1.click();Thread.sleep(300);
        this.addBut.click();Thread.sleep(300);
        this.firstName.sendKeys(firstName);this.lastName.sendKeys(lastName);
        this.eMail.sendKeys(eMail);this.phone.sendKeys(phone);this.password.sendKeys(password);
        this.pasConfirm.sendKeys(pasConfirm);Thread.sleep(300);saveBut.click();Thread.sleep(1000);

    }
    public String valid() {
        return BrowserUtils.getTextMethod(this.message);
    }


}
