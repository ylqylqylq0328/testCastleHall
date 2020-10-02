package com.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class castleHallDiligenceWhyCastleHallPage extends PageObject{

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_1497992508648437']/h2")
    private WebElement AtAGlance;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_1497992439167416']/h2")
    private WebElement TeamMembers;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_1497992500232433']/h2")
    private WebElement FundsCovered;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_1497992497318429']/h2")
    private WebElement Countries;

    public castleHallDiligenceWhyCastleHallPage(WebDriver driver) {
        super(driver);
    }

    public String TeamMembersText() {
        return TeamMembers.getText();
    }

    public String FundsCoveredText() {
        return FundsCovered.getText();
    }

    public String CountriesText() {
        return Countries.getText();
    }
}
