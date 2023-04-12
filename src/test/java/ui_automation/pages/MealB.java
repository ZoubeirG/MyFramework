package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class MealB {

    @FindBy(xpath = "//*[@href='/Account/Login']")
    public WebElement signInbutton;

    @FindBy(xpath = "//*[@name='usernameOrEmailAddress']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//*[@name='Password']")
    public WebElement passwordTextBox;

    @FindBy(css = "#LoginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@href='/Expenses']")
    public WebElement expensesTab;

    @FindBy(xpath = "//*[@id='expenses-table_wrapper']//button")
    public WebElement addExpensesTab;

    @FindBy(xpath = "//*[@id='expenses-table_wrapper']//div/ul/li[2]/a")
    public WebElement mealAndEntertainmentDopDownTab;

    @FindBy(css = "#ExpenseDateTime")
    public WebElement dateBox;

    @FindBy(xpath = "//*[@id='ExpenseDateTime_root']//div[2]/button[1]")
    public WebElement entryDate;

    @FindBy(css = "#Amount")
    public WebElement amount;

    @FindBy(css = "#name")
    public WebElement expenseNameEntry;

    @FindBy(css = ".btn.btn-primary.save-button.waves-effect")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='expenses-table']/tbody/tr/td[2]")
    public List<WebElement> expenseNameVerification;

    @FindBy(css = "#ExpenseEditForm")
    public WebElement modalWindow;

    @FindBy(css = "#selectAllExpensesHeader")
    public WebElement expenseSelectTab;

    WebDriver driver;

    public MealB() {
        driver = Driver.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
    public String expenseName;

    public void completeExpenseModal(double expenseAmount, String expenseName) {
        this.expenseName = expenseName;

        dateBox.click();
        entryDate.click();
        amount.sendKeys(String.valueOf(expenseAmount));
        expenseNameEntry.sendKeys(expenseName);

    }


}
