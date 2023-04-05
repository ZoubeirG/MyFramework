package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class DemoQAPage {
    WebDriver driver;

    public DemoQAPage() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#alertButton")
    public WebElement clickToSeeAlert;

    @FindBy(id = "timerAlertButton")
    public WebElement clickToSeeAlertWait5;

    @FindBy(css = "#windowButton")
    public  WebElement newWindow;

}
