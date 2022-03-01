package teamProject2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TeatCases {

    @Test
    public void allSumPrices() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        WebElement validateCart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        System.out.println(validateCart.getText());
        String actualCartText = validateCart.getText();
        String expectedCarttext = "Cart (empty)";
        Assert.assertEquals(actualCartText,expectedCarttext);
        List<WebElement> productPrices = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li//div[@class='content_price']//span[@itemprop='price']"));
          List<String> prices= new LinkedList<>();
        double actSum =0;
        for(int i=0; i<productPrices.size();i++){
            Thread.sleep(1000);
            if(productPrices.get(i).getText().contains("$")) {
                prices.add(productPrices.get(i).getText().trim().replace("$","").replace(" ",""));
            }
        }
        for(int i=0;i<prices.size();i++){
            Thread.sleep(1000);
            actSum+= Double.parseDouble(prices.get(i));
        }
        double expSum = 196.38;
        Assert.assertEquals(actSum,expSum);

    }


    @Test
    public void cheapestPrice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        List<WebElement> productPrices = driver.findElements(By.xpath("//*[@id=\"homefeatured\"]/li//div[@class='content_price']//span[@itemprop='price']"));
        List<String> prices= new LinkedList<>();

        for(int i=0; i<productPrices.size();i++){
            Thread.sleep(300);
            if(productPrices.get(i).getText().contains("$")) {
                prices.add(productPrices.get(i).getText().trim().replace("$","").replace(" ",""));
            }
        }
    Collections.sort(prices);
        Thread.sleep(300);
        double actualCheapest = Double.parseDouble(prices.get(0));
       double expCheapest = 16.40;
       Assert.assertEquals(actualCheapest,expCheapest);
    }
    @Test
    public void colorVal() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

    }
}
