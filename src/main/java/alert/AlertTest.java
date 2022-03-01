package alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {
    @Test
    public void jsAlert() {
            /*(ALERT CLASS)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom left one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement clickJsAlertBut = driver.findElement(By.xpath("//button[@onclick=\"alert('Oops, something went wrong!')\"]"));
        clickJsAlertBut.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }
    @Test
    public void TrialForAlertToHandleHTMLpopup() {
        /* TASK 2 (ALERT CLASS)
     1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        //this one failing us he said.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement clickJsAlertBut2 = driver.findElement(By.xpath("//button[@onclick=\"swal('Oops', 'Something went wrong!', 'error')\"]"));////h5[contains(text(),'Normal alert')]//..//button
        clickJsAlertBut2.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Something went wrong!";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
    }
    @Test
    public void HTMLALERT() throws InterruptedException {
    /*
    TASK 3 (HTML ALERT)
    1)Navigate to "https://sweetalert.js.org/"
    2)Click first preview(which is on the bottom right one)
    3)Validate the text on pop-up
    4)Handle the pop up
     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        WebElement clickJsAlertBut3 = driver.findElement(By.xpath("//button[@onclick=\"swal('Oops', 'Something went wrong!', 'error')\"]"));////h5[contains(text(),'SweetAlert')]//..//button
                                                                                                // ->  //button[contains(@onclick,'swal')]
        clickJsAlertBut3.click();Thread.sleep(500);
        WebElement text = driver.findElement(By.xpath("//div[.='Something went wrong!']"));
        String actualText = text.getText();
        String expectedText = "Something went wrong!";
        Assert.assertEquals(actualText,expectedText);Thread.sleep(500);
        WebElement clickBut = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
        clickBut.click();
    }
    }


