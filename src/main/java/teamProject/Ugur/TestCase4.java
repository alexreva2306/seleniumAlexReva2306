package teamProject.Ugur;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 {

    @Test
    public void urlHasName() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        Thread.sleep(1000);
        boolean ss = driver.getCurrentUrl().contains("Process.aspx"), expected = true;
        Assert.assertEquals(ss, expected);
        WebElement clickOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        clickOrders.click();
        Thread.sleep(1000);
        boolean ss1 = driver.getCurrentUrl().contains("Default.aspx");
        Assert.assertEquals(ss1, expected);
        WebElement clickProducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        clickProducts.click();
        Thread.sleep(1000);
        boolean ss2 = driver.getCurrentUrl().contains("Products.aspx");
        Assert.assertEquals(ss2, expected);
        System.out.println(ss2);

    }
}
