package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobileConfig/emulator.properties")
public interface EmulatorConfig extends Config {

    @Key("platform.name")
    String platformName();
    @Key("platform.version")
    String platformVersion();
    @Key("device.name")
    String deviceName();
    @Key("app.package")
    String appPackage();
    @Key("app.activity")
    String appActivity();
}
