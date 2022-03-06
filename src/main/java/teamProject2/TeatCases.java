package teamProject2;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        WebElement firstEl = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
        if(firstEl.isDisplayed()){
            Actions actions = new Actions(driver);
            actions.moveToElement(firstEl).perform();
            WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"));
            addToCart.click();Thread.sleep(1000);
            WebElement text = driver.findElement(By.xpath("//div//h2//i//.."));
            String actText = text.getText().trim();
            String expected = "Product successfully added to your shopping cart";
            Assert.assertEquals(actText,expected);
            Thread.sleep(1000);
            String actualCssValue = text.getCssValue("color");
            String expectedCssValue = "rgba(70, 167, 78, 1)";
            Assert.assertEquals(actualCssValue,expectedCssValue);
        }


    }
    @Test
    public void summerDress() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement women = driver.findElement(By.xpath("//a[.='Women']"));
        women.click();Thread.sleep(200);
        WebElement dresses = driver.findElement(By.xpath("//h5//a[.='Dresses']"));
        dresses.click();Thread.sleep(200);
        WebElement summerDresses = driver.findElement(By.xpath("//h5//a[.='Summer Dresses']"));
        summerDresses.click();Thread.sleep(200);
        WebElement firstEl = driver.findElement(By.xpath("//h5//a[contains(text(),'Printed Summer Dress')]//..//..//div//span[contains(text(),'$28.98')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstEl).perform();Thread.sleep(1000);
        WebElement addToCart = driver.findElement(By.xpath("//a[@data-id-product='5']//span[contains(text(),'Add to cart')]"));
        actions.moveToElement(addToCart).click().perform();
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//div//h2//i//.."));
        String actText = text.getText().trim();
        String expected = "Product successfully added to your shopping cart";
        Assert.assertEquals(actText,expected);Thread.sleep(200);
        WebElement text1 = driver.findElement(By.xpath("//strong[.='Total']//..//span"));
        String actText1 = text1.getText().trim();
        String expected1 = "$28.98";
        Assert.assertEquals(actText1,expected1);Thread.sleep(200);
        WebElement text2 = driver.findElement(By.xpath("//span[@class='ajax_cart_product_txt ']"));
        String actText2 = text2.getText().trim();
        String expected2 = "There is 1 item in your cart.";
        Assert.assertEquals(actText2,expected2);Thread.sleep(200);
        WebElement contShop = driver.findElement(By.xpath("//span//i[@class='icon-chevron-left left']"));
        contShop.click();Thread.sleep(1000);
        WebElement text3 = driver.findElement(By.xpath("//a[@title='View my shopping cart']//span[.='1']"));
        String actText3 = "Cart "+text3.getText().trim()+" Product";
        String expected3 = "Cart 1 Product";
        Assert.assertEquals(actText3,expected3);Thread.sleep(200);
    }
    @Test
    public void validPrice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement women = driver.findElement(By.xpath("//a[.='Women']"));
        women.click();
        Thread.sleep(200);
        WebElement dresses = driver.findElement(By.xpath("//h5//a[.='Dresses']"));
        dresses.click();
        Thread.sleep(200);
        WebElement summerDresses = driver.findElement(By.xpath("//h5//a[.='Summer Dresses']"));
        summerDresses.click();
        Thread.sleep(200);
        WebElement firstEl = driver.findElement(By.xpath("//h5//a[contains(text(),'Printed Summer Dress')]//..//..//div//span[contains(text(),'$28.98')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstEl).perform();
        Thread.sleep(4000);
        WebElement addToCart = driver.findElement(By.xpath("//a[@data-id-product='5']//span[contains(text(),'Add to cart')]"));
       addToCart.click();Thread.sleep(4000);
        WebElement contShop = driver.findElement(By.xpath("//span//i[@class='icon-chevron-left left']"));
        contShop.click();Thread.sleep(200);
        WebElement cart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
        cart.click();Thread.sleep(200);
        WebElement totPrice = driver.findElement(By.xpath("//td[.='$30.98']"));
        WebElement totProd = driver.findElement(By.xpath("//td[.='$28.98']"));
        WebElement totShip = driver.findElement(By.xpath("//td[.='$2.00']"));
        double a = Double.parseDouble(""+totPrice.getText().trim().substring(1));Thread.sleep(200);
        double b = Double.parseDouble(""+totProd.getText().trim().substring(1)) +Double.parseDouble(""+totShip.getText().trim().substring(1));
        Thread.sleep(200); Assert.assertEquals(a,b);Thread.sleep(200);
        WebElement addOne = driver.findElement(By.xpath("//i[@class='icon-plus']"));
        addOne.click();Thread.sleep(1000);
        WebElement totPrice2 = driver.findElement(By.xpath("//td[.='$59.96']"));
        WebElement totProd2 = driver.findElement(By.xpath("//td[.='$57.96']"));
        WebElement totShip2 = driver.findElement(By.xpath("//td[.='$2.00']"));
        double a2 = Double.parseDouble(""+totPrice2.getText().trim().substring(1));Thread.sleep(200);
        double b2 = Double.parseDouble(""+totProd2.getText().trim().substring(1)) +Double.parseDouble(""+totShip2.getText().trim().substring(1));
        Thread.sleep(200); Assert.assertEquals(a2,b2);Thread.sleep(1000);
        WebElement minusOne = driver.findElement(By.xpath("//i[@class='icon-minus']"));
        minusOne.click();Thread.sleep(3000);
        WebElement totPrice1 = driver.findElement(By.xpath("//td[.='$30.98']"));
        WebElement totProd1 = driver.findElement(By.xpath("//td[.='$28.98']"));
        WebElement totShip1 = driver.findElement(By.xpath("//td[.='$2.00']"));
        double a1 = Double.parseDouble(""+totPrice1.getText().trim().substring(1));Thread.sleep(200);
        double b1 = Double.parseDouble(""+totProd1.getText().trim().substring(1)) +Double.parseDouble(""+totShip1.getText().trim().substring(1));
        Thread.sleep(200); Assert.assertEquals(a1,b1);Thread.sleep(200);
    }

    @Test
    public void showingItems() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement women = driver.findElement(By.xpath("//a[.='Women']"));
        women.click();
        Thread.sleep(200);
        WebElement dresses = driver.findElement(By.xpath("//h5//a[.='Dresses']"));
        dresses.click();
        Thread.sleep(200);
        WebElement summerDresses = driver.findElement(By.xpath("//h5//a[.='Summer Dresses']"));
        summerDresses.click();
        Thread.sleep(200);
        WebElement text1 = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 - 3')]"));
        String actText1 = BrowserUtils.getTextMethod(text1);
        String expected1 = "Showing 1 - 3 of 3 items";
        Assert.assertEquals(actText1,expected1);Thread.sleep(200);
        
    }
}
