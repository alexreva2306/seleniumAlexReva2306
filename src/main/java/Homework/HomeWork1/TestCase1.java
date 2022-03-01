package Homework.HomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 Test Case 1
Steps
Navigate to "https://demoqa.com/text-box"
Enter your full name, email, current and permanent address Click submit button.
Validate that all of your information is displayed and matching correctly.
TIPS:Think about if conditions.
Example:
Name:David
Email: david@gmail.com
Current Address :Random Address Permananet Address : different address
 */
public class TestCase1 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameBox = driver.findElement(By.xpath("//input[@id='userName']"));
        fullNameBox.sendKeys("Alex Reva");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("arva23@gmai.com");
        WebElement curAdr = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        curAdr.sendKeys("8745 Palm Breeze");
        WebElement permAdr = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAdr.sendKeys("83763473645 Palm Breeze");

        WebElement button = driver.findElement(By.xpath("//button[@id ='submit']"));
        button.click();

        WebElement nameValidation = driver.findElement(By.xpath("//p[@id='name']"));
        System.out.println(nameValidation.getText());
        String expectedValidation = "Name:Alex Reva";
        String actualValidation = nameValidation.getText();
        if(expectedValidation.equals(actualValidation)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        WebElement emailValidation = driver.findElement(By.xpath("//p[@id='email']"));
        System.out.println(emailValidation.getText());
        String emExpVal = "Email:arva23@gmai.com";
        String emActVal = emailValidation.getText();
        if(emExpVal.equals(emActVal)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }

        WebElement curAdrValidation = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        System.out.println(curAdrValidation.getText());
        String curAdrExpVal = "Current Address :8745 Palm Breeze";
        String curAdrActVal = curAdrValidation.getText();
        if(curAdrExpVal.equals(curAdrActVal)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }

        WebElement permAdrValidation = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        System.out.println(permAdrValidation.getText());
        String permAdrExpVal = "Permananet Address :83763473645 Palm Breeze";
        String permAdrActVal = permAdrValidation.getText();
        if(permAdrExpVal.equals(permAdrActVal)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }


    }
}
