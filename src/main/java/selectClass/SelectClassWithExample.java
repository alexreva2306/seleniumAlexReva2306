package selectClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectClassWithExample {
    @Test
    public void validTripButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayBut = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayBut.click();
        Assert.assertTrue(oneWayBut.isDisplayed());//it must be true to pass the assertion
        Assert.assertTrue(oneWayBut.isSelected());

        WebElement roundTripButton = driver.findElement(By.xpath("//input[@value='roundtrip']"));
        Assert.assertTrue(roundTripButton.isSelected());
        Assert.assertTrue(roundTripButton.isDisplayed());
    }

    @Test
    public void SelectMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        WebElement oneWayBut = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayBut.click();

        WebElement passengerCount = driver.findElement(By.name("passCount"));
        BrowserUtils.selectBy(passengerCount,"2","value");
//        Select psngr = new Select(passengerCount);
//        psngr.selectByIndex(1);

        WebElement departFrom = driver.findElement(By.name("fromPort"));
        BrowserUtils.selectBy(departFrom,"Paris","text");
//        Select depart = new Select(departFrom);
//        depart.selectByValue("Sydney");

        WebElement month = driver.findElement(By.name("fromMonth"));
        BrowserUtils.selectBy(month,"April","text");
//        Select mnth = new Select(month);
//        mnth.selectByVisibleText("April");

        WebElement day = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(day,"23","text");
//        Select dy = new Select(day);
//        dy.selectByVisibleText("23");

        WebElement departTo  = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(departTo,"London","text");
//        Select depTo = new Select(departTo);
//        depTo.selectByVisibleText("London");

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toMonth,"June","text");
//        Select toMnth = new Select(toMonth);
//        toMnth.selectByVisibleText("June");

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDay,"29","text");
//        Select toDy = new Select(toDay);
//        toDy.selectByVisibleText("29");

        WebElement businessClass = driver.findElement(By.xpath("//input[@value='Business']"));
        businessClass.click();

        WebElement airLine = driver.findElement(By.xpath("//select[@name='airline']"));
        Select aL = new Select(airLine);
        aL.selectByVisibleText("Pangea Airlines");

        WebElement continueBut = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBut.click();
        Thread.sleep(1000);

        WebElement message = driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']//font[@size='4']"));
        String actual = message.getText();
        String expected = "After flight finder - No Seats Available";
        Assert.assertEquals(actual,expected);
    }
}
