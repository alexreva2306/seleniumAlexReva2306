package Homework.HomeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        WebElement register = driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        register.click();

        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        gender.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Alex");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Reva");

        WebElement dateOfBirth = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        dateOfBirth.sendKeys("23");

        WebElement monthOfBirth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        monthOfBirth.sendKeys("6");

        WebElement yearOfBirth = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        yearOfBirth.sendKeys("1994");

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("alexreva14@gmail.com");

        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("Techtorial");

        List<WebElement>  boxes = driver.findElements(By.xpath("//input[@id='Newsletter']"));
        for(WebElement box:boxes){
            if(box.getAttribute("data-val").equals("true")){
                box.click();
            }
        }

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("patagonia13");

        WebElement passwordConf = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        passwordConf.sendKeys("patagonia13");

        WebElement registerBut = driver.findElement(By.xpath("//button[@id='register-button']"));
        registerBut.click();

        WebElement validText = driver.findElement(By.xpath("//div[@class='result']"));
        String actualText = validText.getText();
        String expectedText = "Your registration completed";
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        WebElement continueClick = driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
        continueClick.click();

    }
}
