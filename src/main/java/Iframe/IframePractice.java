package Iframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframePractice {
    @Test
    public void  iFrameTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.xpath("//body[@id='tinymce']"));
        box.clear();Thread.sleep(1000);
        box.sendKeys("I love selenium");
        driver.switchTo().parentFrame();
        WebElement header = driver.findElement(By.tagName("h3"));
        String actHead = BrowserUtils.getTextMethod(header);
        String expHeader  ="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actHead,expHeader);

    }
}
