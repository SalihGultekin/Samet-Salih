import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRoot1 {
    static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) {
        // örnek 1 jse yöntemi ile çözüm
        //document.querySelector("#shadow_host").shadowRoot.querySelector("input[type=text]") js path i
        driver.get("http://watir.com/examples/shadow_dom.html");
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("return document.querySelector('#shadow_host').shadowRoot.querySelector('input[type=text]').value = 'Sametttt';");

        //jse.executeScript("document.querySelector('#shadow_host').shadowRoot.querySelector('input[type=text]').value = 'Sametttt';");
        //return yazmadan da oldu o yüzden yoruma aldım

        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        // örnek 1 java yöntemi ile çözüm
        driver.get("http://watir.com/examples/shadow_dom.html");
        driver.manage().window().maximize();

        WebElement shadowHost=driver.findElement(By.cssSelector("#shadow_host"));
        SearchContext shadowRoom1=shadowHost.getShadowRoot();
        WebElement textBox=shadowRoom1.findElement(By.cssSelector("input[type='text']"));
        textBox.sendKeys("samet");

        Thread.sleep(2000);
        driver.close();
    }

}
