package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:mobileConfig/emulator.properties")
public interface EmulatorConfig extends Config {

    String platformName();
    String platformVersion();
    String deviceName();
    String appPackage();
    String appActivity();
}
