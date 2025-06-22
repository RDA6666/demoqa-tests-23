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
            $("#userEmail").setValue("1111");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("89841658948");
            $("#submit").click();

            $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("John Doe"));
            $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("1111"));
            $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
            $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("89841658948"));

        }
}
