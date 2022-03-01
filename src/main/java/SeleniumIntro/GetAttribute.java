package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.google.com/");
        driver1.manage().window().maximize();

        WebElement googleSearch = driver1.findElement(By.xpath("//input[@name='btnK']"));
        //System.out.println(text.getText()); --> not work in this case
        System.out.println(googleSearch.getAttribute("value"));
        System.out.println(googleSearch.getAttribute("aria-label"));
        if(googleSearch.getAttribute("value").equals("Google Search")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }
}
