package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utilities.DriverSetup.closeBrowser;
import static utilities.DriverSetup.openBrowser;

public class Hooks {
    private static String browserName = System.getProperty("browser", "chrome");
    @Before
    public void start(){
        openBrowser(browserName);
    }
    @After
    public void close(Scenario scenario){
        closeBrowser(scenario);
    }


}
