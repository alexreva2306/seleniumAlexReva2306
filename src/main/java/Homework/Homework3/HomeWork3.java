package Homework.Homework3;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
/*
 Test Case 1
Steps
Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Name (Z-A) from drop down box
Validate the products are displayed in descending order
SELENIUM TECTHTORIAL
 Test Case 2
Steps
Steps
Navigate to "https://www.saucedemo.com/"
Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Select Price (low-high) from drop down box
Validate the products are displayed according to their price and they are displayed low price to high price
SELENIUM TECTHTORIAL

 TASK
Functionality-Acceptance Criteria(Gherkin Language)
Given the user on saucedemo home page
Then user click the burger button on saucedemo home page And the user will click the logout button
And user should see the login page
When the user navigate back from login page
Then the user still should see login page
SELENIUM TECTHTORIAL
Description: The user should not see the home page after logout since the user already click the logout button. Write the
test case to test this function and validate it is working correctly or not.

 Test Case 3
Steps
Steps
Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the cheapest two product on the page
Add them to the cart
Click cart button
Validate these two products is added to the cart
SELENIUM TECTHTORIAL

 Test Case 4 Part-1
Steps
Navigate to "https://www.saucedemo.com/" Enter username "standard_user"
Enter password "secret_sauce"
Click Login button
Find the highest priced two product on the page Add them to the cart
Click cart button
Click CheckOut Button
Steps
SELENIUM TECTHTORIAL

 Test Case 4 Part-2
Fill out First Name, Last Name and Zip Code Click continue button
Validate Item total price is equals to total price of selected product
Validate Total is equals to Item Total price plus Tax amount
Validate the Url contains "checkout"
Click finish button
Validate "THANK YOU FOR YOUR ORDER" message is displayed
Steps
SELENIUM TECTHTORIAL

 Test Case 5
 Steps
Navigate to "https://demoqa.com/select-menu" Select Group 2, option 1
Select Prof. and validate they are selected.
 */
public class HomeWork3 {

    @Test
    public void validOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement uresName = driver.findElement(By.id("user-name"));
        uresName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Thread.sleep(200);
        WebElement dropBox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.selectBy(dropBox,"za","value");


        List <WebElement> headers = driver.findElements(By.xpath("//a//div[@class='inventory_item_name']"));
        List<String> actualDescendingOrder = new LinkedList<>();
        List<String> expectedDescendingOrder = new ArrayList<>();
       // List <String>
        Thread.sleep(1000);
        for(int i=0;i<headers.size();i++){
        actualDescendingOrder.add(headers.get(i).getText().trim());
         expectedDescendingOrder.add(headers.get(i).getText().trim());
            Collections.sort(expectedDescendingOrder);
            Collections.reverse(expectedDescendingOrder);
        }
        Assert.assertEquals(actualDescendingOrder,expectedDescendingOrder);

    }

    @Test
    public void validProduct() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement uresName = driver.findElement(By.id("user-name"));
        uresName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Thread.sleep(200);
        WebElement dropBox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.selectBy(dropBox,"lohi","value");

        List <WebElement> keys = driver.findElements(By.xpath("//a//div[@class='inventory_item_name']"));
        List<WebElement> valuesPrices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        Map<String,String> keysValues = new LinkedHashMap<>();


        Thread.sleep(200);

        for(int i=0;i< keys.size();i++){
            keysValues.put(keys.get(i).getText().trim(),valuesPrices.get(i).getText().trim());

        }
        System.out.println(keysValues);
    }
    @Test
    public void logOut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement uresName = driver.findElement(By.id("user-name"));
        uresName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Thread.sleep(400);
        WebElement burgerBut = driver.findElement(By.id("react-burger-menu-btn"));
        burgerBut.click();

        Thread.sleep(400);
        WebElement logOut = driver.findElement(By.id("logout_sidebar_link"));
        logOut.click();

        Thread.sleep(400);
        driver.navigate().back();

        Thread.sleep(400);
        WebElement text  = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actText = text.getText();
        String expText = "Epic sadface: You can only access '/inventory.html' when you are logged in.";
        Assert.assertEquals(actText,expText);

        text.isDisplayed();
    }

