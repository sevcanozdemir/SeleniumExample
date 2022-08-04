package video8_ActionsClassUygulama;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsClassUygulama {

    // 1- Browser ı çalıştırın
    // 2-"http://automationexercise.com" sayfasına gidin.
    // 3 -sign up butonuna tıkla
    // 4 - ad ve soyadı gir
    // 5- signup butonuna tıkla
    // 6 - Ekranda tüm detayları doldur
    // 7 - Ekranda accound created yazısının çıktığını tested

    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationexercise.com");

        WebElement signUpElementi=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        //signUpElementi.click();
        Actions actions =new Actions(driver);
        actions.click(signUpElementi).perform();

        WebElement nameKutusu=driver.findElement(By.xpath("//input[@name='name']"));
        actions.click(nameKutusu)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("sevcan12@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement titleRadioButton=driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadioButton)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1234")
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("February")
                .sendKeys(Keys.TAB)
                .sendKeys("1997   ")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulut")
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("ulu can no 25")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Teksas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("05100")
                .sendKeys(Keys.TAB)
                .sendKeys("5555555555")
                .sendKeys(Keys.TAB)
                .perform();

        String expectedYazi="ACCOUNT CREATED!";
        String actualYazi=driver.findElement(By.xpath("")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        driver.close();



    }
}
