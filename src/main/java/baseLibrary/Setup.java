package baseLibrary;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {
    protected static AndroidDriver driver;

    public static void initializeDriver(String platformName) throws MalformedURLException {
        if ("Android".equalsIgnoreCase(platformName)) {
            System.out.println("Initializing Android driver...");

            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setDeviceName("Emulator");
            options.setAutomationName("UiAutomator2");
            //options.setUdid("3B101FDJH0075X");
            options.setUdid("emulator-5556");

            options.setAppPackage("com.amazon.avod.thirdpartyclient");
            options.setAppActivity(".LauncherActivity");

            options.setNoReset(true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            options.setCapability("autoAcceptAlerts", true);
            options.setCapability("autoDismissAlerts", false);

            options.setCapability("ignoreHiddenApiPolicyError", true);

            URL url = new URL("http://localhost:4723/");
            driver = new AndroidDriver(url, options);
        }
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }
}

