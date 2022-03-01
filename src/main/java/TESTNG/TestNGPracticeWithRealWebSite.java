package TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestNGPracticeWithRealWebSite {
    @Test
    public void validateWebSite(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        String actWebSite = driver.getCurrentUrl();
        String expectedWebSite ="https://demo.opencart.com/admin/";
        Assert.assertEquals(actWebSite,expectedWebSite);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
    @Test
    public void validateCatalogIsDisplayed(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
       boolean actualCatalog = catalogBar.isDisplayed();
       boolean expectedCatalog=true;
       Assert.assertEquals(actualCatalog,expectedCatalog,"Catalog is not here");
        catalogBar.click();
    }
    @Test
    public void validateProductsIsDisplayed(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement productBar = driver.findElement(By.xpath("//a[.='Products']"));
        boolean actualProductBar = productBar.isDisplayed();
        boolean expectedProdBar = true;
        Assert.assertEquals(actualProductBar,expectedProdBar);
        productBar.click();

    }
    @Test
    public void validationOfBoxes() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement catalogBar = driver.findElement(By.id("menu-catalog"));
        catalogBar.click();
        WebElement productBar = driver.findElement(By.xpath("//a[.='Products']"));
        Thread.sleep(1000);
        productBar.click();
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for(int i =1;i< boxes.size();i++){
            Thread.sleep(500);
            boxes.get(i).click();
            boolean actualBoxValidation =boxes.get(i).isDisplayed();
            boolean expBoxVal = true;
            Assert.assertEquals(actualBoxValidation,expBoxVal);
            boolean actBoxValSel = boxes.get(i).isSelected();
            boolean expBoxValSel = true;
            Assert.assertEquals(actBoxValSel,expBoxValSel);
        }
    }
}
