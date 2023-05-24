package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import java.util.List;

public class TaskList extends BasePage {

    @FindBy(xpath = "(//div[text()='New'])[1]")
    public WebElement newTask;

    @FindBy(xpath = "//div[@class='notion-selectable notion-page-block notion-collection-item']")
    public WebElement tasksAll;

    @FindBy(xpath = "(//div[@class='notion-peek-renderer']//div[@data-block-id])[1]//div")
    public WebElement taskTitle;
    @FindBy(xpath = "//div[contains(text(), \"Press Enter to continue with an empty page\")]")
    public WebElement taskDescription;

    @FindBy(xpath = "(//div[@class='notion-board-group'][1]//div[@spellcheck])[1]")
    public WebElement taskDescriptionOnBoard;

    @FindBy(xpath = "(//div[@class='notion-board-group'][1]//div[@spellcheck])[1]")
    public WebElement taskTitleOnBoard;


    @FindBy(xpath = "//div[text()='Sort']")
    public WebElement sort;
    @FindBy(xpath = "//div[text()='Name']")
    public WebElement sortByName;
    @FindBy(xpath = "//div[text()='Status']")
    public WebElement sortByStatus;
    @FindBy(xpath = "//div[text()='Date Created']")
    public WebElement sortByDateCreated;

    @FindBy(xpath = "(//div[@style='display: flex; flex-direction: column;'][2]//div)[9]")
    public WebElement status;
    @FindBy(xpath = "(//div[text()='To Do'])[2]")
    public WebElement toDoStatus;

    //4 boxes of the board list
    // to do | doing | done | no status
    public List<WebElement> listOfBoxes() {
        return Driver.getDriver().findElements(By.cssSelector(".notion-board-group"));
    }

}
