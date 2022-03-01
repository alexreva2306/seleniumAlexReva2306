package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement abTesting = driver.findElement(By.linkText("A/B Testing"));
        System.out.println(abTesting);

        List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
        for(WebElement link: allLinks){
            System.out.println(link.getText());
        }

        //can you find only the links that its size less than equal 12 ant count
        //how many we have >
        System.out.println("=======");
       int  count =0;
        List<WebElement> shortLinks = driver.findElements(By.xpath("//li/a"));
        for(WebElement link: shortLinks){
            if(link.getText().length()<=12) {
                System.out.println(link.getText());
                count++;
            }
        }
        System.out.println(count);
    }
}
