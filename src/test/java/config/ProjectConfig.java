package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

        @DefaultValue("chrome")
        String browser();
        @DefaultValue("100.0")
        String browserVersion();
        @DefaultValue("1920x1080")
        String browserSize();
        String browserMobileView();
        String user();
        String password();
        String userEmail();
        String userPassword();
        String videoStorage();
}
