package exam;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Exam04 {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.findElement(By.id("pop")).click();

        // 팝업창의 개수 확인
        System.out.println(driver.getWindowHandles().size());
        String defaultContent = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        for(String window : windows) {
            if(!window.equals(defaultContent)){
                // window가 맨 처임 디폴트 윈도우가 아닐 경우 해당 윈도우로 포커스 이동
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.id("txt")).sendKeys("ABC");

        Thread.sleep(5000);
        driver.quit();

    }
}
