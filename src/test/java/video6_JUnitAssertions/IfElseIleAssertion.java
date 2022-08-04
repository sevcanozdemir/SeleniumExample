package video6_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IfElseIleAssertion {

    WebDriver driver;
    @Before
            public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
            public void tearDown() {
        driver.close();

    }
    @Test
            public void test1(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualYaziStr=sonucYaziElementi.getText();

        String expectedBulunacakKelime="Kutella";

        if (actualYaziStr.contains(expectedBulunacakKelime)){
            System.out.println("Nutella testi PASSED");
        }else{
            System.out.println("Sonuc yazısı Nutella içermiyor"  + "\n Nutella testi FAILED");
        }

    }



}

