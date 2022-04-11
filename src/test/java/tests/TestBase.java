package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import drivers.WebDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    static ProjectConfig config = ConfigFactory.create(ProjectConfig.class,System.getProperties());

    @BeforeAll
    public static void init(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebDriver driver = new WebDriver();
        driver.createDriver();
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs(System.getProperty("browser")+" "+System.getProperty("version"));
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
