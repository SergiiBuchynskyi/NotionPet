package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.TaskList;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class CreateTaskSteps {

    public LoginPage loginPage = new LoginPage();
    public TaskList taskList = new TaskList();
    public List<WebElement> listOfTasks;
    public String taskTitle = "";

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

        listOfTasks = Driver.getDriver().findElements(xpath("//div[@class='notion-selectable notion-page-block notion-collection-item']"));
        System.out.println("Quantity of tasks found - " + listOfTasks.size());
        if (listOfTasks.size() > 0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @When("User opens any Task")
    public void userOpensAnyTask() {
        listOfTasks = Driver.getDriver().findElements(xpath("//div[@class='notion-selectable notion-page-block notion-collection-item']"));
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

    @When("User click New button and create task name {string}")
    public void userClickNewButton(String title) {
        BrowserUtils.waitForVisibility(taskList.newTask, 10);
        taskList.newTask.click();
        String randomNumber = BrowserUtils.generateRandomNumber();
        taskList.taskTitle.sendKeys(title+randomNumber);
        taskList.status.click();
        taskList.toDoStatus.click();

        taskTitle = title+randomNumber;

    }

    @Then("User see title and description is displayed")
    public void userSeeTitleAndDescriptionIsDisplayed() {
        BrowserUtils.waitForVisibility(taskList.taskTitle, 10);
        Assert.assertTrue(taskList.taskTitle.isDisplayed());
        Assert.assertTrue(taskList.taskDescription.isDisplayed());
    }

    @And("hold and drag Task to another section")
    public void holdAndDragTaskToAnotherSection() {

        Actions actions = new Actions(Driver.getDriver());
        WebElement task = Driver.getDriver().findElement(By.xpath("//div[text()='"+taskTitle+"']/.."));
        List<WebElement> listOfBoxes = taskList.listOfBoxes();
        System.out.println("listOfBoxes = " + listOfBoxes);
        for (int i = 0; i < listOfBoxes.size(); i++) {

            BrowserUtils.waitFor(3);
            //Assert.assertEquals(expectedStatus.get(i), statusBox.getText());

            BrowserUtils.waitForClickablility(task, 10);
            //actions.dragAndDrop(task, listOfBoxes.get(i)).perform();
            actions.clickAndHold(task).moveToElement(listOfBoxes.get(i+1)).release().perform();
        }


    }

    @Then("Task status is changed")
    public void taskStatusIsChanged() {



    }
}
