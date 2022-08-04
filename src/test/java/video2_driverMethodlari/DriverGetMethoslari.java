package video2_driverMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethoslari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // 1- driver.get("url") --> yazdığınız url e gider

        driver.get("https://www.amazon.com");

        // 2- driver.getTitle() --> içinde olduğu sayfanın başlığını döndürür
        System.out.println("sayfa title : " + driver.getTitle());

        // 3- driver.getCurrentUrl() --> içinde olduğu sayfanın URL 'ini döndürür
        System.out.println(driver.getCurrentUrl());  //https://www.amazon.com

        //4- driver.getPageSource(); --> içinde olduğu sayfanın kaynak kodlarını döndürür
        System.out.println("==============================");
        System.out.println(driver.getPageSource());  //arka planda çalışan sayfa kodlarını yazdırır
        System.out.println("===============================");


        //5- driver.getWindowHandle() ----> içinde olduğu sayfanın unique hash kodunu döndürür
        System.out.println(driver.getWindowHandle()); //CDwindow-F4A.....

        //6- driver.getWindowHandles() ----> driver çalışırken açılan tüm sayfaların unique hash kodunu döndürür




        }
}
