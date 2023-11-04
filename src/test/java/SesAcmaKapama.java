import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SesAcmaKapama {

    static WebDriver driver=new ChromeDriver();
    Actions actions=new Actions(driver);
    @BeforeMethod
    public void setUp(){
        driver.get("https://www.vivino.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    SesAcmaKapama(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "span[title='Wines']")public WebElement Wines;
    @FindBy(css="div[class=\"rc-slider-handle rc-slider-handle-1\"][aria-valuemin=\"0\"]")public WebElement top1;
    @FindBy(css="div[class=\"rc-slider-handle rc-slider-handle-2\"][aria-valuemin=\"0\"]")public WebElement top2;

    @Test
    public void test() throws InterruptedException {
        actions.moveToElement(Wines).perform();

        //ses açma gibi düşün
        actions.clickAndHold(top1).moveByOffset(-20,0).release().perform(); //sola - ile git x ekseni
        actions.clickAndHold(top2).moveByOffset(30,0).release().perform();  //sag direk yaz  x ekseni



    }


}
