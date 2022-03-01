package Homework.HomeWork4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class HW4 {

    /*
    Homework-3
 Test Case 1
Navigate to "https://demos.telerik.com/kendo-ui/websushi#"
Click on top of Shiromi picture
Click > arrow
validate next item is Tekka maki Click < arrow
Validate the item is Shiromi
Validate number of item 0 in the cart
Steps
SELENIUM TECTHTORIAL
*/
    @Test
    public void validTekkaShiromi() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement sashSalad = driver.findElement(By.xpath("//strong[.='Shiromi']"));
        sashSalad.click();
        WebElement nextEl = driver.findElement(By.xpath("//a[@id='navigate-next']"));
        nextEl.click();
        Thread.sleep(1000);
        WebElement tekkaMaki = driver.findElement(By.xpath("//a[@id='navigate-next']"));
        boolean actualtM = tekkaMaki.isDisplayed();
        boolean expectedTM = true;
        Assert.assertEquals(actualtM,expectedTM);
        WebElement navigPrev = driver.findElement(By.xpath("//a[@id='navigate-prev']"));
        navigPrev.click();
        Thread.sleep(1000);
        WebElement shirVal = driver.findElement(By.xpath("//h1[.='Shiromi']"));
        boolean actShir = shirVal.isDisplayed();
        boolean expShir = true;
        Assert.assertEquals(actShir,expShir);
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@href='#']//span[.='0']"));
        String actIsEmpty = shoppingCart.getText().trim();
        String expIsEmpty = "0";
        Assert.assertEquals(actIsEmpty,expIsEmpty);
    }
    /*
 Test Case 2
Steps
Navigate to "https://demos.telerik.com/kendo- ui/websushi#"
Click Add to cart for Edamame
Validate Item number is 1
Validate price of the product is $4 Click empty cart
Validate item number is 0
SELENIUM TECTHTORIAL
*/
    @Test
    public void addAndValidate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement edamame = driver.findElement(By.xpath("//li[4]//button[.='Add to cart']"));
        edamame.click();
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@href='#']//span[.='1']"));
        String actIsEmpty = shoppingCart.getText().trim();
        String expIsEmpty = "1";
        Assert.assertEquals(actIsEmpty,expIsEmpty);
        Thread.sleep(1000);
        WebElement price = driver.findElement(By.xpath("//p[.='$4.00']"));
        String actPrice = price.getText().trim();
        String expPrice = "$4.00";
        Assert.assertEquals(actPrice,expPrice);
        Thread.sleep(300);
        WebElement emptyCart = driver.findElement(By.xpath("//a[.='empty cart']"));
        emptyCart.click();
        Thread.sleep(1000);
        shoppingCart = driver.findElement(By.xpath("//a[@href='#']//span[.='0']"));
        String actIsEmpty1 = shoppingCart.getText().trim();
        String expIsEmpty1 = "0";
        Assert.assertEquals(actIsEmpty1,expIsEmpty1);
    }

    /*
 Test Case 3
Navigate to "https://demos.telerik.com/kendo- ui/websushi#"
Click picture of the Salmon Teriyaki
Click Add to cart button 2 times
Validate total price is $26 Validate item number is 1 Click > arrow button
Click add to cart for Gohan Validate total price is $29 Validate total items 2
Steps
SELENIUM TECTHTORIAL
*/
    @Test
    public void salmonTeriyaki() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();

        WebElement salmonTer = driver.findElement(By.xpath("//strong[.='Salmon Teriyaki']"));
        salmonTer.click();  Thread.sleep(300);
        WebElement butAdd1 = driver.findElement(By.xpath("//button[.='Add to cart']"));
        butAdd1.click();  Thread.sleep(300);
        WebElement butAdd2 = driver.findElement(By.xpath("//button[.='Add to cart']"));
        butAdd2.click();  Thread.sleep(300);
        WebElement price = driver.findElement(By.xpath("//p[.='$26.00']"));
        String actPrice = price.getText().trim();
        String expPrice = "$26.00";
        Assert.assertEquals(actPrice,expPrice);Thread.sleep(300);
        WebElement isOne = driver.findElement(By.xpath("//span[.='1']"));
        String actIsOne = isOne.getText().trim();
        String expIsOne = "1";
        Assert.assertEquals(actIsOne,expIsOne);Thread.sleep(300);
        WebElement navNext = driver.findElement(By.xpath("//a[@id='navigate-next']"));
        navNext.click();Thread.sleep(300);
        WebElement butAdd3 = driver.findElement(By.xpath("//button[.='Add to cart']"));
        butAdd3.click();  Thread.sleep(300);
        WebElement price1 = driver.findElement(By.xpath("//p[.='$29.00']"));
        String actPrice1 = price1.getText().trim();
        String expPrice1 = "$29.00";
        Assert.assertEquals(actPrice1,expPrice1);Thread.sleep(300);
        WebElement isTwo = driver.findElement(By.xpath("//span[.='2']"));
        String actIsTwo = isTwo.getText().trim();
        String expIsTwo = "2";
        Assert.assertEquals(actIsTwo,expIsTwo);Thread.sleep(300);
    }
