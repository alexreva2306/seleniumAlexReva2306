package com.test.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
TASK:
Loginpage-->login to the website
1-Navigate to the website(it is already in your testbase)
2-Login to the openchartwebsite
MainPage-->do these validations
3-Validate totalorders is "12K"
4-Validate totalsales is "11.8M"
5)Validate Customers is "144.8K"
CustomerPage-->fill these boxes and validate the message and color
6)Click Customers on the side tab
7)Click Customers on the open tab from Customers
8)Click + button to add customers
9)Fill the all boxes
10)Click Save button
11)validate the message and color
 */
public class OpenCartLoginPage {

    public OpenCartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='input-username']")
    WebElement userName;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBut;

    public void logIn(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBut.click();
    }
}
