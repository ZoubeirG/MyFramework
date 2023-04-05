package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class TheInternetHeroku {
    WebDriver driver;
    public TheInternetHeroku() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//frame[@src='/frame_top']")
    public WebElement outerTopFrame;

    @FindBy(xpath = "//frame[@src='/frame_bottom']")
    public WebElement outerBottomFrame;

    @FindBy(xpath = "//frame[@src='/frame_left']")
    public WebElement innerLeftFrame;

    @FindBy(xpath = "//frame[@src='/frame_middle']")
    public WebElement innerMiddleFrame;

    @FindBy(xpath = "//frame[@src='/frame_right']")
    public WebElement innerRightFrame;

    @FindBy(xpath = "/html/body")
    public WebElement bodyText;

    @FindBy(id = "target")
    public WebElement searchBar;

    @FindBy(id="result")
    public WebElement result;

    @FindBy(id = "file-upload")
    public WebElement chooseFile;

    @FindBy (id = "file-submit")
    public WebElement fileSubmit;

    @FindBy(xpath = "//*[text()='File Uploaded!']")
    public WebElement fileUploadedConfirmationMessage;

    @FindBy(xpath = "//*[@class='example']/a[4]")
    public WebElement fileLink;

    @FindBy(xpath = "//*[@href='/frames']")
    public WebElement framesTab;

    @FindBy(xpath = "//*[@href='/iframe']")
    public WebElement iframesTab;

    @FindBy(xpath = "//*[@href='/nested_frames']")
    public WebElement nestedFramesTab;

    @FindBy(css = "#mce_0_ifr")
    public WebElement iFrameBoxIniFramePage;

    @FindBy(css = "#tinymce")
    public WebElement contentTextBox;











}
