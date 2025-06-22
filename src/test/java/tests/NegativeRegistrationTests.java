package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class NegativeRegistrationTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

        @Test
        void negativeRegistrationTest () {

            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            $("#firstName").setValue("John");
            $("#lastName").setValue("Doe");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("a");
            $("#submit").click();

            $(".row").shouldNotHave(text("Thanks for submitting the form"));
        }

        @Test
        void minimumFieldsRegistrationTest () {

        }    }
}
