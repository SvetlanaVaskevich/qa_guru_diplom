package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobileConfig/realDevice.properties")
public interface RealDeviceConfig extends Config {

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
