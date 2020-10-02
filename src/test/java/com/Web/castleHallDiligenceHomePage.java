package com.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class castleHallDiligenceHomePage extends PageObject{

    @FindBy(xpath = "//*[@id='hs_menu_wrapper_module_146731076570911']/ul/li[3]/a")
    private WebElement About;

    @FindBy(xpath = "//*[@id='hs_menu_wrapper_module_146731076570911']/ul/li[3]/ul/li/a")
    private WebElement OurStory;

    @FindBy(xpath = "//*[@id='hs_menu_wrapper_module_146731076570911']/ul/li[3]/ul/li[2]/a")
    private WebElement WhyCastleHall;

    @FindBy(xpath = "//*[@id='hs_menu_wrapper_module_146731076570911']/ul/li[3]/ul/li[3]/a")
    private WebElement OurTeam;

    @FindBy(xpath = "//*[@id='hs_menu_wrapper_module_146731076570911']/ul/li[3]/ul/li[4]/a")
    private WebElement Careers;

    public castleHallDiligenceHomePage(WebDriver driver) {
        super(driver);
    }

    public void aboutClickAction() {
        Actions actions = new Actions(driver);
        actions.moveToElement(About).click().build().perform();
        WebDriverWait myWait = new WebDriverWait(driver, 10);
        myWait.until(ExpectedConditions.visibilityOf(OurStory));
    }

    public boolean OurStoryIsDisplayed() {
        return OurStory.isDisplayed();
    }

    public boolean WhyCastleHallIsDisplayed() {
        return WhyCastleHall.isDisplayed();
    }

    public boolean OurTeamIsDisplayed() {
        return OurTeam.isDisplayed();
    }

    public boolean CareersIsDisplayed() {
        return Careers.isDisplayed();
    }

    public String OurStoryText() {
        return OurStory.getText();
    }

    public String WhyCastleHallText() {
        return WhyCastleHall.getText();
    }

    public String OurTeamText() {
        return OurTeam.getText();
    }

    public String CareersText() {
        return Careers.getText();
    }

    public castleHallDiligenceWhyCastleHallPage whyCastleHallClickAction() {
        WhyCastleHall.click();
        return new castleHallDiligenceWhyCastleHallPage(driver);
    }



}
