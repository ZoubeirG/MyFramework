package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class MagentoPage {
    WebDriver driver;
    public MagentoPage(){
        driver= Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@class='action search']")
    public WebElement searchTab;

    @FindBy(xpath = "//*[@data-ui-id='page-title-wrapper']")
    public WebElement resultTile;



}
