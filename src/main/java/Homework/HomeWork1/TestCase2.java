package Homework.HomeWork1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 Test Case 2
Steps
Navigate to "https://demoqa.com/radio-button" Click Yes radio button
Validate text is : You have selected Yes
Click Impressive radio button
Validate text is : You have selected Impressive
TIPS: be careful about your xpath if you have any issue with getting the text.
 */
public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
        WebElement radioButton = driver.findElement(By.id("yesRadio"));
        //  radioButton.click();
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",radioButton);

        WebElement validBut = driver.findElement(By.xpath("//label[@for='yesRadio']"));

        String expectedBut ="Yes";
        String actualBut = validBut.getText();
        if(expectedBut.equals(actualBut)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }

        WebElement impressiveButton = driver.findElement(By.id("impressiveRadio"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()",impressiveButton);

        WebElement validBut1 = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        String expectedBut1 ="Impressive";
        String actualBut1 = validBut1.getText();
        if(expectedBut1.equals(actualBut1)){
            System.out.println("passed");
        }else{
            System.out.println("fail");
        }

    }
}
