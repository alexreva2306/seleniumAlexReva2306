package Homework.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement signInBut = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        signInBut.click();



        WebElement continueButton = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
        continueButton.click();

        WebElement name = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
        name.sendKeys("Alex Reva");

        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("alexreva2306@dmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("pendragon.A23");

        WebElement passwordCheck = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
        passwordCheck.sendKeys("pendragon.A23");

        WebElement continueButton1 = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton1.click();

    }

}
