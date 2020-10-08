package com.WebGUILess;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.WebGUILess.FunctionalTest.webClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSamples extends FunctionalTest {

    @Test
    public void testHtmlUnit() throws Exception {

        HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
        String expected = "HtmlUnit " +  (char)(int) Integer.valueOf("2013",16) +  " Welcome to HtmlUnit";
        //String expected = "HtmlUnit " +  (char)8211 +  " Welcome to HtmlUnit";
        assertEquals(expected, page.getTitleText() );


    }
}
