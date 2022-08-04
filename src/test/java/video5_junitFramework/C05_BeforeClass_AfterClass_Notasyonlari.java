package video5_junitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_BeforeClass_AfterClass_Notasyonlari {

    /* Oluşturduğumuz tast class ının içindeki test methodları
    hep aynı web sitesi ile ilgili ise her seferinde yeniden driver olusturmaya
    ve her method için bu driver ı kapatmaya gerek yoktur
    class ın basında bir kere setup çalışıp en sonda kapasansa olur
    dersek BeforeClass ve AfterClass kullanırız
    static eklemek zorundayız
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

    @Test @Ignore // ıgnore ilr görmezden gelmesini sağlıyoruz.
    public void test02(){
        System.out.println(driver.getTitle());
    }


    @Test
    public void test03(){
        System.out.println(driver.getCurrentUrl());
    }
}
