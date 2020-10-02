package com.Web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testQuestions extends FunctionalTest{

    @Test
    public void testQuestion1(){
        driver.get("https://www.castlehalldiligence.com/");
        driver.manage().window().maximize();
        castleHallDiligenceHomePage homePage = new castleHallDiligenceHomePage(driver);
        homePage.aboutClickAction();
        assertTrue(homePage.OurStoryIsDisplayed());
        assertTrue(homePage.WhyCastleHallIsDisplayed());
        assertTrue(homePage.OurTeamIsDisplayed());
        assertTrue(homePage.CareersIsDisplayed());
        assertEquals("Our Story", homePage.OurStoryText());
        assertEquals("Why Castle Hall", homePage.WhyCastleHallText());
        assertEquals("Our Team", homePage.OurTeamText());
        assertEquals("Careers",homePage.CareersText());
        castleHallDiligenceWhyCastleHallPage whyCastleHallPage = homePage.whyCastleHallClickAction();
        assertEquals("80+",whyCastleHallPage.TeamMembersText());
        assertEquals("5,000+",whyCastleHallPage.FundsCoveredText());
        assertEquals("6",whyCastleHallPage.CountriesText());
    }

    @Test
    public void testQuestion2() {
        driver.get("https://www.castlehalldiligence.com/careers");
        driver.manage().window().maximize();
        castleHallDiligenceCareersPage careersPage = new castleHallDiligenceCareersPage(driver);
        careersPage.inputSearch("Senior QA");
        assertTrue(careersPage.titleContains("Senior QA"));
        castleHallDiligenceCareerDetailPage careerDetailPage = careersPage.getJobDetail();
        assertTrue(careerDetailPage.getApplyfor("Apply Now !"));
        assertTrue(careerDetailPage.getJobTitle("Senior QA"));
    }

    @ParameterizedTest
    @CsvSource({"t12345@gmail.com","T12345@gmail.com"})
    public void testQuestion3Success(String email) {
        driver.get("https://www.castlehalldiligence.com/news-events");
        driver.manage().window().maximize();
        castleHallDiligenceNewEventPage newEventPage = new castleHallDiligenceNewEventPage(driver);
        newEventPage.SubmitAction(email);
        assertEquals("Subscribe to Updates",newEventPage.getSuccessTitle());

    }

    @ParameterizedTest
    @CsvSource({"t","t@a","t@a.a"})
    public void testQuestion3Failure(String email) {
        driver.get("https://www.castlehalldiligence.com/news-events");
        driver.manage().window().maximize();
        castleHallDiligenceNewEventPage newEventPage = new castleHallDiligenceNewEventPage(driver);
        newEventPage.SubmitAction(email);
        assertEquals("Please change your email address to continue.",newEventPage.getErrorMessage());
    }
}
