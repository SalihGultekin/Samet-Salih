import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframe {
    static WebDriver driver=new ChromeDriver();
    @Test
    public void Iframe(){
        driver.get("http://www.webdriveruniversity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
