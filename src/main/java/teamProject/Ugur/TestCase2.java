package teamProject.Ugur;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase2 {
    @Test
    public void allProductisSelected() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement clickOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        clickOrders.click();
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int i = 0; i < checkbox.size(); i++) {
            checkbox.get(i).click();
            boolean isSelected = checkbox.get(i).isSelected(), expected = true;
            Assert.assertEquals(isSelected, expected);
        }
    }
    @Test
    public void isEqualsHeader() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement products = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        products.click();
        WebElement headers = driver.findElement(By.xpath("//h2"));
        System.out.println(headers.getText());
        Assert.assertEquals(headers.getText(),"List of Products");
    }
    @Test
    public void isUrlHasProduct() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        WebElement products = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        products.click();
        Boolean ss=driver.getCurrentUrl().contains("Products"), expected=true;

        Assert.assertEquals(ss,expected);

    }
}
