package com.WebGUILess;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FunctionalTest {

    public  static WebClient webClient;

    @BeforeEach
    public void setUp(){

        webClient = new WebClient();
    }

    @AfterEach
    public void cleanUp(){

        webClient.close();
    }

}
