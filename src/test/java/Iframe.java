import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Iframe {
   static WebDriver driver=new ChromeDriver();
    @Test
    public void Iframe(){
        driver.get("http://www.webdriveruniversity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String birinciWindowHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//div[@class='section-title']//h1[text()='IFRAME']")).click();

        Set<String> listHandle=driver.getWindowHandles();
        String ikinciWindowHandle="";
        for (String w:listHandle
             ) {
            if(w!=birinciWindowHandle){
                ikinciWindowHandle=w;
            }
        }
        driver.switchTo().window(ikinciWindowHandle);
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);
        WebElement text= driver.findElement(By.xpath("//p[text()='Who Are We?']"));
        Assert.assertTrue(text.isDisplayed());

        driver.switchTo().defaultContent();
        //driver.close();
        //driver.quit();
    }
    @Test
    public void ContactUs(){
        driver.get("http://www.webdriveruniversity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String birinciWindowHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//h1[text()='CONTACT US']")).click();
        Set<String> listHandle=driver.getWindowHandles();
        String ikinciWindowHandle="";
        for (String w:listHandle
        ) {
            if(w!=birinciWindowHandle){
                ikinciWindowHandle=w;
            }
        }
        driver.switchTo().window(ikinciWindowHandle);
        driver.findElement(By.name("first_name")).sendKeys("samet");
        driver.findElement(By.name("last_name")).sendKeys("ozcelik");
        driver.findElement(By.name("email")).sendKeys("smt@gmail.com");
        driver.findElement(By.name("message")).sendKeys("hello World");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        WebElement uyariMesaji= driver.findElement(By.xpath("//h1[text()='Thank You for your Message!']"));
        Assert.assertTrue(uyariMesaji.isDisplayed());
    }
    @Test
    public void loginPortal(){
        driver.get("http://www.webdriveruniversity.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       String birinciWindowHandle=driver.getWindowHandle();
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        Set<String> tumHandle=driver.getWindowHandles();
        String ikinciWindowHandle="";
        for (String w:tumHandle
             ) {
            if (w!=birinciWindowHandle){
                ikinciWindowHandle=w;
            }
        }
        driver.switchTo().window(ikinciWindowHandle);
        //samet

    }


}
