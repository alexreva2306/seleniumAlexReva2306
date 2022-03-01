package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Locale;

public class FindElementsPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/?guccounter=1&guce_referrer=aHR0cHM6Ly93d3cuYmluZy5jb20v&guce_referrer_sig=AQAAAGHDBYAIC5SAaQX8p6wKGjQaFYjvx-QhIA3P_GUla4htMTkGHYsJFPZfSPLea1_gu_CrtM10LIp45R0XwNqIxzHqluILnRR8riWQxWK-Ewuy1Z5lBbHr81PskvfZITCM5y6b8qKMhKGPaONZDutAXgvgYMQuOFRPAy57j233oyLv");
        driver.manage().window().maximize();

        WebElement news = driver.findElement(By.xpath("//a[@id='root_2']"));
        news.click();

        List<WebElement> headers = driver.findElements(By.tagName("h3"));
        int counter=0;
        for(int i =0;i< headers.size();i++){
           // System.out.println( headers.get(i).getText());
            if(headers.get(i).getText().toUpperCase(Locale.ROOT).contains("COVID")){
                System.out.println( headers.get(i).getText());
                counter++;
            }
        }
        System.out.println(counter);
//        for(WebElement box:headers){
//            if(box.getAttribute(".").contains("Covid")){
//                System.out.println(box.getText());
//            }
//        }
    }
}
