package drivers;

import com.codeborne.selenide.Configuration;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UWebDriver {
    static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class,System.getProperties());
    static ChromeOptions chromeOptions = new ChromeOptions();

    UWebDriver() {
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=ru-ru");
    }

    public static void createDriver(){
        Configuration.baseUrl = "https://www.chitai-gorod.ru/";
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        Configuration.remote = config.remoteUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}