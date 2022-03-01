package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/alexreva/Desktop/Techtorial%20(2).html");

        WebElement header = driver.findElement(By.id("techtorial1"));
        String actualText = header.getText();//from the system
        String expectedText ="Techtorial Academy";//from the buisness requirment
        if(actualText.equals(expectedText)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        WebElement header1 = driver.findElement(By.id("details2"));
        String longText = header1.getText();
        System.out.println(longText);
        if(header.getText().equals("To create your account, \n" +
                "        we'll need some basic information about you. This information will be \n" +
                "        used to send reservation confirmation emails, mail tickets when needed \n" +
                "        and contact you if your travel arrangements change. Please fill in the \n" +
                "        form completely.")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
        //LOCATOR:ClassName
        WebElement tools = driver.findElement(By.className("group_checkbox"));
        System.out.println(tools.getText());

        //Locator: Name
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Alex");
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Reva");
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("0000000000");
        WebElement eMail = driver.findElement(By.name("userName"));
        eMail.sendKeys("cousin23@gmai.com");

        WebElement javaBox0 = driver.findElement(By.id("cond1"));
        javaBox0.click();
        System.out.println( javaBox0.isDisplayed());
        System.out.println( javaBox0.isSelected());

        WebElement javaBox = driver.findElement(By.id("cond3"));
        javaBox.click();
        System.out.println( javaBox.isDisplayed());
        System.out.println( javaBox.isSelected());

        WebElement javaBox1 = driver.findElement(By.id("cond4"));
        javaBox1.click();
        System.out.println( javaBox1.isDisplayed());
        System.out.println( javaBox1.isSelected());
    }
}
