package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSntr {

    public LoginPageSntr(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
//we are going to store our element locations and methods here.
    @FindBy(xpath = "//input[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//input[@id='loginsubmit']")
    WebElement loginButton;

//    public void login(){
//        userName.sendKeys("EMO1");
//        password.sendKeys("sentrifugo");
//        loginButton.click();
//
//    }
    public void dynamicLogin(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginButton.submit();
    }
}
