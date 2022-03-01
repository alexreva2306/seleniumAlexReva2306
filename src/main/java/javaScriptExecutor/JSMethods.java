package javaScriptExecutor;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//whenever normal methods are not working then last decision should  be JavaScript
public class JSMethods {
    @Test
    public void titleMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle()+" from driver");

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        String title = javascriptExecutor.executeScript("return document.title").toString();
     //   System.out.println(title+" from javaScript");
       String actualTitle =  BrowserUtils.getTitleWithJavaScript(driver);
       String expectedTitle = "Home Page - Techtorial";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @Test // I use this method often
    public void ClickWithJS(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
//        browseCourse.click();
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
     //   javascriptExecutor.executeScript("arguments[0].click()",browseCourse);//same as click
        BrowserUtils.ClickWithJS(driver,browseCourse);

    }

    @Test
    public void clickWithJSPractice(){
        /*
click the student logIn
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        driver.manage().window().maximize();
        WebElement stLog = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[@href='#']"));
        BrowserUtils.ClickWithJS(driver,stLog);
    }

    @Test//***
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",copyRight);

        //Task1

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement browseCourse = driver.findElement(By.xpath("//a[.='Browse Course']"));
        BrowserUtils.ClickWithJS(driver,browseCourse);

        Thread.sleep(1000);
        WebElement getStarted = driver.findElement(By.xpath("//h4[.='On-Campus Course']//..//a"));
   //     JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true)",getStarted);
//        BrowserUtils.ClickWithJS(driver,getStarted);
        BrowserUtils.scrollWithJS(driver,getStarted);
        BrowserUtils.ClickWithJS(driver,getStarted);
    }
    @Test
    public void scrollWithXAndYCoordinateTest(){
        //This is an interview question(POINT CLASS)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement copyRight = driver.findElement(By.xpath("//p[contains(text(),' Copy')]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        Point location = copyRight.getLocation();
//        System.out.println(location.getX());
//        System.out.println(location.getY());
//        int xCord = location.getX();
//        int yCord = location.getY();
//        js.executeScript("window.scrollTo("+xCord+","+yCord+")");
        BrowserUtils.scrollWithXandYCord(driver,copyRight);
    }

}
