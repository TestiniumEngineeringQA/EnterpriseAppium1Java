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

    // ---- Capability isimleri ----
    private static final String CAP_CLOUD_TESTID      = "testinium:testID";
    private static final String CAP_CLOUD_TAKE_SS     = "testinium:takesScreenshot";
    private static final String CAP_CLOUD_RECORDVIDEO = "testinium:recordsVideo";
    private static final String CAP_CLOUD_KEY         = "testinium:key";

    // ---- System property isimleri ----
    private static final String PROP_TESTID   = "testID";
    private static final String PROP_PLATFORM = "platform";
    private static final String PROP_KEY      = "key";
    private static final String PROP_HUB_URL  = "hubURL";

    private static final String LOCAL_HUB_URL  = "http://127.0.0.1:4723/wd/hub";
    private static final String DEFAULT_HUB_URL = "http://172.25.1.159:4444/wd/hub";

    @BeforeAll
    public static void beforeScenario() {
        try {
            logger.info("************************************  BeforeScenario  ************************************");

            String platform = System.getProperty(PROP_PLATFORM);
            String hubFromProp = System.getProperty(PROP_HUB_URL);
            String key = System.getProperty(PROP_KEY);

            // Testinium ortamı mı? → platform + hubURL property'leri set ise evet.
            // Bu property'leri Testinium executor otomatik gönderir.
            boolean runningOnTestinium = StringUtils.isNotEmpty(platform)
                    && StringUtils.isNotEmpty(hubFromProp);

            URL targetUrl = runningOnTestinium
                    ? new URL(hubFromProp)
                    : new URL(LOCAL_HUB_URL);

            logger.info("Çalışma ortamı: " + (runningOnTestinium ? "TESTINIUM" : "LOCAL"));
            logger.info("Hedef hub URL: " + targetUrl);
            logger.info("Platform     : " + (platform != null ? platform : "LOCAL"));
            logger.info("Key set mi?  : " + StringUtils.isNotEmpty(key));

            if (runningOnTestinium) {
                // ----- TESTINIUM -----
                if ("ANDROID".equalsIgnoreCase(platform)) {
                    logger.info("Testiniumda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver<>(targetUrl, androidCapabilities(false));
                } else {
                    logger.info("Testiniumda IOS ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver<>(targetUrl, iosCapabilities(false));
                }
                localAndroid = true;
            } else {
                // ----- LOCAL -----
                if (localAndroid) {
                    logger.info("Local cihazda Android ortamında test ayağa kalkacak");
                    appiumDriver = new AndroidDriver<>(targetUrl, androidCapabilities(true));
                } else {
                    logger.info("Local cihazda IOS ortamında test ayağa kalkacak");
                    appiumDriver = new IOSDriver<>(targetUrl, iosCapabilities(true));
                }
            }

            selector = SelectorFactory
                    .createElementHelper(localAndroid ? SelectorType.ANDROID : SelectorType.IOS);

            appiumFluentWait = new FluentWait<>(appiumDriver);
            appiumFluentWait.withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(250))
                    .ignoring(NoSuchElementException.class);

        } catch (MalformedURLException e) {
            logger.error("Hub URL geçersiz!", e);
            throw new RuntimeException(e);
        }
    }

    @AfterAll
    public static void afterScenario() {
        if (appiumDriver != null) {
            try {
                appiumDriver.quit();
            } catch (Exception e) {
                logger.warn("Driver quit sırasında hata: " + e.getMessage());
            }
        }
    }

    public static DesiredCapabilities androidCapabilities(boolean isLocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.gratis.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                "com.app.gratis.ui.splash.SplashActivity");

        if (isLocal) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
        } else {
            // ---- TESTINIUM ----
            addTestiniumCapabilities();
        }
        return capabilities;
    }

    public static DesiredCapabilities iosCapabilities(boolean isLocal) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability("bundleId", "com.pharos.Gratis");

        if (!isLocal) {
            // ---- TESTINIUM ----
            addTestiniumCapabilities();
            capabilities.setCapability("waitForAppScript", "$.delay(1000);");
            capabilities.setCapability("usePrebuiltWDA", true);
            capabilities.setCapability("useNewWDA", true);
        } else {
            // ---- LOCAL IOS ----
            capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability(MobileCapabilityType.UDID,
                    "1e5cdbbadc4a7dc3e4389298330bad5c587904d5");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone SE");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.5");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);
            capabilities.setCapability("sendKeyStrategy", "setValue");
        }
        return capabilities;
    }

    /**
     * Testinium ortamı için gerekli capability'leri ekler.
     * testinium:key ZORUNLUDUR — eksikse Hub session açmaz.
     */
    private static void addTestiniumCapabilities() {
        String key = System.getProperty(PROP_KEY);
        if (StringUtils.isEmpty(key)) {
            throw new IllegalStateException(
                    "Testinium 'key' bulunamadı! " +
                            "Testinium panelinden Test/Access Key tanımlandığından emin ol. " +
                            "Local test için -Dkey=username:accesskey parametresi gerekli.");
        }
        capabilities.setCapability(CAP_CLOUD_KEY, key);

        // Opsiyonel — Testinium panelinde tanımlıysa kullanılır
        String testID = System.getProperty(PROP_TESTID);
        if (StringUtils.isNotEmpty(testID)) {
            capabilities.setCapability(CAP_CLOUD_TESTID, testID);
        }

        // Örnek opsiyonel ayarlar (ihtiyaca göre aç/kapat):
        // capabilities.setCapability(CAP_CLOUD_TAKE_SS, "only_failure");
        // capabilities.setCapability(CAP_CLOUD_RECORDVIDEO, true);
    }
}