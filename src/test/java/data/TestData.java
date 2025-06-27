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
            fakerFirstName = faker.name().firstName(),
            fakerLastName = faker.name().lastName(),
            fakerUserEmail = faker.internet().emailAddress(),
            fakerUserGender = faker.options().option("Male", "Female", "Other"),
            fakerUserPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            fakerUserSubject = faker.options().option("Maths", "Chemistry", "Accounting", "Arts",
                    "Social Studies", "Computer Sciense", "Commerce", "Economics", "English", "History",
                    "Physics", "Biology", "Hindi", "Civics"),
            fakerUserHobby = faker.options().option("Sports", "Reading", "Music"),
            fakerUserPicture = faker.options().option("images/Me.jpg",
                    "images/Still me.jpg", "images/Also me.jpg"),
            fakerUserCurrentAddress = faker.address().fullAddress(),
            fakerUserState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            randomUserCity = getRandomUserCity(fakerUserState);

            public static String getRandomUserCity(String value) {                                       //random string
                if (fakerUserState.equals("NCR"))
                    {randomUserCity = faker.options().option("Delhi", "Gurgaon", "Noida");}
                else if (fakerUserState.equals("Uttar Pradesh"))
                    {randomUserCity = faker.options().option("Agra", "Lucknow", "Merrut");}
                else if (fakerUserState.equals("Haryana"))
                    {randomUserCity = faker.options().option("Karnal", "Panipat");}
                else
                    {randomUserCity = faker.options().option("Jaipur", "Jaiselmer");};

                return randomUserCity;
            }

    }
