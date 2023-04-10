package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.*;
import ui_automation.utilities.*;
import ui_automation.utilities.Driver;

import java.sql.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class StepDefs {


    private final Logger oLog = LogManager.getLogger(SelectHelper.class);
    WebDriver driver = Driver.getInstance().getDriver();
    DemoQAPage qaPage = new DemoQAPage();
    TheInternetHeroku heroku = new TheInternetHeroku();
    MagentoPage magentoPage = new MagentoPage();
    Actions act = new Actions(Driver.getInstance().getDriver());
    ToolTipPage toolTipPage = new ToolTipPage();
    String mainGUID;
    MealB mealB = new MealB();
    OhrmEmployeesPage hrmPage = new OhrmEmployeesPage();

    @Given("i am on the jquery site")
    public void i_am_on_the_jquery_site() {
        driver.get("https://jqueryui.com/tooltip/");
    }

    @Given("i hover over the age input box")
    public void i_hover_over_the_age_input_box() {
        driver.switchTo().frame(toolTipPage.frameBox);
        act.moveToElement(toolTipPage.ageBox).build().perform();
    }

    @Then("i should be able to see the tootTip box")
    public void i_should_be_able_to_see_the_tootTip_box() {

        boolean actualMessage = toolTipPage.ageDisclosure.isDisplayed();
        Assert.assertTrue("message not present", actualMessage);
    }

    @Given("user navigates to to {string} practice page")
    public void user_navigates_to_to_practice_page(String url) {
        oLog.info("navigating to " + url + " page");
        driver.get(url);
    }

    @Then("user clicks the choose file tab and sends the location of the file")
    public void user_clicks_the_choose_file_tab_and_sends_the_location_of_the_file() {
        String filePath = "C:\\Selenium\\Projects\\MyFrameworkPractice\\src\\test\\resources\\testData\\fileUpload\\coolPDF.pdf";
        heroku.chooseFile.sendKeys(filePath);
    }

    @Then("user clicks the upload tab")
    public void user_clicks_the_upload_tab() {

        heroku.fileSubmit.click();
    }

    @Then("user should see the file uploaded message to on the confirmation page")
    public void user_should_see_the_file_uploaded_message_to_on_the_confirmation_page() {
        String expectedMessage = "File Uploaded!";
        String actualMessage = heroku.fileUploadedConfirmationMessage.getText();
        Assert.assertEquals("file not uploaded", expectedMessage, actualMessage);
    }

    @Then("locate, hover over and click the search box")
    public void locate_hover_over_and_click_the_search_box() {
        Driver.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        act.moveToElement(magentoPage.searchBox).click(magentoPage.searchBox);
    }

    @Then("write {string} with upper case letters using keys.SHIFT in the search box")
    public void write_with_upper_case_letters_using_keys_SHIFT_in_the_search_box(String item) {
        act.keyDown(magentoPage.searchBox, Keys.SHIFT).sendKeys(item).keyUp(magentoPage.searchBox, Keys.SHIFT).build().perform();

    }

    @Then("Double click in the search box and perform and build")
    public void double_click_in_the_search_box_and_perform_and_build() {
        act.doubleClick(magentoPage.searchBox).build().perform();


    }

    @Then("click the search")
    public void click_the_search() {
        magentoPage.searchTab.click();
        String expectedTitle = "Search results for: 'JEANS'";
        String actualTitle = magentoPage.resultTile.getText();
        Assert.assertEquals("landing page error", expectedTitle, actualTitle);
    }

    @Given("user is on the practice webpage")
    public void user_is_on_the_practice_webpage() {
        Driver.getInstance().getDriver().get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

    }

    @Then("user clicks the right click me tab")
    public void user_clicks_the_right_click_me_tab() throws InterruptedException {
        WebElement rightClickTab = Driver.getInstance().getDriver().findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        Actions act = new Actions(Driver.getInstance().getDriver());
        act.contextClick(rightClickTab).perform();
        Thread.sleep(3000);

    }

    @Then("user clicks Copy tab")
    public void user_clicks_Copy_tab() throws InterruptedException {
        Driver.getInstance().getDriver().findElement(By.xpath("//li[contains(@class,'icon-copy')]")).click();
        Thread.sleep(3000);


    }

    @Then("user switch and get text from alert")
    public void user_switch_and_get_text_from_alert() {
        Alert myAlert = Driver.getInstance().getDriver().switchTo().alert();
        System.out.println(" the message of the alert is " + myAlert.getText());

    }

    @Then("user clicks ok to alert")
    public void user_clicks_ok_to_alert() throws InterruptedException {
        Driver.getInstance().getDriver().switchTo().alert().accept();
        Thread.sleep(3000);

    }

    @Given("I'm on magento homepage")
    public void i_m_on_magento_homepage() throws InterruptedException {
        Driver.getInstance().getDriver().get("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
    }

    @Then("i hover over gear tab")
    public void i_hover_over_gear_tab() throws InterruptedException {
        WebElement gearTab = Driver.getInstance().getDriver().findElement(By.id("ui-id-6"));
        Thread.sleep(2000);
        Actions act = new Actions(Driver.getInstance().getDriver());
        act.moveToElement(gearTab).perform();

        Thread.sleep(2000);


    }

    @Then("i click on Fitness Equipment")
    public void i_click_on_Fitness_Equipment() {

        Driver.getInstance().getDriver().findElement(By.id("ui-id-26")).click();

    }

    @Then("i ma navigated to Fitness Equipment page")
    public void i_ma_navigated_to_Fitness_Equipment_page() throws InterruptedException {
        Thread.sleep(2000);
        String expectedPageName = "Fitness Equipment";
        String actualPageName = Driver.getInstance().getDriver().findElement(By.xpath("//*[@data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals("page landing error", expectedPageName, actualPageName);

    }

    @Given("i am one the {string} Practice page")
    public void i_am_one_the_Practice_page(String url) {
        Driver.getInstance().getDriver().get(url);
        Driver.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("i navigate to the search box and click ENTER")
    public void i_navigate_to_the_search_box_and_click_ENTER() {
        act.moveToElement(heroku.searchBar).sendKeys(Keys.ENTER).build().perform();
    }

    @Then("i navigate to the search box and click SHIFT")
    public void i_navigate_to_the_search_box_and_click_SHIFT() {
        act.moveToElement(heroku.searchBar).sendKeys(Keys.SHIFT).build().perform();
    }

    @Then("i navigate to the search box and click SPACE")
    public void i_navigate_to_the_search_box_and_click_SPACE() {
        act.moveToElement(heroku.searchBar).sendKeys(Keys.SPACE).build().perform();
    }

    @Then("i should see the confirmation message matching the ENTER text")
    public void i_should_see_the_confirmation_message_matching_the_ENTER_text() {
        String expectResult = "You entered: ENTER";
        String actualResult = heroku.result.getText();
        Assert.assertEquals("incorrect key entered", expectResult, actualResult);
    }

    @Then("i should see the confirmation message matching the SHIFT text")
    public void i_should_see_the_confirmation_message_matching_the_SHIFT_text() {
        String expectResult = "You entered: SHIFT";
        String actualResult = heroku.result.getText();
        Assert.assertEquals("incorrect key entered", expectResult, actualResult);
    }

    @Then("i should see the confirmation message matching the SPACE text")
    public void i_should_see_the_confirmation_message_matching_the_SPACE_text() {
        String expectResult = "You entered: SPACE";
        String actualResult = heroku.result.getText();
        Assert.assertEquals("incorrect key entered", expectResult, actualResult);
    }

    @Then("user clicks the file to download")
    public void userClicksTheFileToDownload() throws InterruptedException {
        oLog.info("click a specific file to download  ");

//        WebDriverManager.chromedriver().setup();
//        HashMap<String, Object> chromePath = new HashMap<String, Object>();
//        chromePath.put("download.default_directory", System.getProperty("user.dir") + "src/test/resources/testData/downloads");
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePath);
//        driver = new ChromeDriver(options);

        Thread.sleep(3000);
        heroku.fileLink.click();
        Thread.sleep(3000);
    }

    @Given("i am on site")
    public void i_am_on_site() {
        driver.get(ConfigurationReader.getProperty("demoQaAlertsPage.url"));
        oLog.info("navigated to site");
    }

    @Then("i select the click me tab")
    public void i_select_the_click_me_tab() {
        qaPage.clickToSeeAlert.click();
        oLog.info("clicked the click button");
        boolean isAlertPresent = qaPage.clickToSeeAlert.isDisplayed();
        Wait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Alert not displayed", isAlertPresent);
    }

    @Then("i switch to the alert and confirm it.")
    public void i_switch_to_the_alert_and_confirm_it() {
        Wait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        oLog.info("switched to alert window");
        alert.accept();
    }

    @Then("i select the second click me tab")
    public void iSelectTheSecondClickMeTab() {
        qaPage.clickToSeeAlertWait5.click();
        oLog.info("switched to 5 second wait alert window");
        boolean isAlertPresent = qaPage.clickToSeeAlertWait5.isDisplayed();
        Assert.assertTrue("Alert not displayed", isAlertPresent);
    }

    @Then("i click on the iFrame tab")
    public void i_click_on_the_iFrame_tab() {
        heroku.iframesTab.click();
    }

    @Then("i type {string} in the text box")
    public void i_type_in_the_text_box() {
        driver.switchTo().frame(heroku.iFrameBoxIniFramePage);
        heroku.contentTextBox.clear();
        heroku.contentTextBox.sendKeys();
    }

    @Then("i confirm the text in the filed is {string}")
    public void i_confirm_the_text_in_the_filed_is(String expectedText) {

        String actualText = heroku.contentTextBox.getText();
        Assert.assertEquals("incorrect text displayed", expectedText, actualText);
    }

    @Given("i am one the the internet heroku app Practice page")
    public void i_am_one_the_the_internet_heroku_app_Practice_page() {
        driver.get(ConfigurationReader.getProperty("theInternetHerokuapp.url"));
    }

    @Then("i click on the Frames tab")
    public void i_click_on_the_Frames_tab() {
        heroku.framesTab.click();
    }

    @Then("user clicks on nested Frames tab")
    public void user_clicks_on_nested_Frames_tab() {
        heroku.nestedFramesTab.click();
    }

    @Then("user should be able to see below texts")
    public void user_should_be_able_to_see_below_texts(List<String> locations) {
        for (int i = 1; i < locations.size(); i++) {
            if (locations.get(i).equalsIgnoreCase("LEFT")) {
                driver.switchTo().frame(heroku.outerTopFrame);
                driver.switchTo().frame(heroku.innerLeftFrame);
            } else if (locations.get(i).equalsIgnoreCase("RIGHT")) {
                driver.switchTo().frame(heroku.outerTopFrame);
                driver.switchTo().frame(heroku.innerRightFrame);
            } else if (locations.get(i).equalsIgnoreCase("MIDDLE")) {
                driver.switchTo().frame(heroku.outerTopFrame);
                driver.switchTo().frame(heroku.innerMiddleFrame);
            } else if (locations.get(i).equalsIgnoreCase("BOTTOM")) {
                driver.switchTo().frame(heroku.outerBottomFrame);
            }

            String actualText = heroku.bodyText.getText().toUpperCase();
            String expectedTExt = locations.get(i);
            Assert.assertEquals("incorrect frame", expectedTExt, actualText);
            oLog.info("step " + i + " complete " + actualText);
            driver.switchTo().defaultContent();
        }

    }

    @Given("user navigates to demoQA browser {string}page")
    public void userNavigatesToDemoQABrowserPage(String link) {
        driver.get(ConfigurationReader.getProperty("demoQaPage.url") + link);
    }

    @Then("user sees the title of page as {string}")
    public void user_sees_the_title_of_page_as(String title) {
        Assert.assertEquals("page error", title, driver.getTitle());
    }

    @Then("user click on New Window button")
    public void user_click_on_button() {
        qaPage.newWindow.click();
    }

    @Then("user switch to newly opened window")
    public void user_switch_to_newly_opened_window() {
        mainGUID = driver.getWindowHandle();
        Set<String> GUIDS = driver.getWindowHandles();
        for (String guid : GUIDS) {
            driver.switchTo().window(guid);
        }
    }

    @Then("user see the url of page having {string}")
    public void user_see_the_url_of_page_having(String pageUrl) {
        String currentURL = driver.getCurrentUrl();
        oLog.info("currentURL: " + currentURL);
        Assert.assertTrue("incorrect window open", currentURL.contains(pageUrl));
    }

    @Then("user is able to close the new window")
    public void user_is_able_to_close_the_new_window() {
        driver.close();
    }

    @Then("user switch to original window")
    public void user_switch_to_original_window() {
        driver.switchTo().window(mainGUID);
        String currentURL = driver.getCurrentUrl();
        oLog.info("currentURL: " + currentURL);
    }

    @Then("user see the title of page as {string}")
    public void user_see_the_title_of_page_as(String title) {
        Assert.assertEquals("page error", title, driver.getTitle());
    }

    @Given("i am logged on to the Meal B Practice page")
    public void i_am_logged_on_to_the_Meal_B_Practice_page() {
        driver.get(ConfigurationReader.getProperty("mealb.url"));
        mealB.signInbutton.click();
        mealB.usernameTextBox.sendKeys(ConfigurationReader.getProperty("mealb.username"));
        mealB.passwordTextBox.sendKeys(ConfigurationReader.getProperty("mealb.password"));
        mealB.loginButton.click();
    }

    @Given("i click on Expenses tab")
    public void i_click_on_Expenses_tab() {
        mealB.expensesTab.click();
    }

    @Then("i click on Add Expenses tab and select Meal & Entertainment for the drop down list")
    public void i_click_on_Add_Expenses_tab_and_select_Meal_Entertainment_for_the_drop_down_list() {
        mealB.addExpensesTab.click();
        mealB.mealAndEntertainmentDopDownTab.click();
        WaitHelper.waitForVisibility(mealB.modalWindow, 5);
    }

    @Then("i complete the Create Meal & Entertainment expense information")
    public void i_complete_the_Create_Meal_Entertainment_expense_information() throws Exception {

        String excelPath = System.getProperty("user.dir") + "/src/test/resources/testData/Keywords.xlsx";
        ExcelUtility.setExcelFile(excelPath, "Sheet1");
        Object expenseAmount = ExcelUtility.getCellData(3, 1);
        Object expenseName = ExcelUtility.getCellData(3, 2);

        mealB.completeExpenseModal((Double) expenseAmount, (String) expenseName);
    }

    @When("i click save button")
    public void i_click_save_button() throws InterruptedException {
        mealB.saveButton.click();
    }

    @Then("my newly added expense is displayed on table")
    public void my_newly_added_expense_is_displayed_on_table() throws InterruptedException {
        WaitHelper.wait(2);
        String expense = mealB.expenseNameVerification.getText();
        Assert.assertEquals("expense not saved", mealB.expenseName, expense);
    }

    @Given("i click on the PIM tab")
    public void i_click_on_the_PIM_tab() {

        hrmPage.pImTab.click();
    }

    @Given("i click EmployeeList using JS Executor")
    public void i_click_EmployeeList_using_JS_Executor() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", hrmPage.employeeTab);
        WaitHelper.wait(3);
    }


    @Then("i should be able to verify UI and DB data")
    public void iShouldBeAbleToVerifyUIAndDBData() throws ClassNotFoundException, SQLException {

//        List <WebElement> expenseNames=driver.findElements(By.xpath("//*[@id='expenses-table']/tbody/tr/td[2]"));
//        for (WebElement expenseName : expenseNames){oLog.info(expenseName.getText());}
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = ConfigurationReader.getProperty("mb.database.url");
        String dbUsername = ConfigurationReader.getProperty("mb.database.username");
        String dbPassword = ConfigurationReader.getProperty("mb.database.password");

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from EXPENSES");
        oLog.info(resultSet.getRow());


    }
}




