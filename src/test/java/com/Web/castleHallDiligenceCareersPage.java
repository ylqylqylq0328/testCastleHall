package com.Web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class castleHallDiligenceCareersPage extends PageObject{

    @FindBy(xpath = "//*[@type='text']")
    private WebElement Search;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_widget_1594904478820']/div/div[2]/h2/strong")
    private WebElement Title;

    @FindBy(xpath = "//*[@id='hs_cos_wrapper_widget_1594904478820']/div/div[2]/p[2]/a")
    private WebElement ReadMore;

    public castleHallDiligenceCareersPage(WebDriver driver) {
        super(driver);
    }

    public void inputSearch(String position){
        Search.sendKeys(position);
        Search.sendKeys(Keys.ENTER);
    }

    public boolean titleContains(String jobTitle) {
        return Title.getText().contains(jobTitle);
    }

    public castleHallDiligenceCareerDetailPage getJobDetail() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        ReadMore.click();
        return new castleHallDiligenceCareerDetailPage(driver);
    }
}
