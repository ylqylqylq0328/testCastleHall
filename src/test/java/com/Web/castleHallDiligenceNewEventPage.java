package com.Web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class castleHallDiligenceNewEventPage extends PageObject{

    @FindBy(name = "email")
    private WebElement Email;

    @FindBy(name = "LEGAL_CONSENT.subscription_type_4644539")
    private WebElement ReceiveCommunication;

    @FindBy(xpath = "//*[@type = 'submit']")
    private WebElement Submit;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_blog_subscription_title']")
    private WebElement Success;

    @FindBy(xpath = "//div[5]/ul/li/label")
    private WebElement ErrorMessage;

    public castleHallDiligenceNewEventPage(WebDriver driver) {
        super(driver);
    }

    public void SubmitAction(String email, boolean receiveCommunication) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Email.sendKeys(email);
        if (receiveCommunication) {
            ReceiveCommunication.click();
        }
        ReceiveCommunication.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(Submit).click().build().perform();
    }

    public String getSuccessTitle() {
        return Success.getText();
    }

    public String getErrorMessage() {
        return ErrorMessage.getText();
    }
}
