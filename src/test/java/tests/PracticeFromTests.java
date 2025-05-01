package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PracticeFromTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
void fillFormTest () {
        open("/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe6659@mail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("+49841658948");
        $("#dateOfBirthInput").click();

        $("#submit").click();
    }
}


