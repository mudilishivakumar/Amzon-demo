package testCases;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AppLoginCases extends BaseTest {
    LoginPage Lo;

    @BeforeClass
    public void setupPage() {
        Lo = PageFactory.initElements(driver, LoginPage.class);

    }

    @Test(priority = 1)
    public void testLaunchApp() {
        try {
            test=report.startTest("App launch");

            if (Lo.splashscreen(driver).isDisplayed()) {
                Lo.splashscreen(driver).click();
                test.log(LogStatus.PASS, "User able to see splash logo");
            } else {
                test.log(LogStatus.FAIL, "Splash logo is not displayed");
                captureScreenshot(driver); // Optionally capture screenshot on failure
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred: " + e.getMessage());
            captureScreenshot(driver); // Optionally capture screenshot on error
        }
    }

    @Test(priority = 2)
    public void email() {
        try {
            test=report.startTest("email Emter");

            if (Lo.email(driver).isDisplayed()) {
                Lo.email(driver).sendKeys("mudilishivakumar88@gmail.com");
                test.log(LogStatus.PASS, "User entered email");
                captureScreenshot(driver);
            } else {
                test.log(LogStatus.FAIL, "Email field is not displayed");
                captureScreenshot(driver);
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception while entering email: " + e.getMessage());
            captureScreenshot(driver);
        }
    }

    @Test(priority = 3)
    public void continueButton() {
        try {
            test=report.startTest("continueButton");

            if (Lo.continueButton(driver).isDisplayed()) {
                Lo.continueButton(driver).click();
                test.log(LogStatus.PASS, "User clicked on continueButton");
                captureScreenshot(driver);
            } else {
                test.log(LogStatus.FAIL, "Continue button is not displayed");
                captureScreenshot(driver);
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception while clicking continue button: " + e.getMessage());
            captureScreenshot(driver);
        }
    }

    @Test(priority = 4)
    public void password() {
        try {
            test=report.startTest("password");
            if (Lo.password(driver).isDisplayed()) {
                Lo.password(driver).sendKeys("7036505508");
                test.log(LogStatus.PASS, "User entered password");
                captureScreenshot(driver);
            } else {
                test.log(LogStatus.FAIL, "Password field is not displayed");
                captureScreenshot(driver);
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception while entering password: " + e.getMessage());
            captureScreenshot(driver);
        }
    }

    @Test(priority = 5)
    public void sign() {
        try {
            test=report.startTest("sign");
            if (Lo.signInSubmit(driver).isDisplayed()) {
                Lo.signInSubmit(driver).click();
                test.log(LogStatus.PASS, "User clicked on signButton");
                captureScreenshot(driver);
            } else {
                test.log(LogStatus.FAIL, "Sign button is not displayed");
                captureScreenshot(driver);
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception while clicking sign button: " + e.getMessage());
            captureScreenshot(driver);
        }
    }
}