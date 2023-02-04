package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){

    }



    static WebDriver driver;

    public static WebDriver getDriver(String browser){

        //==> Testlerimizi xml file'dan farkli browserlar ile calistirabilmek icin
        //==> getDriver() methoduna parametre atmamiz gerekir
        //==> Eger browser'a bir deger atanmamissa properties'deki browser calisir .
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;

        if (driver == null){

            switch (browser){
                //CrossBrowser için bizim gönderdiğimiz browser üzerinden çalısması için
                //buraya parametre olarak girdiğimiz değeri yazdık
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari"    :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox"  :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge"     :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){   // ==>  driver'a deger atanmıssa kapat
            driver.close();
            driver = null;  //=>Kapandıktan sonraki acmaları garanti altına almak icin  driver'i tekrar null yaptık
        }

    }

    public static void quitDriver(){
        driver.quit();
    }
}
