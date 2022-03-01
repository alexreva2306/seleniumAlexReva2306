package teamProject.Ugur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
    //    public static void main(String[] args) {
//        WebDriver driver= new ChromeDriver();
//        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
//
//    }


    @Test
    public void validateTitle(){
        WebDriver driver= new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
    }

    @Test
    public void validateTitle2(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        WebElement username=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        Assert.assertEquals(driver.getTitle(),"Web Orders");

    }
    @Test
    public void listOfAllOrders() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        WebElement username=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        Thread.sleep(200);
        WebElement login=driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        Thread.sleep(200);
        WebElement clickOrders=driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        clickOrders.click();
        Thread.sleep(200);
        WebElement headers = driver.findElement(By.xpath("//h2"));
        System.out.println(headers.getText());
        Assert.assertEquals(headers.getText(),"List of All Orders");
    }

}
