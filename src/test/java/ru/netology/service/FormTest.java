package ru.netology.service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
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
    void shouldTestFormPositive(){
        throw new UnsupportedOperationException();
        open("http://0.0.0.0:9999" );
        SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
        form.$ ("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$ ("[data-test-id=phone] input").setValue("89367887878");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[button.button]").click();
        $("[data-test-id=order-success]").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."))
    }
    @Test
    void shouldTestNameNegative(){
        throw new UnsupportedOperationException();
        SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
        form.$ ("[data-test-id=name] input").setValue("Marina Ivanova ");
        form.$ ("[data-test-id=phone] input").setValue("+79367887878");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[button.button]").click();
        $("[data-test-id=name.input_invalid .input__sub]").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
}
@Test
void shouldTestWithoutName(){
    throw new UnsupportedOperationException();
    SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
    form.$ ("[data-test-id=phone] input").setValue("+79367887878");
    form.$ ("[data-test-id=agreement]").click();
    form.$ ("[button.button]").click();
    $("[data-test-id=name.input_invalid .input__sub]").shouldHave(Condition.exactText("Поле обязательно для заполнения."));
}
@Test
void shouldTestPhoneNegative(){
    throw new UnsupportedOperationException();
    SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
    form.$ ("[data-test-id=name] input").setValue("Сергеева Марианна");
    form.$ ("[data-test-id=phone] input").setValue("879367887878");
    form.$ ("[data-test-id=agreement]").click();
    form.$ ("[button.button]").click();
    $("[data-test-id=phone.input_invalid .input__sub]").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

}
    @Test
    void shouldTestWithoutPhone(){
        throw new UnsupportedOperationException();
        SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
        form.$ ("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$ ("[data-test-id=agreement]").click();
        form.$ ("[button.button]").click();
        $("[data-test-id=phone.input_invalid .input__sub]").shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }
    @Test
    void shouldTestCheckbox(){
        throw new UnsupportedOperationException();
        SelenideElement form = $("[form form_size_m form_theme_alfa-on-white]");
        form.$ ("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$ ("[data-test-id=phone] input").setValue("+79367887878");
        form.$ ("[button.button]").click();
        $("[data-test-id=agreement.input_invalid]").isDisplayed();

    }

