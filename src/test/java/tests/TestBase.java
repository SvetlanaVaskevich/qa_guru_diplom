package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.RealDeviceDriver;
import drivers.UWebDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.*;

public class TestBase {

    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class,System.getProperties());
    public static String testType = System.getProperty("testType");

    @BeforeAll
    public static void setup(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        switch (testType) {
            case "ui":
                Configuration.browser = UWebDriver.class.getName();
                break;
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
            case "realDevice":
                Configuration.browser = RealDeviceDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        screenshotAs(System.getProperty("browser")+" "+System.getProperty("version"));
        pageSource();

        switch (testType) {
            case "browserstack":
                videoBrowsetstack(sessionId);
                break;
            case "ui":
                browserConsoleLogs();
                videoSelenoid(sessionId);
                break;
        }

        closeWebDriver();
    }
}
