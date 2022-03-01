package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeSeleniumBasics {
    public static void main(String[] args) {
        //Task:I want you go to the 3 websites. Get the title,currentURL
// You decide and going back
//forward with them lastly refresh and quit.

            System.setProperty("webdriver.chrome.driver","chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.navigate().to("https://www.youtube.com/");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
            driver.navigate().back();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            driver.navigate().forward();
            driver.close();
    }
}
