import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class FindAll_FindBys {

    WebDriver driver=new ChromeDriver();
    FindAll_FindBys(){
        PageFactory.initElements(driver,this);
    }

    /**
     * 1. yol complex locate ile
     */
    @FindBy(xpath = "//div[@class=\"dropdown example\"]//input[@name=\"country\"]/following-sibling::input[@class=\"search\"]")
    public WebElement dropDown;  //Burda 3 locate ile uquine hale geldi

    @FindBy(xpath = "//div[@class=\"dropdown example\"]//i[@class=\"tr flag\"]")
    public WebElement turkey;




    @Test
    public void test1() throws InterruptedException {
        driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.scrollToElement(dropDown).perform();
        dropDown.click();
       actions.scrollToElement(turkey).perform();
        turkey.click();


        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
    @Test
    public void test02() throws InterruptedException {
        //select class ı kullanarak çözüm
        driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.scrollToElement(dropDown).perform();
        dropDown.click();
        Select option=new Select(dropDown);
        option.selectByVisibleText("Turkey");

    }

    /**
     * 2.yol @FindAll içine ayrı ayrı yazmak locateleri
     */
    @FindAll({
            @FindBy(how = How.XPATH,using = "//div[@class=\"dropdown example\"]"),
            @FindBy(how = How.XPATH,using = "//input[@name=\"country\"]"),
            @FindBy(how = How.XPATH,using = "//input[@class=\"search\"]")
    })public WebElement dropDown2;

     @FindAll({
     @FindBy(how = How.CSS,using = "input.search"),
     @FindBy(how = How.XPATH,using = "//div[text()='Select Country']"),
     @FindBy(how = How.CSS,using = "input[name='country']")
     })public WebElement dropDown3;

    @FindAll({
            @FindBy(how = How.XPATH,using = "//div[@class=\"dropdown example\"]"),
            @FindBy(how = How.XPATH,using = "//i[@class=\"tr flag\"]")

    })public WebElement turkey1;


    @Test
    public void test03() throws InterruptedException {
        driver.navigate().to("https://semantic-ui.com/modules/dropdown.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.scrollToElement(dropDown3).perform();
        dropDown3.click();
        actions.scrollToElement(turkey1).perform();
        turkey1.click();
        Thread.sleep(2000);
    }
}
