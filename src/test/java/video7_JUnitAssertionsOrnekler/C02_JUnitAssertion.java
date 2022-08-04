package video7_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.tethering.model.Accepted;

import java.time.Duration;

public class C02_JUnitAssertion {

    //1- Browser ı çalıştırın
    // 2-"http://automationexercise.com" sayfasına gidin.
    // 3- home page in görünür olduğunu başarılı bir şekilde test edin
    // 4 - Product butonuna tıklayın
    // 5- All Product sayfasının açıldığını test edin
    // 6 - Araığınız ürün ismini search kısmına yazın.
    // 7 -seach product ın görünür olduğunu test edin

    @Test
    public void test01(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("http://automationexercise.com");

        WebElement logoElementi=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        String expectedURL="https://automationexercise.com/products";
        String actualURL= driver.getCurrentUrl();

        Assert.assertEquals(expectedURL,actualURL);

        WebElement searchProduct=driver.findElement(By.xpath("//input[@id='search_product']"));
        searchProduct.sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        String expectedWord="Searched Products";
        WebElement searchedProductYazisi=driver.findElement(By.xpath("//h2[text()='Searched Products']"));

       Assert.assertTrue(searchedProductYazisi.isDisplayed());

       driver.close();




    }
}
