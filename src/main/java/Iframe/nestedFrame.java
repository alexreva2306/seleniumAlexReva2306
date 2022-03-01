package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class nestedFrame {
    @Test
    public  void nestedFrameValidation() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();
        // using index to switch the frame
        driver.switchTo().frame(0);//index is last choice because the hard codding
        //webElement to switch the frame
        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame);//middle
        WebElement textBox = driver.findElement(By.xpath("//div[@id='content']"));
        String actName = BrowserUtils.getTextMethod(textBox);
        String expName = "MIDDLE";
        Assert.assertEquals(actName,expName);
        Thread.sleep(1000);

        driver.switchTo().parentFrame();//top
        driver.switchTo().frame("frame-right");//right
        WebElement rightBox = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        String actName1 = BrowserUtils.getTextMethod(rightBox);
        String expName1 = "RIGHT";
        Assert.assertEquals(actName1,expName1);Thread.sleep(1000);

        driver.switchTo().parentFrame();//top
        driver.switchTo().parentFrame();//html
        driver.switchTo().frame("frame-bottom");
        WebElement bottomBox = driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        String actName2 = BrowserUtils.getTextMethod(bottomBox);
        String expName2 = "BOTTOM";
        Assert.assertEquals(actName2,expName2);
    }
}
