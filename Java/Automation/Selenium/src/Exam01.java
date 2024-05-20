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

        /**
         *  NAVER로 자동화 기능 연습하기
         *  Library: Selenium
         */

//		driver.get("https://www.naver.com");
//
//		List<WebElement> list =  driver.findElements(By.className("MyView-module__link_login___HpHMW"));
//
//		System.out.println(list.size());
//
//		WebElement loginBtn = list.get(0);
//
//		loginBtn.click();

        // 동선을 최소화하는 것이 중요!!
        driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");

        WebElement inputId = driver.findElement(By.id("id"));
        WebElement inputPw = driver.findElement(By.id("pw"));
        
        // send 하는 순간 입력 속도가 너무 빨라 봇으로 감지 위험 있음
//        inputId.sendKeys("abcd");
//        inputPw.sendKeys("abcd");
        
        
        String script = "arguments[0].value = arguments[1]";
        
        // send를 사용하지 않고 자바스크립트를 이용하여 id, pw 작성
        js.executeScript(script, inputId, Statics.myId);
        js.executeScript(script, inputPw, Statics.myPw);

        List<WebElement> list =  driver.findElements(By.className("btn_login"));

        WebElement loginBtn = list.get(0);

        loginBtn.click();
    }
}
