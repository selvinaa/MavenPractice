import com.github.javafaker.Faker;
import org.apache.commons.compress.archivers.StreamingNotSupportedException;

import java.util.List;
import java.util.Scanner;

public class TestData {
    public static void main(String[] args) {
//
//        System.out.println(getRandomFirstName());
//        System.out.println(getRandomLastName());
//        System.out.println(getRandomPhoneNum());
//        System.out.println(getRandomAddress());

    }
    /*
    1. created a method which will return list of random First names
    2.  created a method which will return list of random Last names
    3.  created a method which will return list of random phone numbers
     */
    static Faker faker = new Faker();
        public static String getRandomFirstName () {
            return faker.name().firstName();
        }
        public static String getRandomLastName () {
            Faker faker = new Faker();
            return faker.name().lastName();
        }
        public static String getRandomPhoneNum () {
            return faker.phoneNumber().cellPhone();
        }
        public static String getRandomAddress () {
            return faker.address().fullAddress();
        }
    }

