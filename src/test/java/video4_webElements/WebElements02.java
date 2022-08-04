package video4_webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02 {

    //https:www.facebook.com adresine gidin.
    //cookies çıkarsa kabul et butonuna basin
    //e-posta kutusuna rastgele bir mail girin.
    //sifre kismina rastgele bir sifre girin
    //giris yap butonuna basin
    //uyarı olarak "The email or mobile number you entered isn't connected to an account. Find your
    //mesajın çıktığını test edin
    //sayfayı kapatın

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https:www.facebook.com");
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
        WebElement emailBox= driver.findElement(By.xpath("//input[@id='email']"));
        emailBox.sendKeys("sevcandgdggh");
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='pass']"));
        passwordBox.sendKeys("fdfggdd");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        WebElement resultWord=driver.findElement(By.xpath("//div[@class='_9ay7'"));
        String expectedResult="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil. Hesabını bul ve giriş yap.";
        String actualResult=resultWord.getText();

        if(expectedResult.equals(actualResult)){
            System.out.println("Girilemedi testi passed");
        } else {
            System.out.println("Girilemedi testi failed");
        }
        driver.close();


    }
}
