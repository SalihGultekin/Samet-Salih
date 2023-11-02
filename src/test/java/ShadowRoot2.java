import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRoot2 {
    static WebDriver driver=new ChromeDriver();

    public static void main(String[] args) {
        // jse yöntemi ile çözüm
        /*
        2 tane shadowRoot var
        +querySelector("body > shop-app")-->ilk shadowRoot locate yeri ve içine giriş olacak
        +querySelector("iron-pages > shop-home")-->ikinci shaowRoot locate yeri ve icine giriş yeri olacak
        +querySelector("div:nth-child(2) > shop-button > a")-->burasıda işlem yapacağımız asıl yerin loceti

        document.querySelector("body > shop-app").shadowRoot.querySelector("iron-pages > shop-home")
         .shadowRoot.querySelector("div:nth-child(2) > shop-button > a")

         */
        driver.get("https://shop.polymer-project.org/");
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\").click();");
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {
        //java yöntemi ile çözüm

        driver.get("https://shop.polymer-project.org/");
        WebElement shadowHost=driver.findElement(By.cssSelector("shop-app[page=\"home\"]"));
        SearchContext shadowRoot1=shadowHost.getShadowRoot(); //js path de 2 tane shadowRoot oldugu icin 2 yaptık
        SearchContext shadowRoot2=shadowHost.getShadowRoot();
        Thread.sleep(1000);
        WebElement shopNowButon=shadowRoot2.findElement(By.cssSelector("a[href=\"/list/mens_outerwear\"]"));
        shopNowButon.click();
        Thread.sleep(2000);
        driver.close();
    }

}
