package teamProject.Madina;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
public class MadinasTest {
 /*
    Navigate to
"http://secure.smartbearsoftware.com/sampl
es/TestComplete11/WebOrders/Login.aspx?"
Validate the title is equals to "Web Orders login"

Input username "Tester"
Input password "test"
Click login button
Validate the title is equals to "Web Orders"
Validate header is equals to "List of All
Orders"
Test Scenario
     */

    @Test
    public void case1() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle, "it is not expected title");
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username' and @id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password' and @id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button' and @id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        login.click();
        WebElement titleWeb_Orders = driver.findElement(By.xpath("//h1"));
        String actualTitle1 = titleWeb_Orders.getText();
        String expectedTitle1 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle1, "it is not expected title");
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        Thread.sleep(1000);
        viewAllOrders.click();
        WebElement headerListOfAll = driver.findElement(By.xpath("//h2"));
        String expectedHeaderListOfAll = "List of All Orders";
        String actualHeaderListOfAll = headerListOfAll.getText();
        Assert.assertEquals(actualTitle, expectedTitle, "it is not expected header");
    }

    /*
    Navigate to
    "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Click "View all products" button
    Validate "View all products" is selected
    Validate header is equals to "List of Products"
    Validate the url has "Products" keyword
    Test Scenario
     */
    @Test
    public void case2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");

        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username' and @id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password' and @id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button' and @id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        login.click();
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        Thread.sleep(1000);
        boolean ActualViewAllProducts = viewAllProducts.isDisplayed();
        boolean ExpectedViewAllProducts = true;
        Assert.assertEquals(ActualViewAllProducts, ExpectedViewAllProducts, "View all products is not selected");
        viewAllProducts .click();
        WebElement headerListOfProducts = driver.findElement(By.xpath("//h2"));
        String expectedHeaderListOfProducts = "List of Products";
        String actualHeaderListOfProducts = headerListOfProducts.getText();
        Assert.assertEquals(expectedHeaderListOfProducts, actualHeaderListOfProducts, "it is not expected header");

        boolean ActualURL = driver.getCurrentUrl().contains("Products");
        boolean ExpectedURL = true;
        Assert.assertEquals(ActualURL, ExpectedURL, "the url is missing Products keyword");
    }
    /*
    Navigate to
    "http://secure.smartbearsoftware.com/sampl
    es/TestComplete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Find the links for
    View all orders
    View all products
    Orders
    Validate their href values are equals to :
    "Default.aspx"
    "Products.aspx"
    "Process.aspx"

     */
    @Test
    public void case3() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");

        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username' and @id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password' and @id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button' and @id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        login.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        Thread.sleep(1000);
        viewAllOrders.click();
        Boolean actualDefaultKeyword = driver.getCurrentUrl().contains("Default.aspx");
        Boolean expectedDefaultKeyword = true;
        Assert.assertEquals(actualDefaultKeyword, expectedDefaultKeyword, "the href value is missing Default.aspx keyword");
        WebElement viewAllProducts = driver.findElement(By.xpath("//a[@href='Products.aspx']"));
        Thread.sleep(1000);
        viewAllProducts.click();
        Boolean actualProductsKeyword = driver.getCurrentUrl().contains("Products.aspx");
        Boolean expectedProductsKeyword = true;
        Assert.assertEquals(actualProductsKeyword, expectedProductsKeyword, "the href value is missing Products.aspx keyword");

        WebElement order = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        Thread.sleep(1000);
        order.click();
        Boolean actualProcessKeyword = driver.getCurrentUrl().contains("Process.aspx");
        Boolean expectedProcessKeyword = true;
        Assert.assertEquals(actualProcessKeyword, expectedProcessKeyword, "the href value is missing Products.aspx keyword");

    }
    /*
    Navigate to
    "http://secure.smartbearsoftware.com/samples/TestCom
    plete11/WebOrders/Login.aspx?"
    Input username "Tester"
    Input password "Test"
    Click login button
    Click "Order" button
    Select product "Screen Saver"
    Input quantity 5
    Input Customer name "Techtorial Academy"
    Input Street "2200 E devon"
    Input City "Des Plaines"
    Input State "Illinois"
    Input Zip "60018"
    Select MasterCard
    Input card number "444993876233"
    Input expiration date "03/21"
    Click Process button
    Validate text "New order has been
    successfully added." is displayed
    Click View all orders button
    Validate new order is added and all inputs
    are matching with new order
     */
    @Test
    public void case4() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fProcess.aspx");

        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username' and @id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password' and @id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement login = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button' and @id='ctl00_MainContent_login_button']"));
        Thread.sleep(1000);
        login.click();
        WebElement orderButton = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct' and @id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Thread.sleep(1000);
        orderButton.click();
        WebElement screenSaver = driver.findElement(By.xpath("//option[.='ScreenSaver']"));
        Thread.sleep(1000);
        screenSaver.click();
        WebElement orderButton1 = driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct' and @id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Thread.sleep(1000);
        orderButton1.click();

        WebElement inputQuantity = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
        String n = Keys.chord(Keys.CONTROL, "A");
        //overwrite value
        inputQuantity.sendKeys(n, "5");

        WebElement inputCustomer = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName' and @id='ctl00_MainContent_fmwOrder_txtName']"));
        inputCustomer.sendKeys("Techtorial Academy");
        WebElement inputStreet = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2' and @id='ctl00_MainContent_fmwOrder_TextBox2']"));
        inputStreet.sendKeys("2200 E Devon");
        WebElement inputCity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3' and @id='ctl00_MainContent_fmwOrder_TextBox3']"));
        inputCity.sendKeys("Des Plaines");
        WebElement inputState = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4' and @id='ctl00_MainContent_fmwOrder_TextBox4']"));
        inputState.sendKeys("Illinois");
        WebElement inputZip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5' and @id='ctl00_MainContent_fmwOrder_TextBox5']"));
        inputZip.sendKeys("60018");
        WebElement selectMasterCard = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_1' and @name='ctl00$MainContent$fmwOrder$cardList']"));
        selectMasterCard.click();
        WebElement inputCardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6' and @id='ctl00_MainContent_fmwOrder_TextBox6']"));
        inputCardNumber.sendKeys("444993876233");
        WebElement inputExpirationDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1' and @id='ctl00_MainContent_fmwOrder_TextBox1']"));
        inputExpirationDate.sendKeys("03/21");
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton' ]"));
        processButton.click();
        WebElement textValidation = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/div/strong"));
        boolean expectedText = textValidation.isDisplayed();
        boolean actualText = true;
        Assert.assertEquals(expectedText,actualText,"New order has been successfully added is not displayed");
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[@href='Default.aspx']"));
        Thread.sleep(1000);
        viewAllOrders.click();
        String actualInput = "";
        String expectedInput= "Techtorial AcademyScreenSaver502/12/20222200 E DevonDes PlainesIllinois60018MasterCard44499387623303/21";
        List<WebElement> allLinks = driver.findElements(By.xpath("//tbody/tr[2]/td"));
        for(int i=1; i< allLinks.size();i++){
            actualInput+=allLinks.get(i).getText();
        }
        Assert.assertEquals(expectedInput, actualInput);



    }
}
