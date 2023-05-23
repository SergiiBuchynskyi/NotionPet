package step_Definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.TaskList;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class CreateTaskSteps {

    LoginPage loginPage = new LoginPage();
    TaskList taskList = new TaskList();
    List<WebElement> listOfTasks;

    @Given("user navigates to main page and already logged in")
    public void user_is_already_logged() {
        Driver.getDriver().get(ConfigurationReader.getProperty("baseUrl"));
        /*//loginPage.loginStep1.click();
        loginPage.loginStep2.click();
        loginPage.inputNotionEmailStep3.sendKeys(ConfigurationReader.getProperty("userEmail"));
        loginPage.continueWithEmailStep4.click();
        loginPage.inputNotionPasswordStep5.sendKeys(ConfigurationReader.getProperty("userPassword"));
        loginPage. continueWithPasswordStep6.click();
        */
        loginPage.loginMethod();


    }

    @Given("click Task List")
    public void click_task_list() {
        taskList.taskList.click();
    }


    @Then("User should see all the tasks assigned")
    public void userShouldSeeAllTheTasksAssigned() {

       listOfTasks = Driver.getDriver().findElements(By.xpath("//div[@class='notion-selectable notion-page-block notion-collection-item']"));
        System.out.println("Quantity of tasks found - " + listOfTasks.size());
        if (listOfTasks.size() > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @When("User opens any Task")
    public void userOpensAnyTask() {
        listOfTasks = Driver.getDriver().findElements(By.xpath("//div[@class='notion-selectable notion-page-block notion-collection-item']"));
        listOfTasks.get(0).click();
    }

    @Then("User see title, description, and relevant details")
    public void userSeeTitleDescriptionAndRelevantDetails() {
        Assert.assertTrue(taskList.taskDescriptionOnBoard.isDisplayed());
        Assert.assertTrue(taskList.taskTitleOnBoard.isDisplayed());
    }

    @When("User click sort and click name")
    public void userClickSortAndClickName() {
        taskList.sort.click();


    }

    @Then("Tasks should be sorted by name a-z")
    public void tasksShouldBeSortedByNameAZ() {
    }

    @When("User click New button")
    public void userClickNewButton() {
        BrowserUtils.waitForVisibility(taskList.newTask, 10);
        taskList.newTask.click();
    }

    @Then("User see title and description is displayed")
    public void userSeeTitleAndDescriptionIsDisplayed() {
        BrowserUtils.waitForVisibility(taskList.taskTitle, 10);
        Assert.assertTrue(taskList.taskTitle.isDisplayed());
        Assert.assertTrue(taskList.taskDescription.isDisplayed());
    }
}
