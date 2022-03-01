package Homework.HomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 Test Case 4
Steps
Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Validate current url is "https://www.saucedemo.com/inventory.html"
 */
public class TestCase4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();
        System.out.println(driver.getCurrentUrl());
        String expUrl = "https://www.saucedemo.com/inventory.html";
        String actUrl  = driver.getCurrentUrl();

        if(expUrl.equals(actUrl)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }

    }
}
