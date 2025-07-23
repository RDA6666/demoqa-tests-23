package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectsTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @DisplayName("Позитивный тест с применением методов POM")
    @Tag("Web-test")
    @Test
    void fullRegistrationFormTest() {
        registrationFormPage.openRegistrationFormPage()
                .setFirstName()
                .setLastName()
                .setEmail();
    }
}
