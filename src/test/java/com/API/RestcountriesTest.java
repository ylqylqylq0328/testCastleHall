package com.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestcountriesTest {

    final String endpoint = "https://restcountries.eu/rest/v2/capital/";

    /*
    Successful Test Case,
    Check Status should be HttpURLConnection.HTTP_OK,
    And Verify Content.
    Also verify case insensitive.
     */
    @ParameterizedTest
    @ValueSource(strings = {"beijing","Beijing","BEIJING"})
    public void testSuccess(String capital ) throws IOException {
        final HttpUtils.HttpResponse response = HttpUtils.getHttpContent( endpoint + capital );
        assertEquals(HttpURLConnection.HTTP_OK,response.getResponseCode());

        ObjectMapper mapper = new ObjectMapper();
        Capitals expectedCapitals = mapper.readValue(getFileFromResources("BeijingResponse.json"), Capitals.class);
        List<Capitals> actuallyCapital =  getLocations(response.getContent(), Capitals.class);
        assertEquals(1, actuallyCapital.size());
        Capitals actuallyCapitals = actuallyCapital.get(0);

        assertAll(
                () -> assertEquals(expectedCapitals.getName(),actuallyCapitals.getName()),
                () -> assertEquals(expectedCapitals.getAlpha2Code(), actuallyCapitals.getAlpha2Code()),
                () -> assertEquals(expectedCapitals.getAlpha3Code(), actuallyCapitals.getAlpha3Code()),
                () -> assertEquals(expectedCapitals.getCapital(), actuallyCapitals.getCapital()),
                () -> assertEquals(expectedCapitals.getRegion(), actuallyCapitals.getRegion()),
                () -> assertEquals(expectedCapitals.getSubregion(), actuallyCapitals.getSubregion()),
                () -> assertEquals(expectedCapitals.getPopulation(), actuallyCapitals.getPopulation()),
                () -> assertEquals(expectedCapitals.getDemonym(), actuallyCapitals.getDemonym()),
                () -> assertEquals(expectedCapitals.getArea(), actuallyCapitals.getArea()),
                () -> assertEquals(expectedCapitals.getGini(), actuallyCapitals.getGini()),
                () -> assertEquals(expectedCapitals.getNumericCode(), actuallyCapitals.getNumericCode()),
                () -> assertEquals(expectedCapitals.getFlag(), actuallyCapitals.getFlag()),
                () -> assertEquals(expectedCapitals.getCioc(), actuallyCapitals.getCioc())
         );

        assertEquals(expectedCapitals.getTopLevelDomain().size(), actuallyCapitals.getTopLevelDomain().size());
        if ( expectedCapitals.getTopLevelDomain().size() > 0)
            for (int i = 0; i < expectedCapitals.getTopLevelDomain().size(); i ++ )
                assertEquals(expectedCapitals.getTopLevelDomain().get(i), actuallyCapitals.getTopLevelDomain().get(i));

        assertEquals(expectedCapitals.getCallingCodes().size(), actuallyCapitals.getCallingCodes().size());
        if ( expectedCapitals.getCallingCodes().size() > 0)
            for (int i = 0; i < expectedCapitals.getCallingCodes().size(); i ++ )
                assertEquals(expectedCapitals.getCallingCodes().get(i), actuallyCapitals.getCallingCodes().get(i));

        assertEquals(expectedCapitals.getBorders().size(), actuallyCapitals.getBorders().size());
        if ( expectedCapitals.getBorders().size() > 0)
            for (int i = 0; i < expectedCapitals.getBorders().size(); i ++ )
                assertEquals(expectedCapitals.getBorders().get(i), actuallyCapitals.getBorders().get(i));

        assertEquals(expectedCapitals.getTimezones().size(), actuallyCapitals.getTimezones().size());
        if ( expectedCapitals.getTimezones().size() > 0)
            for (int i = 0; i < expectedCapitals.getTimezones().size(); i ++ )
                assertEquals(expectedCapitals.getTimezones().get(i), actuallyCapitals.getTimezones().get(i));

        assertEquals(expectedCapitals.getRegionalBlocs().size(), actuallyCapitals.getRegionalBlocs().size());
        if ( expectedCapitals.getRegionalBlocs().size() > 0)
            for (int i = 0; i < expectedCapitals.getRegionalBlocs().size(); i ++ )
                assertEquals(expectedCapitals.getRegionalBlocs().get(i), actuallyCapitals.getRegionalBlocs().get(i));

        Capitals.translationsClass  expectedCapitalsTranslations = expectedCapitals.getTranslations();
        Capitals.translationsClass  actuallyCapitalsTranslations = actuallyCapitals.getTranslations();

        assertAll(
                () -> assertEquals(expectedCapitalsTranslations.getDe(),actuallyCapitalsTranslations.getDe()),
                () -> assertEquals(expectedCapitalsTranslations.getEs(),actuallyCapitalsTranslations.getEs()),
                () -> assertEquals(expectedCapitalsTranslations.getFr(),actuallyCapitalsTranslations.getFr()),
                () -> assertEquals(expectedCapitalsTranslations.getIt(),actuallyCapitalsTranslations.getIt()),
                () -> assertEquals(expectedCapitalsTranslations.getBr(),actuallyCapitalsTranslations.getBr()),
                () -> assertEquals(expectedCapitalsTranslations.getPt(),actuallyCapitalsTranslations.getPt()),
                () -> assertEquals(expectedCapitalsTranslations.getNl(),actuallyCapitalsTranslations.getNl()),
                () -> assertEquals(expectedCapitalsTranslations.getHr(),actuallyCapitalsTranslations.getHr())
        );

        Iterator<Capitals.currenciesClass> expectedCapitalCurrencies = expectedCapitals.getCurrencies().iterator();
        Iterator<Capitals.currenciesClass> actuallyCapitalCurrencies = actuallyCapitals.getCurrencies().iterator();

        while (expectedCapitalCurrencies.hasNext() && actuallyCapitalCurrencies.hasNext()) {
            Capitals.currenciesClass expectedEachCapitalCurrencies = expectedCapitalCurrencies.next();
            Capitals.currenciesClass actuallyEachCapitalCurrencies = actuallyCapitalCurrencies.next();
            assertAll(
                    () -> assertEquals(expectedEachCapitalCurrencies.getCode(),actuallyEachCapitalCurrencies.getCode()),
                    () -> assertEquals(expectedEachCapitalCurrencies.getName(),actuallyEachCapitalCurrencies.getName())
            );
        };

        Iterator<Capitals.languagesClass> expectedCapitalLanguages = expectedCapitals.getLanguages().iterator();
        Iterator<Capitals.languagesClass> actuallyCapitalLanguages = actuallyCapitals.getLanguages().iterator();

        while (expectedCapitalLanguages.hasNext() && actuallyCapitalLanguages.hasNext()) {
            Capitals.languagesClass expectedEachCapitalLanguage = expectedCapitalLanguages.next();
            Capitals.languagesClass actuallyEachCapitalLanguage = actuallyCapitalLanguages.next();
            assertAll(
                    () -> assertEquals(expectedEachCapitalLanguage.getIso639_1(),actuallyEachCapitalLanguage.getIso639_1()),
                    () -> assertEquals(expectedEachCapitalLanguage.getIso639_2(),actuallyEachCapitalLanguage.getIso639_2()),
                    () -> assertEquals(expectedEachCapitalLanguage.getName(),actuallyEachCapitalLanguage.getName())
            );
        };

    }

    /*
    Failed Test case
    1 Not existed Capital;
    2 Specical Character;
    3 Number Character
     */
    @ParameterizedTest
    @ValueSource(strings = {"Beijingg","!","123"})
    public void testFailed(String capital) throws IOException {
        final HttpUtils.HttpResponse response = HttpUtils.getHttpContent( endpoint + capital );
        assertEquals(HttpURLConnection.HTTP_NOT_FOUND,response.getResponseCode());

    }

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Beijingg","!","123"})
    public void testFailedRestAssured(String capital) {
        given().baseUri(endpoint).when().get(capital).then().statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    @ParameterizedTest
    @ValueSource(strings = {"beijing","Beijing","BEIJING"})
    public void testSuccessRestAssured(String capital ) throws IOException {
        Response response = given().baseUri("https://restcountries.eu/rest/v2/capital/")
                .when().get(capital);
        assertEquals(HttpURLConnection.HTTP_OK,response.getStatusCode());
        //System.out.println(response.getBody().asString());

        ObjectMapper mapper = new ObjectMapper();
        List<Capitals> actuallyCapital =  getLocations(response.getBody().asString(), Capitals.class);
        Capitals expectedCapitals = mapper.readValue(getFileFromResources("BeijingResponse.json"), Capitals.class);
        assertEquals(1, actuallyCapital.size());
        Capitals actuallyCapitals = actuallyCapital.get(0);
        assertAll(
                () -> assertEquals(expectedCapitals.getName(),actuallyCapitals.getName()),
                () -> assertEquals(expectedCapitals.getAlpha2Code(), actuallyCapitals.getAlpha2Code()),
                () -> assertEquals(expectedCapitals.getAlpha3Code(), actuallyCapitals.getAlpha3Code()),
                () -> assertEquals(expectedCapitals.getCapital(), actuallyCapitals.getCapital()),
                () -> assertEquals(expectedCapitals.getRegion(), actuallyCapitals.getRegion()),
                () -> assertEquals(expectedCapitals.getSubregion(), actuallyCapitals.getSubregion()),
                () -> assertEquals(expectedCapitals.getPopulation(), actuallyCapitals.getPopulation()),
                () -> assertEquals(expectedCapitals.getDemonym(), actuallyCapitals.getDemonym()),
                () -> assertEquals(expectedCapitals.getArea(), actuallyCapitals.getArea()),
                () -> assertEquals(expectedCapitals.getGini(), actuallyCapitals.getGini()),
                () -> assertEquals(expectedCapitals.getNumericCode(), actuallyCapitals.getNumericCode()),
                () -> assertEquals(expectedCapitals.getFlag(), actuallyCapitals.getFlag()),
                () -> assertEquals(expectedCapitals.getCioc(), actuallyCapitals.getCioc())
        );

        assertEquals(expectedCapitals.getTopLevelDomain().size(), actuallyCapitals.getTopLevelDomain().size());
        if ( expectedCapitals.getTopLevelDomain().size() > 0)
            for (int i = 0; i < expectedCapitals.getTopLevelDomain().size(); i ++ )
                assertEquals(expectedCapitals.getTopLevelDomain().get(i), actuallyCapitals.getTopLevelDomain().get(i));

        assertEquals(expectedCapitals.getCallingCodes().size(), actuallyCapitals.getCallingCodes().size());
        if ( expectedCapitals.getCallingCodes().size() > 0)
            for (int i = 0; i < expectedCapitals.getCallingCodes().size(); i ++ )
                assertEquals(expectedCapitals.getCallingCodes().get(i), actuallyCapitals.getCallingCodes().get(i));

        assertEquals(expectedCapitals.getBorders().size(), actuallyCapitals.getBorders().size());
        if ( expectedCapitals.getBorders().size() > 0)
            for (int i = 0; i < expectedCapitals.getBorders().size(); i ++ )
                assertEquals(expectedCapitals.getBorders().get(i), actuallyCapitals.getBorders().get(i));

        assertEquals(expectedCapitals.getTimezones().size(), actuallyCapitals.getTimezones().size());
        if ( expectedCapitals.getTimezones().size() > 0)
            for (int i = 0; i < expectedCapitals.getTimezones().size(); i ++ )
                assertEquals(expectedCapitals.getTimezones().get(i), actuallyCapitals.getTimezones().get(i));

        assertEquals(expectedCapitals.getRegionalBlocs().size(), actuallyCapitals.getRegionalBlocs().size());
        if ( expectedCapitals.getRegionalBlocs().size() > 0)
            for (int i = 0; i < expectedCapitals.getRegionalBlocs().size(); i ++ )
                assertEquals(expectedCapitals.getRegionalBlocs().get(i), actuallyCapitals.getRegionalBlocs().get(i));

        Capitals.translationsClass  expectedCapitalsTranslations = expectedCapitals.getTranslations();
        Capitals.translationsClass  actuallyCapitalsTranslations = actuallyCapitals.getTranslations();

        assertAll(
                () -> assertEquals(expectedCapitalsTranslations.getDe(),actuallyCapitalsTranslations.getDe()),
                () -> assertEquals(expectedCapitalsTranslations.getEs(),actuallyCapitalsTranslations.getEs()),
                () -> assertEquals(expectedCapitalsTranslations.getFr(),actuallyCapitalsTranslations.getFr()),
                () -> assertEquals(expectedCapitalsTranslations.getIt(),actuallyCapitalsTranslations.getIt()),
                () -> assertEquals(expectedCapitalsTranslations.getBr(),actuallyCapitalsTranslations.getBr()),
                () -> assertEquals(expectedCapitalsTranslations.getPt(),actuallyCapitalsTranslations.getPt()),
                () -> assertEquals(expectedCapitalsTranslations.getNl(),actuallyCapitalsTranslations.getNl()),
                () -> assertEquals(expectedCapitalsTranslations.getHr(),actuallyCapitalsTranslations.getHr())
        );

        Iterator<Capitals.currenciesClass> expectedCapitalCurrencies = expectedCapitals.getCurrencies().iterator();
        Iterator<Capitals.currenciesClass> actuallyCapitalCurrencies = actuallyCapitals.getCurrencies().iterator();

        while (expectedCapitalCurrencies.hasNext() && actuallyCapitalCurrencies.hasNext()) {
            Capitals.currenciesClass expectedEachCapitalCurrencies = expectedCapitalCurrencies.next();
            Capitals.currenciesClass actuallyEachCapitalCurrencies = actuallyCapitalCurrencies.next();
            assertAll(
                    () -> assertEquals(expectedEachCapitalCurrencies.getCode(),actuallyEachCapitalCurrencies.getCode()),
                    () -> assertEquals(expectedEachCapitalCurrencies.getName(),actuallyEachCapitalCurrencies.getName())
            );
        };

        Iterator<Capitals.languagesClass> expectedCapitalLanguages = expectedCapitals.getLanguages().iterator();
        Iterator<Capitals.languagesClass> actuallyCapitalLanguages = actuallyCapitals.getLanguages().iterator();

        while (expectedCapitalLanguages.hasNext() && actuallyCapitalLanguages.hasNext()) {
            Capitals.languagesClass expectedEachCapitalLanguage = expectedCapitalLanguages.next();
            Capitals.languagesClass actuallyEachCapitalLanguage = actuallyCapitalLanguages.next();
            assertAll(
                    () -> assertEquals(expectedEachCapitalLanguage.getIso639_1(),actuallyEachCapitalLanguage.getIso639_1()),
                    () -> assertEquals(expectedEachCapitalLanguage.getIso639_2(),actuallyEachCapitalLanguage.getIso639_2()),
                    () -> assertEquals(expectedEachCapitalLanguage.getName(),actuallyEachCapitalLanguage.getName())
            );
        };


    }

    public static <T> List<T> getLocations(String inputStream,  Class<T> valueClass ) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            CollectionType collectionType = typeFactory.constructCollectionType(
                    List.class, valueClass);
            return objectMapper.readValue(inputStream, collectionType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
