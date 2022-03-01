package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionKeys {

    @Test
    public void keys(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        actions.moveToElement(googleSearchBox)
                .click().keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("elenium")
                .doubleClick().keyDown(Keys.COMMAND)  //for windows do control
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER).perform();  //Keys.RETURN / Keys.ENTER

       // googleSearchBox.sendKeys("SeleniumSelenium");
    }

    /*
    TASK FOR STUDENTS:
1)navigate to the Website "https://text-compare.com/"
2)Type with the Keys --> "Good Bye Keys"
3)with CTRL(COMMAND)+A --> select all text
4)Copy this text CTRL(COMMAND) + C --> it will copy the text
5)Go to the second box and paste CTRL(COMMAND) + V-->it will paste the text
6) Validate this two boxes text are matching
     */
    @Test
    public void copyPaste() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebElement typoArea = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        actions.moveToElement(typoArea).click().keyDown(Keys.SHIFT)
                .sendKeys("g").keyUp(Keys.SHIFT).sendKeys("ood ")
                .keyDown(Keys.SHIFT)
                .sendKeys("b").keyUp(Keys.SHIFT).sendKeys("ye ")
                .keyDown(Keys.SHIFT).sendKeys("k").keyUp(Keys.SHIFT)
                .sendKeys("eys").keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND)
                .keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND)
                .perform();
        Thread.sleep(1000);
        WebElement typoArea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        actions.moveToElement(typoArea2).click().keyDown(Keys.COMMAND).sendKeys("v")
                .keyUp(Keys.COMMAND).perform();
        typoArea = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
        typoArea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));
        String first = typoArea.getText().trim();
        String secoind = typoArea2.getText().trim();
        Assert.assertEquals(first,secoind);
    }
}
