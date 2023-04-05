package ui_automation.step_definitions;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ui_automation.utilities.BrowserFactory;
import ui_automation.utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver=null;

    /**
     * @Before annotation will get executed before each and every scenario
     * @Before is coming from import io.cucumber.java.*;
     */
    @Before
    public void setUp(){
        // This is similar what we had driver = new Chromedriver();
        driver= BrowserFactory.createInstance();
        // Driver.getInstance() will return existing instance from JVM and setDriver() will set driver we get from BrowserFactory with above line
        Driver.getInstance().setDriver(driver);
        // in order to get driver back Driver.getInstance() which returns instance from JVM and getDriver();
        driver=Driver.getInstance().getDriver();
        // implicit wait is global
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //
    }

    @After
    public void tearDown(Scenario scenario) {
        // if scenario is failed and Scenario class is coming import io.cucumber.core.api.Scenario;
        if (scenario.isFailed()) {
            // take screenshot by using getScreenshotAs method from TakesScreenshot interface coming from import org.openqa.selenium.TakesScreenshot;
            final byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            // embed that screenshot into scenario
            scenario.embed(screenshot, "image/png");
        }
        // close driver
        Driver.getInstance().removeDriver();
    }
}