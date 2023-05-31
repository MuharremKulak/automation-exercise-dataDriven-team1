package com.academy.techcenture.driver;

import com.academy.techcenture.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static WebDriver driver;

    private Driver() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.getProperty("browser");
            boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    //extra configuration
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.setHeadless(headless);
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("autofill.profile_enabled", false);
                    prefs.put("profile.password_manager_enabled", false);
                    prefs.put("profile.default_content_setting_values.notifications", 2);
                    options.setExperimentalOption("prefs", prefs);
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

}
