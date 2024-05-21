package exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam03 {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("127.0.0.1:5500/selenium01.html");

        // ID가 pop인 요소 클릭
        driver.findElement(By.id("pop")).click();

        // alert 확인 버튼 클릭
        driver.switchTo().alert().accept();

        // id가 text 인풋창에 ABC 입력
        driver.findElement(By.id("text")).sendKeys("ABC");

        Thread.sleep(5000);
        driver.quit();

    }

}
