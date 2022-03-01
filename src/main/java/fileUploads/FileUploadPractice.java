package fileUploads;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadPractice {

    @Test
    public void validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("/Users/alexreva/Desktop/USA.png");
        WebElement upLoadBut = driver.findElement(By.xpath("//input[@id='file-submit']"));
        upLoadBut.click();
        WebElement message1 = driver.findElement(By.tagName("h3"));
        String actMes1 = BrowserUtils.getTextMethod(message1);
        String expMes1 = "File Uploaded!";
        Assert.assertEquals(actMes1,expMes1);
        WebElement message2 = driver.findElement(By.id("uploaded-files"));
        String actMes2 = BrowserUtils.getTextMethod(message2);
        String expMes2 = "USA.png";
        Assert.assertEquals(actMes2,expMes2);
       // Assert.assertTrue(actMes2.equals("USA.png"));
    }

}
