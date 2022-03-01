package fileUploads;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTask {
    /*
1)Navigate to the "https://demo.guru99.com/test/upload/'
2)Upload the usa.png file on the website
3)Click the box (I accept terms of service)
4)validate box is selected
5)Click submit button
6)Validate the message "1 file has been successfully uploaded."
 */
    @Test
    public void fileUploadPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        driver.manage().window().maximize();
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        chooseFile.sendKeys("/Users/alexreva/Desktop/USA.png");Thread.sleep(200);
        WebElement acceptTerms = driver.findElement(By.xpath("//input[@id='terms']"));
        acceptTerms.click();Thread.sleep(200);
        WebElement submitFile = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFile.click();Thread.sleep(200);
        WebElement mess = driver.findElement(By.tagName("h3"));
        String actMes = BrowserUtils.getTextMethod(mess);
        String expMes = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actMes,expMes);
    }
}
