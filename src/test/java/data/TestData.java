package data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Optional;

public class TestData {
    public static String
            firstName = "Dmitry",
            lastName = "Ryzhov",
            userEmail = "dmitryryzhov@mail.com",
            userPhoneNumber = "1234567890",
            userCurrentAddress = "Penza";

    static Faker faker = new Faker(new Locale("en-US"));                          //random test data generation
    public static String
            randomFirstName = faker.name().firstName(),
            randomLastName = faker.name().lastName(),
            randomUserEmail = faker.internet().emailAddress(),
            randomUserGender = faker.options().option("Male", "Female", "Other"),
            randomUserPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            randomUserSubject = faker.options().option("Maths", "Chemistry", "Accounting", "Arts",
                    "Social Studies", "Computer Sciense", "Commerce", "Economics", "English", "History",
                    "Physics", "Biology", "Hindi", "Civics"),
            randomUserHobby = faker.options().option("Sports", "Reading", "Music"),
            randomUserCurrentAddress = faker.address().fullAddress(),
            randomUserState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomUserCity = getRandomCity();

    public String getRandomCity(String value) {
        if (randomUserState.equals("NCR")) randomUserCity = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (randomUserState.equals("Uttar Pradesh"))
            randomUserCity = faker.options().option("Agra", "Lucknow", "Merrut");
        if (randomUserState.equals("Haryana")) randomUserCity = faker.options().option("Karnal", "Panipat");
        if (randomUserState.equals("Rajasthan")) randomUserCity = faker.options().option("Jaipur", "Jaiselmer");

        return randomUserCity;
    }
}
