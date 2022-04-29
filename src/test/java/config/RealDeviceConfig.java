package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobileConfig/realDevice.properties")
public interface RealDeviceConfig extends Config {

    String platformName();
    String platformVersion();
    String deviceName();
    String appPackage();
    String appActivity();
}
