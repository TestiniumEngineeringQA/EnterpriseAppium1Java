package com.Testinium.Mobile;

import com.Testinium.Mobile.selector.Selector;
import com.Testinium.Mobile.selector.SelectorFactory;
import com.Testinium.Mobile.selector.SelectorType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class HookImpl {


    private static Logger logger = Logger.getLogger(HookImpl.class);
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    public static boolean localAndroid = false;
    protected static Selector selector;
    static DesiredCapabilities capabilities;
    static URL localUrl;
    static URL hubUrl;

    private String CAP_CLOUD_TESTID = "testinium:testID";
    private String PROP_TESTID = "testID";
    private String CAP_CLOUD_TAKE_SS = "testinium:takesScreenshot";
    private String CAP_CLOUD_RECORDVIDEO = "testinium:recordsVideo";
    private String CAP_CLOUD_KEY = "testinium:key";

    @BeforeAll
    public static void beforeScenario() {
        try {
            logger.info("************************************  BeforeScenario  ************************************");

            localUrl = new URL("http://127.0.0.1:4723/wd/hub");
            hubUrl = new URL("http://172.25.1.159:4444/wd/hub");
            //hubUrl = new URL("http://172.25.6.122:4444/wd/hub");

            if (StringUtils.isNotEmpty((System.getProperty("key")))) {
                if (localAndroid) {
                    logger.info("Local cihazda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver(localUrl, androidCapabilities(true));
                } else {
                    logger.info("Local cihazda IOS ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver<>(localUrl, iosCapabilities(true));
                }
            } else {

                if (System.getProperty("platform").equals("ANDROID")) {
                    logger.info("Testiniumda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver(hubUrl, androidCapabilities(false));
                    localAndroid = true;
                } else {
                    logger.info("Testiniumda IOS ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver(hubUrl, iosCapabilities(false));
                    localAndroid = true;
                }
            }
            selector = SelectorFactory
                    .createElementHelper(localAndroid ? SelectorType.ANDROID : SelectorType.IOS);
            appiumFluentWait = new FluentWait<AppiumDriver<MobileElement>>(appiumDriver);
            appiumFluentWait.withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(250))
                    .ignoring(NoSuchElementException.class);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @AfterAll
    public static void afterScenario() {
        if (appiumDriver != null)
            appiumDriver.quit();
    }

    public static DesiredCapabilities androidCapabilities(boolean isLocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.gratis.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.app.gratis.ui.splash.SplashActivity");

        if (isLocal) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        } else {
//            String testID = System.getProperty(PROP_TESTID);
//            capabilities.setCapability(CAP_CLOUD_KEY, "allianz:c97328a52d6bcf9aac41876f195ad427");
//            capabilities.setCapability(CAP_CLOUD_TESTID, testID);
//            capabilities.setCapability(CAP_CLOUD_TAKE_SS, "only_failure"); // "yes", "true", true, false, "no", "off", "only_failure", "ONLY_FAILURE"
//            capabilities.setCapability(CAP_CLOUD_RECORDVIDEO, true);
            capabilities.setCapability("key", System.getProperty("key"));
        }
        return capabilities;
    }


    public static DesiredCapabilities iosCapabilities(boolean islocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities
                .setCapability("bundleId", "com.pharos.Gratis");
        if (!islocal) {
            capabilities.setCapability("key", System.getProperty("key"));
            capabilities.setCapability("waitForAppScript", "$.delay(1000);");
            capabilities.setCapability("usePrebuiltWDA", true);
            capabilities.setCapability("useNewWDA", true);
        } else {
            capabilities
                    .setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
            capabilities
                    .setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

            capabilities.setCapability(MobileCapabilityType.UDID, "1e5cdbbadc4a7dc3e4389298330bad5c587904d5");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone SE");

            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.5");

            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
            capabilities.setCapability("sendKeyStrategy", "setValue");
        }

        return capabilities;

    }

}
