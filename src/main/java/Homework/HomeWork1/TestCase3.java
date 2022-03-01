package Homework.HomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 Test Case 3
Steps
Navigate to "https://www.saucedemo.com/" Enter username "Java"
Enter password "Selenium"
Click Login button
Validate "Epic sadface: Username and password do not match any user in this service" message
TIPS:to be able to see this message you need to first see this message then try to inspect it. (it means at least run one time with the
username and password you provided above to see the message then inspect the message.*be careful with it is fully copied or not.
 */
public class TestCase3 {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");
        WebElement button = driver.findElement(By.xpath("//input[@id='login-button']"));
        button.click();

        WebElement validEpFace = driver.findElement(By.xpath("//h3[@data-test='error']"));
        System.out.println( validEpFace.getText());
        String expEpFace = "Epic sadface: Username and password do not match any user in this service";
        String actEpFace = validEpFace.getText();
        if(expEpFace.equals(actEpFace)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }


    }
}
