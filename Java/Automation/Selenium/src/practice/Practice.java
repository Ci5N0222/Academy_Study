package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Practice {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 뮤지컬 티켓 예매 자동화
        driver.get("https://tickets.interpark.com/goods/24005971");

        // 예매하기 버튼 클릭
        driver.findElements(By.cssSelector(".sideBtn.is-primary")).get(0).click();

        // 로그인 정보 입력
        WebElement id = driver.findElement(By.id("userId"));
        WebElement pw = driver.findElement(By.id("userPw"));

        String script = "arguments[0].value = arguments[1]";
        js.executeScript(script, id, "ABC");
        js.executeScript(script, pw, "ABC");

        // 로그인 버튼 클릭
        driver.findElement(By.id("btn_login")).click();

        // 예매하기 버튼
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".sideBtn.is-primary")));

        // 팝업 창 오픈
        String defaultContent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for(String window : windows) {
            if(!window.equals(defaultContent)){
                driver.switchTo().window(window);
            }
        }

        // 체크박스 선택
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("privateinfo")));
        js.executeScript("arguments[0].click();", driver.findElement(By.id("privateinfo")));

        // 휴대폰 인증 버튼
        driver.findElements(By.cssSelector(".btnBox.phone")).get(0).click();

        Thread.sleep(10000);
        driver.quit();

    }

}
