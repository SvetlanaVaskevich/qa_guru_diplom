package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

        String browser();
        String browserVersion();
        String browserSize();
        String userEmail();
        String userPassword();
        String remoteUrl();
        String videoStorage();
}
