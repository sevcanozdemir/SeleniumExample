package video2_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        //1- driver.manage().window methodlari
        // 1A - driver.manage().window.getSize() ---> içinde olduğu sayfanın pixel olarak ölçülerini döndürür
        System.out.println(driver.manage().window().getSize());  // (1050,832 ) pixel
        System.out.println(driver.manage().window().getSize().height); // 832

        // 1-B driver.manage().window().getPosition() ----> içinde olduğu sayfanın pixel oalrak konumunu döndürür
        System.out.println(driver.manage().window().getPosition());  // (10,10 )

        // 1-C driver.manage().window().setPosition(new Point(15,15));
        //içinde olduğu sayfanın sol alt köşesini bizim yazacağımız pixel noktasına taşır.
        driver.manage().window().setPosition(new Point(15,15));

        //1-D driver.manage().window().setSize(new Dimension (900, 600));
        //içinde olduğu sayfanın sol alt köşesi sabit olarak bizim yazacağımız ölçülere getirir
        driver.manage().window().setSize(new Dimension(900,600));

        //konumu ve boyutu yeniledikten sonra tekrar yazdırırsak
        System.out.println("yeni pencere olculeri :" + driver.manage().window().getSize());
        System.out.println("yeni pencere konumu :" + driver.manage().window().getPosition());


        //1-E driver.manage().window().maximize(); ---> içinde olduğu sayfayı maksimize yapar.
        //1-F driver.manage().window().fullscreen(); ---> içinde olduğu sayfayı fullscreen yapar.

        //farkları görmek için bu methodları kullanıp başlangıç noktalarını ve boyutlarını yazdıralım
        driver.manage().window().maximize();
        System.out.println("maximize konum: "  + driver.manage().window().getPosition()); // (-8 ,-8)
        System.out.println("maximize boyut : " + driver.manage().window().getSize()); // ( 1616 ,868)

        driver.manage().window().fullscreen();
        System.out.println("fullscreen konum : " + driver.manage().window().getPosition());
        System.out.println(("fullscreen boyut : " + driver.manage().window().getSize()));

        // 1-G driver.manage().window().minimize(); ---> sayfayı simge durumunda küçültür.
        driver.manage().window().minimize();

        //2 - driver.manage().timeouts() methoslari

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*

        implicitlyWait: driver a sayfanın yüklenmesi ve kullanacağımız webelementlerin bulunması için
                        bekleyeceği maximum süreyi belirtir.
                        driver bu sure icerisinde sayfa yuklenir/web element bulunursa
                        beklemeden çalışmaya devam eder.
                        bu süre bittiği halde sayfa yüklenememiş/ webElement bulunamamışsa
                        exception vererek çalışmayı durdurur.

        Duration.ofSeconds(15): Duration class i Selenium- 4 ile gelen zaman classıdır.
                                Yani driver a ne kadar bekleyeceğini söyler.
                                Duration.ofSeconds(15) yerine milis, minutes, hours da kullanılabilir.


             NOT: Driver ın istediğimiz işlemleri yaparken sorunla karşılaşmaması için
                  driver.manage() methoslarından
                  maximize() ve implicitlyWait() methodalrının her testte kullanılması faydalı olacaktır.
         */


    }
}
