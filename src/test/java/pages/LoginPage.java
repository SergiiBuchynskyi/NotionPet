package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigurationReader;

public class LoginPage extends BasePage{

    @FindBy(xpath = "svg[class='menu']")//appears only when window is narrow
    public WebElement loginStep1;
    @FindBy(xpath = "//*[text() = 'Log in']")
    public WebElement loginStep2;

    @FindBy(css = "input[id='notion-email-input-1']")
    public WebElement inputNotionEmailStep3;

    @FindBy(xpath = "//*[text() = 'Continue with email']")
    public WebElement continueWithEmailStep4;

    @FindBy(id = "notion-password-input-2")
    public WebElement inputNotionPasswordStep5;

    @FindBy(xpath = "//*[text() = 'Continue with password']")
    public WebElement continueWithPasswordStep6;

    public void loginMethod(){
        //loginStep1.click();
        loginStep2.click();
        inputNotionEmailStep3.sendKeys(ConfigurationReader.getProperty("userEmail"));
        continueWithEmailStep4.click();
        inputNotionPasswordStep5.sendKeys(ConfigurationReader.getProperty("userPassword"));
        continueWithPasswordStep6.click();
    }

}