@Test
    public void lowerTwo() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();

    WebElement uresName = driver.findElement(By.id("user-name"));
    uresName.sendKeys("standard_user");

    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("secret_sauce");

    WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
    loginButton.click();

    Thread.sleep(400);
    WebElement dropBox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
    BrowserUtils.selectBy(dropBox,"lohi","value");
    Thread.sleep(400);
    WebElement firstItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']"));
    WebElement firstHead = driver.findElement(By.xpath("//a[@id='item_2_title_link']"));
    String expectedFirst = firstHead.getText();
    firstItem.click();
    Thread.sleep(400);
    WebElement secondItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
    WebElement secondHead = driver.findElement(By.xpath("//a[@id='item_0_title_link']"));
    String expectedSecond = secondHead.getText();
    secondItem.click();

    Thread.sleep(400);
    WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
    cart.click();
    Thread.sleep(400);

    WebElement firIt = driver.findElement(By.xpath("//a[@id='item_2_title_link']"));
    String actualFirst = firIt.getText();

    WebElement secIt = driver.findElement(By.xpath("//a[@id='item_0_title_link']"));
    String actualSec = secIt.getText();

    Assert.assertEquals(actualFirst,expectedFirst);
    Assert.assertEquals(actualSec,expectedSecond);
}

    @Test
    public void buyItem() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement uresName = driver.findElement(By.id("user-name"));
        uresName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        Thread.sleep(400);

        WebElement dropBox = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        BrowserUtils.selectBy(dropBox,"hilo","value");
        Thread.sleep(400);
        WebElement firstItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        firstItem.click();

        WebElement secondItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        secondItem.click();
        Thread.sleep(400);
        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();
        Thread.sleep(400);
        WebElement chekOutBut  = driver.findElement(By.xpath("//button[@id='checkout']"));
        chekOutBut.click();
        Thread.sleep(400);

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Alex");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Reva");

        WebElement zip = driver.findElement(By.id("postal-code"));
        zip.sendKeys("32256");
        Thread.sleep(400);
        WebElement continueBut  = driver.findElement(By.xpath("//input[@id='continue']"));
        continueBut.click();
        Thread.sleep(400);

        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        double expectedSum=0;
        List <String> pricesStr = new LinkedList<>();

        for(int i=0;i< prices.size();i++){
            pricesStr.add(prices.get(i).getText().trim().substring(1));
        }
        System.out.println(pricesStr);
        Thread.sleep(400);
        for(int i=0;i< prices.size();i++){
           expectedSum += Double.parseDouble(pricesStr.get(i));
        }
        System.out.println(expectedSum);

        WebElement actS = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        String aS = ""+actS.getText().trim().substring(13);
        double actualSum = Double.parseDouble(aS);
        System.out.println(actualSum);
        Assert.assertEquals(actualSum,expectedSum);

        WebElement tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
        double taxes = Double.parseDouble(""+tax.getText().trim().substring(6));
        System.out.println(taxes);

        WebElement sumOfTwo = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));

         double expectSumTax = Double.parseDouble(""+sumOfTwo.getText().trim().substring(13)) + taxes;

        System.out.println(taxes);
        System.out.println(expectSumTax);
        WebElement sumTax = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        double actualSumTax = Double.parseDouble(""+sumTax.getText().trim().substring(8));
        System.out.println(expectSumTax+"  =  "+actualSumTax);
        Thread.sleep(400);

        String eST = ""+expectSumTax;
        double finalExpectTax = Double.parseDouble(eST.substring(0,5));
        System.out.println(finalExpectTax);
        Assert.assertEquals(actualSumTax,finalExpectTax);

        driver.getCurrentUrl().contains("checkout");
        Thread.sleep(400);
        WebElement finishButton = driver.findElement(By.xpath("//button[@name='finish']"));
        finishButton.click();

        WebElement header = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String actText = header.getText().trim();
        String expText = "THANK YOU FOR YOUR ORDER";
        Assert.assertEquals(actText,expText);

    }

    @Test
    public void selectedTwo() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement dropBox = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
        dropBox.click();
        Thread.sleep(1000); Thread.sleep(1000);
        driver.findElement(By.xpath("//input[1]")).sendKeys("Group 2, option 1", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("Prof.", Keys.ENTER);

        List<WebElement> isSelect = driver.findElements(By.xpath("//div[@class=' css-1uccc91-singleValue']"));

        for (int i =0;i< isSelect.size();i++){
          boolean actualIsSelectedC = isSelect.get(i).isDisplayed();
            boolean expBoxVal = true;
            Assert.assertEquals(actualIsSelectedC,expBoxVal);
        }

    }

}
