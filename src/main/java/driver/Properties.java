package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Properties {

    private static WebDriver driver;

    public static WebDriver setDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        String browser = System.getProperty("browser");
        if (browser.equals("chrome") && os.contains("mac")) {
            driver = chromeDriver("chromedriver_mac");
        } else if (browser.equals("chrome") && os.contains("win")) {
            driver = chromeDriver("chromedriver.exe");
        } else if (browser.equals("firefox")) {
            driver = firefoxDriver();
        } else if (browser.equals("phantom")) {
            driver = phantomJSDriver();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver chromeDriver(String binary) {
        File exe = new File("src/main/resources/binaries/chrome/" + binary);
        System.setProperty("webdriver.chrome.driver", exe.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        configureCommonSettings(driver);
        return driver;
    }

    private static WebDriver firefoxDriver() {
        File exe = new File("src/main/resources/binaries/firefox/geckodriver");
        System.setProperty("webdriver.gecko.driver", exe.getAbsolutePath());
        WebDriver driver = new FirefoxDriver();
        configureCommonSettings(driver);
        return driver;
    }

    private static WebDriver phantomJSDriver() {
        File exe = new File("src/main/resources/binaries/phantomJS/phantomjs");
        System.setProperty("phantomjs.binary.path", exe.getAbsolutePath());
        WebDriver driver = new PhantomJSDriver();
        return driver;
    }

    private static void configureCommonSettings(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30000, MILLISECONDS);
        driver.manage().window().maximize();
    }
}
