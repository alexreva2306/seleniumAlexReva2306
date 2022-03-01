package actionClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ActionClassMethods {

    //ContextClick() --> rightClick

    @Test
    public void ContextClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.partialLinkText("Context"));
        contextMenu.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //Action Class you must use perform at the end
        actions.contextClick(box).perform();

    }
    @Test
    public void HoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement hovers = driver.findElement(By.partialLinkText("Hovers"));
        hovers.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List <WebElement> pictures = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");//--> for small comparism, 2-3 items.

        for(int i =0;i<names.size();i++){
            Thread.sleep(2000);
            actions.moveToElement(pictures.get(i)).perform();//--> hover over here

            Assert.assertEquals(BrowserUtils.getTextMethod(names.get(i)),expectedNames.get(i));
            System.out.println(BrowserUtils.getTextMethod(names.get(i))); //--> get text here
        }
    }

    @Test
    public void doubleClick(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");
        driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
      //  actions.doubleClick(doubleClickButton).perform();   //---> both these lines works, we just hide them to be able to run next lines
       // actions.doubleClick(driver.findElement(By.tagName("button"))).perform();

        WebElement rightClick = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClick).perform();

    }
    //TASK FOR STUDENTS
        /*
        Scenario to Automate:
1. Launch the Chrome web browser.
2. Open a URL "https://selenium08.blogspot.com/2019/11/double-click.html".
3. Locate the element "Double-click".
4.  click on the current location (i.e. on Double-click element).
5. Close the web browser.
         */
    @Test
    public void doubleClickPractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");
        driver.manage().window().maximize();

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));
        Actions actions = new Actions(driver);
          actions.doubleClick(doubleClickButton).perform();

    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        acceptCookies.click();
        Actions actions = new Actions(driver);
        for(int i =0; i<5;i++) {
            Thread.sleep(3000);
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getTextMethod(orangeBox);
        String expectedMessage =  "... Or here.";
        Assert.assertEquals(actualMessage,expectedMessage);
        actions.dragAndDrop(dragable,orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualAfterDragAndDrop = BrowserUtils.getTextMethod(orangeBox);
       String expectedAfterDragAndDrop = "You did great!";
       Assert.assertEquals(actualAfterDragAndDrop,expectedAfterDragAndDrop);

        String actualCssValue = orangeBox.getCssValue("background-color");
        String expectedCssValue = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualCssValue,expectedCssValue);

    }
    @Test
    public void clickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        driver.manage().window().maximize();
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        acceptCookies.click();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualBlueBoxMessage = BrowserUtils.getTextMethod(blueBox);
        String expectedBlueBoxMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueBoxMessage,expectedBlueBoxMessage);

        WebElement dragable = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragable).moveToElement(blueBox).release().perform();

    }
    /*\
           1)Navigate to the website :"https://demoqa.com/droppable"
           2)Drag Drag me box and drop to drop box
           3)Validate the message is changed to "Dropped"
           4)Validate the css color is steel blue

            */
    @Test
    public void dragAndDropPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropContainer = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragMe).moveToElement(dropContainer).release().perform();
        Thread.sleep(1000);
        dropContainer = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));

        String actualCssValue = dropContainer.getCssValue("background-color");
        String expectedCssValue = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualCssValue,expectedCssValue);
    }

    /*
     1)Navigate to the website :"https://demoqa.com/droppable"
     2)Click Accept
     3)ClickAndHold notAccepted box and release to Drop box
     4)validate the background is still white and message is still Drop here
     5)ClickAndHold acceptable box and release to Drop box
     6)Validate the background is blue and message is dropped
      */
    @Test
    public void dragAndNameStaySamePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        WebElement acceptClick = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptClick.click();

        WebElement dragMeNotAcceptable = driver.findElement(By.xpath("//div[.='Not  Acceptable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(dragMeNotAcceptable).moveToElement(dropHere).release().perform();
        Thread.sleep(1000);
        dropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));

        String actualCssValue = dropHere.getCssValue("background-color");
        String expectedCssValue = "rgba(0, 0, 0, 0)";
        Assert.assertEquals(actualCssValue,expectedCssValue);

        Thread.sleep(1000);
        WebElement isStillDropHere = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        String actText = isStillDropHere.getText().trim();
        String expTest = "Drop here";
        Assert.assertEquals(actText,expTest);

        Thread.sleep(1000);

        WebElement dragMeAcceptable = driver.findElement(By.xpath("//div[@id='acceptable']"));
        WebElement dropHere1 = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@class='drop-box ui-droppable']//p"));
        Actions actions1 = new Actions(driver);
        actions1.clickAndHold(dragMeAcceptable).moveToElement(dropHere1).release().perform();
        Thread.sleep(1000);

        dropHere1 = driver.findElement(By.xpath("//div[@id='droppable' and @class='drop-box ui-droppable ui-state-highlight']"));

        String actualCssValue1 = dropHere1.getCssValue("background-color");
        String expectedCssValue1 = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualCssValue1,expectedCssValue1);
        Thread.sleep(1000);

        WebElement isStillDropedHere1 = driver.findElement(By.xpath("//p[.='Dropped!']"));
        String actText1 = isStillDropedHere1.getText().trim();
        String expTest1 = "Dropped!";
        Assert.assertEquals(actText1,expTest1);


    }
    @Test
    public void MoveByOffSet(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.xpath("//input"));
        Actions actions = new Actions(driver);
        //x means --> horizontal. y --> means vertical
        actions.clickAndHold(slider).moveByOffset(-30,0).perform();

    }

    @Test
    public void sliderShortCut() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        WebElement slider = driver.findElement(By.xpath("//input"));
        WebElement range = driver.findElement(By.xpath("//span[@id='range']"));
        String myRange ="3.5";
        while (!range.getText().trim().equals(myRange)){
            Thread.sleep(1000);
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }
    @Test
    public void moveByOffSetPractice(){
        //Task
        //By using move by off set and point class
        //click contact us
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.techtorialacademy.com/");
        WebElement contactUs = driver.findElement(By.xpath("//div[@class='navigation hidden-xs']//a[.='Contact Us']"));
        Point coordinatesOfContactUs =  contactUs.getLocation();
        int xCoord = coordinatesOfContactUs.getX();
        int yCoord = coordinatesOfContactUs.getY();
        Actions actions = new Actions(driver);
        actions.moveByOffset(xCoord,yCoord).click().perform();


    }
}
