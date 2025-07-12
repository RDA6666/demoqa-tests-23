package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectsTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    public void fullRegistrationFormTest() {
        registrationFormPage.openRegistrationFormPage();
}