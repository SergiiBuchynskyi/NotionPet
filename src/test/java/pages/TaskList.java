package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskList extends BasePage {

    @FindBy(xpath = "(//div[text()='New'])[1]")
    public WebElement newTask;

    @FindBy(xpath = "//div[@class='notion-selectable notion-page-block notion-collection-item']")
    public WebElement tasksAll;

    @FindBy(xpath = "(//div[@class='notion-peek-renderer']//div[@data-block-id])[1]")
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


}
