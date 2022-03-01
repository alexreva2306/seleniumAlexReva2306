package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
    Facebook Sign up:
Scenario:
Open a Chrome browser.
Navigate to "http://www.fb.com"
Verify that the page is redirected to "http://www.facebook.com", by getting the current URL. (use Assertion)
Verify that there is a "Create an account" section on the page.
Fill in the text boxes: First Name, Surname, Mobile Number or email address, "Re-enter mobile number", new password.
Update the date of birth in the drop-down.
Select gender.
Click on "Create an account".
Verify that the account is not created.
     */
public class FaceBookPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        String actualUrl = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        String expectedUrl = "https://www.facebook.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("the website is correct");
        }else{
            System.out.println("the website is wrong");
        }

        WebElement createNew = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        boolean validationButton=createNew.isDisplayed();
        boolean expectedValidationButton=true;
        if(validationButton==expectedValidationButton){
            System.out.println("Button is displayed");
        }else{
            System.out.println("Button is not displayed");
        }
        createNew.click();
        Thread.sleep(1000);

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Alex");


        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Reva");

        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("blabla@gmail.com");

        WebElement confEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        confEmail.sendKeys("blabla@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        password.sendKeys("patagonia11");

        WebElement month = driver.findElement(By.id("month"));
        month.sendKeys("Jun");

        WebElement day = driver.findElement(By.name("birthday_day"));
        day.sendKeys("23");

        WebElement year = driver.findElement(By.name("birthday_year"));
        year.sendKeys("1994");

        WebElement gender = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
        gender.click();

        WebElement signUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();

    }
}
