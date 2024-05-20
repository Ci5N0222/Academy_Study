import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam01 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");

        WebElement inputId = driver.findElement(By.id("id"));
        WebElement inputPw = driver.findElement(By.id("pw"));

        String script = "arguments[0].value = arguments[1]";

        js.executeScript(script, inputId, "abcd");
        js.executeScript(script, inputPw, "abcd");

        List<WebElement> list =  driver.findElements(By.className("btn_login"));

    }
}
