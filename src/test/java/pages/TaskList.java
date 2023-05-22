package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskList extends BasePage{

    @FindBy(xpath = "(//div[text()='New'])[2]")
    public WebElement newTask;

    @FindBy(xpath = "//div[@class='notion-selectable notion-page-block notion-collection-item']")
    public WebElement tasksAll;





}
