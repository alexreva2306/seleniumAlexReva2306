package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement horSlid = driver.findElement(By.xpath("//h3"));
        System.out.println(horSlid.getText());

        WebElement text = driver.findElement(By.xpath("//h4[@class='subheader']"));
        System.out.println(text.getText());

        //CONTAINS: it works with text
        // tagname[contains(text(),'HorizontalLine')];//60%

        WebElement containsMethod = driver.findElement(By.xpath("//h3[contains(text(),'Horizontal Slider')]"));
        System.out.println(containsMethod.getText());

        //Text: it works with text as well. simplier than contains method.it looks for ewxact text
        WebElement textMethod = driver.findElement(By.xpath("//h3[.='Horizontal Slider']"));
        System.out.println(textMethod.getText());
        //this short way but if it doesn't work -->use contains method(it is more specify that text)


    }
}
