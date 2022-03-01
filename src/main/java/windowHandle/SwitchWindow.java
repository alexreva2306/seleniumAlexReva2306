package windowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class SwitchWindow {
    @Test
    public void practice1() throws InterruptedException {
        //it is failing because my driver is still pointing the last tab. it throws the
        //NoSuchElementException
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        Thread.sleep(200);
        String act = newWindow.getText().trim();
        String exp ="New Window";
        Assert.assertEquals(act,exp);
    }

    @Test
    public void switchingWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println(driver.getWindowHandle());// id of window --> CDwindow-39804D0EDB3647C277D5BEAD59FAB471
        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        System.out.println(driver.getWindowHandles());
        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        //this implementation for only 2 tabs
        for(String id: allPagesId){
           // System.out.println(id);
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        WebElement newWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(newWindow.getText());
        Thread.sleep(200);
        String act = newWindow.getText().trim();
        String exp ="New Window";
        Assert.assertEquals(act,exp);
    }

    @Test
    public void SwitchingWindowPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String mainPageId = driver.getWindowHandle();
        WebElement openNewTab = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
        openNewTab.click();   Thread.sleep(200);
        BrowserUtils.swithOnlyTwoTabs(driver,mainPageId);
//        Set<String> allPagesId = driver.getWindowHandles();
//        for(String id: allPagesId){
//            if(!id.equals(mainPageId)){
//                driver.switchTo().window(id);
//            }
//        }
        WebElement newWindow = driver.findElement(By.xpath("//div[@class='post-head']//h1"));
        Thread.sleep(200);
        String act = BrowserUtils.getTextMethod(newWindow);//newWindow.getText().trim();
        String exp ="AlertsDemo";
        Assert.assertEquals(act,exp); Thread.sleep(200);
        WebElement clickMe = driver.findElement(By.id("alertBox"));
        clickMe.click();
    }
}
