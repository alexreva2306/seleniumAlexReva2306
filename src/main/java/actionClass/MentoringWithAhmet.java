package actionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MentoringWithAhmet {

    @Test
    public void practiceHoverOver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
        driver.manage().window().maximize();

        WebElement browser = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']//small[.='Browse']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();

        WebElement dataScience = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and .='Data Science']"));
        actions.moveToElement(dataScience).perform();
        //need to finish

    }

    @Test
    public void planBPractice () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> pictures = driver.findElements(By.xpath("//div[@role='listitem']"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product k-listview-item']//p"));
        List <Double> prices = new ArrayList<>();
        Actions actions = new Actions(driver);
        for(int i=0;i<pictures.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform();
            prices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));
        }
        Collections.sort(prices);
        System.out.println(prices);
    }
    /*
        @Test
    public void PlanBpractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        driver.manage().window().maximize();
        List<WebElement> pictures=driver.findElements(By.xpath("//div[@role='listitem']"));
        List<WebElement> allPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<Double> prices=new ArrayList<>();
        Actions actions=new Actions(driver);
        for(int i = 0; i<pictures.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(pictures.get(i)).perform();
            prices.add(Double.parseDouble(allPrices.get(i).getText().trim().replace("$","")));
        }
        Collections.sort(prices);
        System.out.println(prices);
        Collections.reverse(prices);
        System.out.println(prices);
    }

     */
    //HomeWork
    /*

Ahmet B  8:26 PM
Where is my cyberAttack team. Website is open and waiting for you to make it down again:sunglasses:
Just a reminder for homework: 1) GO to the Edureka.co 2) Hover over the categories/browser
 3) hoverover cybersecurity 4)validate the 3 names of cybersecurity
     */
    @Test
    public void cybersec() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edureka.co/");
        driver.manage().window().maximize();

        WebElement browser = driver.findElement(By.xpath("//a[@class='dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat']//small[.='Browse']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(browser).perform();

        WebElement cyberOpt = driver.findElement(By.xpath("//a[@class='dropdown-toggle ga_top_category' and .='Cyber Security']"));
        actions.moveToElement(cyberOpt).perform();
        Thread.sleep(1000);
        WebElement cyberOpt1 = driver.findElement(By.xpath("//a[@class='ga_top_categories_course' and .='Cyber Security Course']"));
        actions.moveToElement(cyberOpt1).perform();

        WebElement cyberOpt2 = driver.findElement(By.xpath("//a[@class='ga_top_categories_course' and .='Cyber Security Masters Program']"));
        actions.moveToElement(cyberOpt2).perform();

        WebElement cyberOpt3 = driver.findElement(By.xpath("//a[@class='ga_top_categories_course' and .='CompTIA Security+ Certification Training - SY0-601 Exam']"));
        actions.moveToElement(cyberOpt3).perform();
        Thread.sleep(1000);

        List<WebElement> options = new ArrayList<>();
        options.add(cyberOpt1);
        options.add(cyberOpt2);
        options.add(cyberOpt3);
        for(int i =0; i<options.size();i++) {
            Thread.sleep(1000);
            boolean actual = options.get(i).isDisplayed();
            boolean expected = true;
            Assert.assertEquals(actual, expected);
        }
    }
}