/*
 Test Case 4
Steps
Navigate to "https://demos.telerik.com/kendo- ui/websushi#"
Validate price of all the products are less than $25
SELENIUM TECTHTORIAL
*/
    @Test
    public void ifPricesLesThan() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(300);
        List<WebElement> allElements  = driver.findElements(By.xpath("//span[@data-bind='text: price']"));
        List <String> allPrices = new LinkedList<>();

        for(int i =0;i< allElements.size();i++){
            Thread.sleep(300);
            allPrices.add(allElements.get(i).getText().trim());
        }
        //System.out.println(allPrices);
        double constanta = 25.00;
        boolean actual = true;
        boolean expected = false;
        for(int i =0;i< allPrices.size();i++){
            Thread.sleep(300);
           if(Double.parseDouble(allPrices.get(i))<constanta){
               Thread.sleep(300);
              expected= true;
           }
        }
        Thread.sleep(300);
        Assert.assertEquals(actual,expected);
    }
    /*

 Test Case 5
Navigate to "https://demos.telerik.com/kendo- ui/websushi#"
Add 3 items to your cart
Click X button on the top added items Validate items number is 2
X
Steps
SELENIUM TECTHTORIAL
*/
    @Test
    public void treeItems() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(300);
        WebElement sashimi = driver.findElement(By.xpath("//li[1]//button[.='Add to cart']"));
        sashimi.click();Thread.sleep(300);
        WebElement chirashi = driver.findElement(By.xpath("//li[2]//button[.='Add to cart']"));
        chirashi.click();Thread.sleep(300);
        WebElement seaweed = driver.findElement(By.xpath("//li[3]//button[.='Add to cart']"));
        seaweed.click();Thread.sleep(300);
        WebElement sashimiRemove = driver.findElement(By.xpath("//li[1]//a[@data-bind='click: removeFromCart']"));
        sashimiRemove.click();Thread.sleep(300);
        WebElement isTwo = driver.findElement(By.xpath("//span[.='2']"));
        String actIsTwo = isTwo.getText().trim();
        String expIsTwo = "2";
        Assert.assertEquals(actIsTwo,expIsTwo);Thread.sleep(300);
    }
    /*
 Test Case 6
Navigate to "https://demos.telerik.com/kendo- ui/websushi#"
Add Shiromi and Ebi Rolls into the cart
Click checkout button
Validate total price is 17
Increase the count of Ebi Roll with 2 Validate total is $25
Click order now
Validate cart is 0
     */
    @Test
    public void checkOut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/websushi#");
        driver.manage().window().maximize();
        Thread.sleep(300);
        WebElement shiromi = driver.findElement(By.xpath("//li[8]//button[.='Add to cart']"));
        shiromi.click();Thread.sleep(300);
        WebElement ebi = driver.findElement(By.xpath("//li[14]//button[.='Add to cart']"));
        ebi.click();Thread.sleep(300);
        WebElement checkOutBut = driver.findElement(By.xpath("//a[@id='checkout']"));
        checkOutBut.click();Thread.sleep(300);
        WebElement price = driver.findElement(By.xpath("//span[.='$17.00']"));
        String actPrice = price.getText().trim();
        String expPrice = "$17.00";
        Assert.assertEquals(actPrice,expPrice);Thread.sleep(300);

        Actions actions = new Actions(driver);
        WebElement ebi2 = driver.findElement(By.xpath("//tr[2]//button[@aria-label='Increase value']"));
        actions.moveToElement(ebi2).click().sendKeys(Keys.ENTER).perform();
        Thread.sleep(300);
        price = driver.findElement(By.xpath("//span[.='$25.00']"));
        String actPrice1 = price.getText().trim();
        String expPrice1 = "$25.00";
        Assert.assertEquals(actPrice1,expPrice1);Thread.sleep(300);
        WebElement orderNowBut = driver.findElement(By.xpath("//button[.='order now!']"));
        orderNowBut.click();Thread.sleep(300);
        WebElement isZero = driver.findElement(By.xpath("//span[.='0']"));
        String actIsZero = isZero.getText().trim();
        String expIsZero = "0";
        Assert.assertEquals(actIsZero,expIsZero);
    }
}
