package Homework.HomeWork5;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HW5 {
    /*
Steps
Navigate to "http://uitestpractice.com/Students/Select#" Validate India is selected by default on drop down box
Validate the size of the Drop down box is 4 Validate the values for Drop down box are :
India
United States of America
China England
Select the China with index number Select the England with value
Select the United States with visible text
SELENIUM TECTHTORIAL
*/
    @Test
    public void first() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();
        WebElement india = driver.findElement(By.xpath("//select[@id='countriesSingle']//option[.='India']"));
       String actIsIndiaDisp= india.getText().trim();
        String expIsIndiaDisp = "India";
        Assert.assertEquals(actIsIndiaDisp,expIsIndiaDisp);

        List<WebElement> countries = driver.findElements(By.xpath("//select[@id='countriesSingle']//option"));
        List<String> actCountriesAgain = new LinkedList<>();
        List<String> expCountriesAgain = new LinkedList<>();
        expCountriesAgain.add("India"); expCountriesAgain.add("United states of America");
        expCountriesAgain.add("China");   expCountriesAgain.add("England");
        int actCount = 0,expCount =4;
        for(int i=0;i<countries.size();i++){
            actCountriesAgain.add(countries.get(i).getText());
            actCount++;
        }
        Assert.assertEquals(actCount,expCount);
        Assert.assertEquals(actCountriesAgain,expCountriesAgain);
        WebElement selCountry = driver.findElement(By.xpath("//select[@id='countriesSingle']"));
        Thread.sleep(200);
        BrowserUtils.selectBy(selCountry,"2","index");Thread.sleep(100);
        BrowserUtils.selectBy(selCountry,"england","value");Thread.sleep(100);
        BrowserUtils.selectBy(selCountry,"United states of America","text");
    }
    /*
 Test Case 2
Steps
Navigate to Navigate to "http://uitestpractice.com/Students/Select#" Validate the values for Multiple Select are :
India
United States of America
China England
Select China and England Validate "China England" is displayed
Deselect all the countries Select All the countries
Validate "India United states of America China
England" is displayed
Deselect the China with index number Deselect the England with value
SELENIUM TECTHTORIAL
*/
    @Test
    public void second() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestpractice.com/Students/Select#");
        driver.manage().window().maximize();

        List<WebElement> countries = driver.findElements(By.xpath("//select[@id='countriesMultiple']//option"));
        List<String> actCountriesAgain = new LinkedList<>();
        List<String> expCountriesAgain = new LinkedList<>();
        expCountriesAgain.add("India"); expCountriesAgain.add("United states of America");
        expCountriesAgain.add("China");   expCountriesAgain.add("England");
        for(int i=0;i<countries.size();i++){
            actCountriesAgain.add(countries.get(i).getText());
        }
        Assert.assertEquals(actCountriesAgain,expCountriesAgain);Thread.sleep(200);
        WebElement multiBox = driver.findElement(By.xpath("//select[@id='countriesMultiple']"));
        BrowserUtils.selectBy(multiBox,"china","value");
        BrowserUtils.selectBy(multiBox,"England","text");
        WebElement result = driver.findElement(By.xpath("//div[@id='result']"));Thread.sleep(200);
        String actCounties = BrowserUtils.getTextMethod(result);
        String expCounties ="China England";
        Assert.assertEquals(actCounties,expCounties);Thread.sleep(200);
        boolean actRes = result.isDisplayed();
        boolean expRes = true;
        Assert.assertEquals(actRes,expRes);Thread.sleep(200);
        Select select = new Select(multiBox);
        select.deselectAll();Thread.sleep(200);
        BrowserUtils.selectBy(multiBox,"0","index");BrowserUtils.selectBy(multiBox,"1","index");
        BrowserUtils.selectBy(multiBox,"2","index");BrowserUtils.selectBy(multiBox,"3","index");Thread.sleep(200);
        WebElement result1 = driver.findElement(By.xpath("//div[@id='result']"));Thread.sleep(200);
        String actCounties1 = BrowserUtils.getTextMethod(result1);
        String expCounties1 ="India United states of America China England";
        Assert.assertEquals(actCounties1,expCounties1);Thread.sleep(200);
        boolean actRes1 = result1.isDisplayed();
        boolean expRes1 = true;
        Assert.assertEquals(actRes1,expRes1);Thread.sleep(200);
        select.deselectByIndex(2);select.deselectByValue("england");

    }
    /*
 Test Case 3
Part 1
Steps
Navigate to "https://www.cars.com/" Select "Certified Cars" from drop down Select "Toyota" from All Makes
Select "Corolla" from drop down Select max price is "$30000"
Select 40 miles from drop down box
Insert 60018 as zip code
Click search button
Validate title has Certified Used
Validate "Certified Used Toyota Corolla for Sale" is displayed
SELENIUM TECTHTORIAL
 Test Case 3
Part 2
Steps
Validate 40 miles selected in dropdown once you click search button
Validate Certified Pre-Owned selected in radio button Validate Toyota is selected in checkbox
Validate Corolla is selected in drop down
SELENIUM TECTHTORIAL
*/
    @Test
    public void third() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();

        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed,"cpo","value");
        WebElement makes = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makes,"toyota","value");
        WebElement models = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models,"toyota-corolla","value");
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price,"30000","value");
        WebElement mileage = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(mileage,"40","value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.sendKeys("60018");Thread.sleep(200);
        WebElement searchBut = driver.findElement(By.xpath("//button[@data-searchtype ='make']"));
        searchBut.click();Thread.sleep(400);

        boolean actCertUsed = BrowserUtils.getTitleWithJavaScript(driver).contains("Certified used");
        boolean expCertUsed = true;
        Assert.assertEquals(actCertUsed,expCertUsed);Thread.sleep(200);
        WebElement result2 = driver.findElement(By.xpath("//h1[.='Certified used Toyota Corolla for sale']"));
        boolean actRes1 = result2.isDisplayed();
        boolean expRes1 = true;
        Assert.assertEquals(actRes1,expRes1);
      //  2second part
        WebElement result3 = driver.findElement(By.xpath("//select[@id='location-distance']//option[@value='40']"));
        boolean actRes3 = result3.isSelected();
        boolean expRes3 = true;
        Assert.assertEquals(actRes3,expRes3);
        WebElement result4 = driver.findElement(By.xpath("//select[@id='stock-type-select']//option[@value='cpo']"));
        boolean actRes4 = result4.isSelected();
        boolean expRes4 = true;
        Assert.assertEquals(actRes4,expRes4);
        WebElement result5 = driver.findElement(By.xpath("//select[@id='make_select']//option[@value='toyota']"));
        boolean actRes5 = result5.isSelected();
        boolean expRes5 = true;
        Assert.assertEquals(actRes5,expRes5);
        WebElement result6 = driver.findElement(By.xpath("//select[@id='make_select']//option[@value='toyota']"));
        boolean actRes6 = result6.isSelected();
        boolean expRes6 = true;
        Assert.assertEquals(actRes6,expRes6);
    }
    /*
 Test Case 4
Part 1
Steps-Multiple CheckBox
Navigate to "https://www.cars.com/" Select "Certified Cars" from drop down Select "Lexus" from All Makes
Select "ES 350" from drop down Select max price is "$50000"
Select 50 miles from drop down box
Insert 60016 as zip code
Click search button
Get count of all the cars which is displayed on first page
Validate count of the cars is not more than 20
SELENIUM TECTHTORIAL

 Test Case 4
Part 2
Steps
Get all car names in first page
Validate All car names has "Lexus ES 350"
Get the Mile distance from zip code for every car Validate mile distance is no more than 50mil in first page Select Sort By --> Price:Highest in drop down
Validate highest price is not more than $50000
     */
    @Test
    public void fourth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cars.com/");
        driver.manage().window().maximize();
        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed,"new_cpo","value");
        WebElement makes = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(makes,"lexus","value");
        WebElement models = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(models,"lexus-es_350","value");
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        BrowserUtils.selectBy(price,"50000","value");
        WebElement mileage = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(mileage,"50","value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.sendKeys("60016");Thread.sleep(200);
        WebElement searchBut = driver.findElement(By.xpath("//button[@data-searchtype ='make']"));
        searchBut.click();Thread.sleep(400);
        List<WebElement> allOptions = driver.findElements(By.xpath("//h2[@class='title']"));
        int count =0; boolean actRes = false; boolean expRes = true;int constanta = 20;
        for(int i=0;i< allOptions.size();i++){
            count++;
        }Thread.sleep(200);
        if(count<constanta){
            actRes = true;
        }Thread.sleep(200);
        Assert.assertEquals(actRes,expRes);Thread.sleep(200);
        //2second part
        List<String> optNames = new LinkedList<>();
        for(int i =0;i< allOptions.size();i++) {
            Thread.sleep(200);
            optNames.add(BrowserUtils.getTextMethod(allOptions.get(i)));
            if (optNames.get(i).contains("Lexus ES 350")){
                actRes = true;
            }
        }
        Assert.assertEquals(actRes,expRes);Thread.sleep(200);
        List <WebElement> milesD = driver.findElements(By.xpath("//div[@class='miles-from ']"));
        List <String> milesDistance = new LinkedList<>();constanta = 50;
        for(int i=0;i< milesD.size();i++){Thread.sleep(200);
            if(milesD.get(i).isDisplayed()){
                milesDistance.add(milesD.get(i).getText().substring(0,2).trim());
            }
        }
        for(int i=0;i< milesDistance.size();i++){Thread.sleep(200);
        if(Integer.parseInt(milesDistance.get(i))<constanta){
            actRes=true;
        }}
        System.out.println(milesDistance);
        Assert.assertEquals(actRes,expRes);Thread.sleep(200);
        WebElement sortBy = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        BrowserUtils.selectBy(sortBy,"list_price_desc","value");Thread.sleep(200);
       List <WebElement> priceValid = driver.findElements(By.xpath("//span[.='$49,070']"));
       double biggestPrice = Double.parseDouble(priceValid.get(0).getText().substring(1).replace(",",".").trim());
        System.out.println(biggestPrice);
     double constanta1=50000;Thread.sleep(200);
        if(biggestPrice<constanta1){
            actRes=true;
        }
        Assert.assertEquals(actRes,expRes);

    }

}
