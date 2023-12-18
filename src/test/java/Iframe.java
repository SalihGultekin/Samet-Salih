import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframe {
    static WebDriver driver=new ChromeDriver();
    @Test
    public void Iframe(){
        driver.get("http://www.webdriveruniversity.com");
// deneme
    }
}
