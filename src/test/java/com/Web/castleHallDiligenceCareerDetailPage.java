package com.Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class castleHallDiligenceCareerDetailPage extends PageObject{

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_142263500760546066_title']")
    private WebElement ApplyFor;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_module_14945973230434188']/h1/strong")
    private WebElement JobTitle;

    public castleHallDiligenceCareerDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean getApplyfor(String applyFor){
        return ApplyFor.getText().equals(applyFor);
    }

    public boolean getJobTitle(String jobTitle){
        return JobTitle.getText().contains(jobTitle);
    }
}
