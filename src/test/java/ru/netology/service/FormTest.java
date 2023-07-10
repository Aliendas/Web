package ru.netology.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    private WebDriver driver;

    /*@BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();*/
    @AfterEach
    void tearDown(){
        driver.quit();
        driver=null;
    }
    @Test
    void shouldTestName(){
        throw new UnsupportedOperationException();
        open("http://0.0.0.0:9999" );

    }
}
