package exam;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Exam02 {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 동선을 최소화 한다! 중요!
        driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/");

        WebElement inputId = driver.findElement(By.id("id"));
        WebElement inputPw = driver.findElement(By.id("pw"));

        // sendKeys는 매크로 의심 위험이 크다!
//        inputId.sendKeys("ABC");
//        inputPw.sendKeys("ABC");

        // sendKeys 대신 JavaScript 사용
        String script = "arguments[0].value = arguments[1]";
        // 로그인 ID, PW 입력
        js.executeScript(script, inputId, "id");
        js.executeScript(script, inputPw, "pw");

        // 로그인 버튼 클릭
        List<WebElement> list = driver.findElements(By.className("btn_login"));
        list.get(0).click();

        // 로그인이 되면 페이지 이동
        driver.get("https://mail.naver.com/v2/folders/0/all");

        // 클래스 이름이 button_write_to_me인 것이 로드될 때 까지 대기
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("button_write_to_me")));

        // 내게 쓰기 버튼 클릭
        List<WebElement> writeToMe = driver.findElements(By.className("button_write_to_me"));
        writeToMe.get(0).click();

        WebElement title = driver.findElement(By.id("subject_title"));
        title.sendKeys("제목 입력");

        // iframe을 찾으려 했으나 여러개가 존재하여 필요한 iframe을 담고 있는 div를 통해 서치
        WebElement editorBody = driver.findElements(By.className("editor_body")).get(0);

        // 먼저 찾은 div 안에 있는 iframe 태그 서치
        WebElement iframe = editorBody.findElements(By.tagName("iframe")).get(0);

        // 해당 화면으로 포커스 이동
        driver.switchTo().frame(iframe);

        // 내용 작성
        WebElement content = driver.findElements(By.className("workeditor_content")).get(0);
        content.sendKeys("내용 입력");

        // 다시 기존 콘텐츠로 보커스 이동
        driver.switchTo().defaultContent();

        // 저장 버튼 클릭
        driver.findElements(By.className("button_write_task")).get(0).click();

        // 종료
        Thread.sleep(5000);
        driver.quit();

    }
}
