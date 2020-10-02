package com.Web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testQuestions extends FunctionalTest{

    final String url1 = "https://www.castlehalldiligence.com/";
    final String url2 = "https://www.castlehalldiligence.com/careers";
    final String url3 = "https://www.castlehalldiligence.com/news-events";

    final String errorMessage1 = "Please change your email address to continue.";
    final String errorMessage2 = "Please complete all required fields.";
    final String successMessage = "Subscribe to Updates";
    final String teamMember = "80+";
    final String fundsCover = "5,000+";
    final String countries = "6";

    @Test
    public void testQuestion1(){
        driver.get(url1);
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
        assertEquals( teamMember, whyCastleHallPage.TeamMembersText());
        assertEquals( fundsCover, whyCastleHallPage.FundsCoveredText());
        assertEquals( countries, whyCastleHallPage.CountriesText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Senior QA"})
    public void testQuestion2(String jobTitle) {
        driver.get(url2);
        driver.manage().window().maximize();
        castleHallDiligenceCareersPage careersPage = new castleHallDiligenceCareersPage(driver);
        careersPage.inputSearch( jobTitle );
        assertTrue(careersPage.titleContains( jobTitle ));
        castleHallDiligenceCareerDetailPage careerDetailPage = careersPage.getJobDetail();
        assertTrue(careerDetailPage.getApplyfor("Apply Now !"));
        assertTrue(careerDetailPage.getJobTitle( jobTitle ));
    }

    @ParameterizedTest
    @CsvSource({"t12345@gmail.com,true","T12345@gmail.com,true","t12345@gmail.com,false","T12345@gmail.com,false"})
    public void testQuestion3Success(String email, String receiveCommunication) {
        driver.get(url3);
        driver.manage().window().maximize();
        castleHallDiligenceNewEventPage newEventPage = new castleHallDiligenceNewEventPage(driver);
        newEventPage.SubmitAction(email, receiveCommunication=="true"?true:false);
        assertEquals( successMessage, newEventPage.getSuccessTitle());

    }

    @ParameterizedTest
    @CsvSource({"t,message1","t@a,message1","t@a.a,message1","'',message2"})
    public void testQuestion3Failure(String email, String errorMessage) {
        driver.get(url3);
        driver.manage().window().maximize();
        castleHallDiligenceNewEventPage newEventPage = new castleHallDiligenceNewEventPage(driver);
        newEventPage.SubmitAction(email, true);
        if (errorMessage.equals("message1"))
            assertEquals( errorMessage1, newEventPage.getErrorMessage());
        else
            assertEquals( errorMessage2, newEventPage.getErrorMessage());
    }
}
