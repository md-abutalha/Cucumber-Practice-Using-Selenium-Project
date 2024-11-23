package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;


import java.time.Duration;

public class DriverSetup {


    private static final ThreadLocal<WebDriver> LOCAL_THREAD = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DriverSetup.LOCAL_THREAD.set(driver);
    }

    public static WebDriver getDriver() {
        return LOCAL_THREAD.get();
    }


    public static WebDriver getBrowser(String browser_name) {
        if (browser_name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browser_name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (browser_name.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Browser not available this name: " + browser_name);
        }
    }


    // Creating browser

    public static void openBrowser(String browserName) {
        WebDriver driver = getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        setDriver(driver);
    }

    // Closing browser

    public static void closeBrowser(Scenario scenario) {
        takeScreenShotsFailed(scenario);
        getDriver().quit();

    }


    public static void takeScreenShotsFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            String name = scenario.getName().replaceAll("", "_");
            byte[] source = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source,"image/png", name);
        }
    }


}
