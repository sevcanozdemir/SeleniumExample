package video7_JUnitAssertionsOrnekler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnitAssertion {

    //1- Browser ı çalıştırın
    // 2-"http://automationexercise.com" sayfasına gidin.
    // 3- home page in görünür olduğunu başarılı bir şekilde test edin
    // 4- sign up butonuna tıkla
    // 5 - 'Login to your account' uyazısının görünür olduğunu test et.
    // 6-Doğru kullanıcı adı ve şifre yazın login butonuna tıklayın.
    // 7- 'logged in as username' in görünür olduğunu test et
    // 8- logout butonuna tıkla
    // 9- Login sayfasına geldiğini test et
    // 10- driver ı kapat


    @Test
            public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationexercise.com");

        WebElement logoElementi=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        WebElement signUpLinki=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpLinki.click();

        WebElement loginYaziElementi=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginYaziElementi.isDisplayed());

        WebElement emailAdresKutusu=driver.findElement(By.xpath("//input[@name='email']"));
        emailAdresKutusu.sendKeys("ahmet@nehaber.com");

        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@name='password']"));
        passwordKutusu.sendKeys("12345");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        WebElement loggedInYazisi=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        //System.out.println(loggedInYazisi.getText());
        Assert.assertTrue(loggedInYazisi.isDisplayed());

        driver.findElement(By.xpath("//a[text()=' Logout']")).click();

        String expectedURL="https://automationexercise.com/login";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);

        driver.close();






    }



}
