package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class ToolTipPage {
    WebDriver driver;
    public ToolTipPage() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='age']")
    public WebElement ageBox;

    @FindBy(xpath = "//iframe")
    public WebElement frameBox;

    @FindBy(xpath = "//*[@role='tooltip']")
    public WebElement ageDisclosure;



}
