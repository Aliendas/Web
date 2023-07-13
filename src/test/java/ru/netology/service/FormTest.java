package ru.netology.service;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Durations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    private WebDriver driver;

    @BeforeEach
            public void beforeEach(){

        open("http://localhost:9999");
    }

    @Test
    void shouldTestFormPositive() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$("[data-test-id=phone] input").setValue("+79367887878");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id='order-success']").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."), Duration.ofSeconds(10));
    }

    @Test
    void shouldTestNameNegative() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Marina Ivanova ");
        form.$("[data-test-id=phone] input").setValue("+79367887878");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldTestWithoutName() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=phone] input").setValue("+79367887878");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldTestPhoneNegative() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$("[data-test-id=phone] input").setValue("879367887878");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));

    }

    @Test
    void shouldTestWithoutPhone() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$("[data-test-id=agreement]").click();
        form.$("button.button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));

    }

    @Test
    void shouldTestCheckbox() {
        SelenideElement form = $("form.form");
        form.$("[data-test-id=name] input").setValue("Сергеева Марианна");
        form.$("[data-test-id=phone] input").setValue("+79367887878");
        form.$("button.button").click();
        $("[data-test-id='agreement'].input_invalid").shouldBe(Condition.visible);

    }
}

