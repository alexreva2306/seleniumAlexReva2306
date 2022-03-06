package com.test.etsy.pages;
import com.test.etsy.EtsyTestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

public class EtsyMainPage {
    public EtsyMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    WebElement search;
    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchItem(String searchItem) throws InterruptedException {
        search.sendKeys(searchItem,Keys.ENTER);
    }

    public boolean validateHeader() throws InterruptedException {
        for(WebElement header: allHeaders){
            String headr = header.getText().trim().toLowerCase();
            if(!(headr.contains("iphone")||headr.contains("13")||headr.contains("case"))){
                Thread.sleep(200);
                return false;
            }
        }
        return true;
    }
}
