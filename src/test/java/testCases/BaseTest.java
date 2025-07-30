package testCases;

import baseLibrary.Setup;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class BaseTest extends Setup {
    protected static ExtentReports report;
    public static String report1;
    protected static ExtentTest test;

    protected static AndroidDriver driver;
    @BeforeSuite
    public void globalSetup() throws MalformedURLException {
        Date d = new Date();
        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".html";
        report1 = "Amzon Automation test report " + fileName;
        System.out.println(report1);
        report = new ExtentReports(System.getProperty("user.dir") + "/" + report1);

        Setup.initializeDriver("Android");

        driver = Setup.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.startRecordingScreen();
        }



    @AfterSuite
    public void globalTearDown() throws IOException {
        String video = driver.stopRecordingScreen();

        // Create timestamp for the filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Save recording to Project Directory with timestamp
        File videoFile = new File(System.getProperty("user.dir") + "/ScreenRecording_" + timestamp + ".mp4");

        try (FileOutputStream fos = new FileOutputStream(videoFile)) {
            fos.write(Base64.getDecoder().decode(video));
        }

        System.out.println("Screen recording saved at: " + videoFile.getAbsolutePath());

        report.flush();


    }



    protected void captureScreenshot(WebDriver driver) {
        ScreenShotUtil.captureAndResize(driver, test);
    }
}


