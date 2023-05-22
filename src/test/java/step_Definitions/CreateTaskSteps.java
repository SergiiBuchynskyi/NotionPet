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
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class CreateTaskSteps {

    LoginPage loginPage = new LoginPage();
    TaskList taskList = new TaskList();

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

        List<WebElement> listOfTasks = Driver.getDriver().findElements(By.xpath("//div[@class='notion-selectable notion-page-block notion-collection-item']"));
        System.out.println("quantity of tasks found" + listOfTasks.size());
        if (listOfTasks.size() > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @When("User opens any Task")
    public void userOpensAnyTask() {
    }

    @Then("User see title, description, and relevant details")
    public void userSeeTitleDescriptionAndRelevantDetails() {
    }

    @When("User click sort and click name")
    public void userClickSortAndClickName() {
    }

    @Then("Tasks should be sorted by name a-z")
    public void tasksShouldBeSortedByNameAZ() {
    }
}
