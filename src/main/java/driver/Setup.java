package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Setup {

    private static WebDriver driver;

    public static WebDriver setDriver() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {
            driver = chromeDriver("chromedriver_mac");
        } else if (os.contains("win")) {
            driver =  chromeDriver("chromedriver.exe");
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver tearDownDriver() {
        driver.close();
        return driver = null;
    }

    private static WebDriver chromeDriver(String binary) {
        File exe = new File("src/main/resources/binaries/" + binary);
        System.setProperty("webdriver.chrome.driver", exe.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        configureCommonSettings(driver);
        return driver;
    }

    private static void configureCommonSettings(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30000, MILLISECONDS);
        driver.manage().window().maximize();
    }
}
