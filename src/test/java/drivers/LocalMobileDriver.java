package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.remote.CapabilityType.APPLICATION_NAME;

@ParametersAreNonnullByDefault
public class LocalMobileDriver implements WebDriverProvider {

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver createDriver(Capabilities capabilities) {

        EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class);

        File app = downloadApk();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName(config.platformName());
        options.setDeviceName(config.deviceName());
        options.setPlatformVersion(config.platformVersion());
        options.setCapability(APPLICATION_NAME, "Appium");
        options.setApp(app.getAbsolutePath());
        options.setLocale("ru");
        options.setLanguage("ru");
        options.setAppPackage(config.appPackage());
        options.setAppActivity(config.appActivity());

        try {
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File downloadApk() {
        File apk = new File("src/test/resources/apk/ru.chitaigorod.mobile_1.0.40_3206.apk");
        return apk;
    }
}
