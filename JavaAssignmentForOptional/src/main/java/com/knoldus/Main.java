package com.knoldus;

import java.util.Optional;
import java.util.logging.Logger;


public class Main {
    public static void main(String args[]) {
        PhoneBook object1 = new PhoneBook();
        PhoneBookCrawler object2 = new PhoneBookCrawler(new PhoneBook());

        Logger logger = Logger.getLogger(Main.class.getName());

// Exercise 1:
// Implement findPhoneByName in PhoneBook class that returns an optional. (No streams)


        logger.info("-----------------------Excercise - 1 ----------------------------");

       Optional result = object1.findPhoneNumberByName("Gaurav");

        logger.info(String.valueOf(result.get()));




        logger.info("-----------------------Excercise - 2 ----------------------------");

// Exercise 2:
// Implement findPhoneByNameAndPunishIfNothingFound in PhoneBookCrawler that uses the implementation from exercise 1

        Optional result2 = object2.findPhoneByNameAndPunishIfNothingFound("Rajat");
        logger.info(String.valueOf(result2.get()));

        logger.info("IF Nothing is found  :");

        Optional result3 = object2.findPhoneByNameAndPunishIfNothingFound("Aman");
        logger.info(String.valueOf(result3.get()));


// Exercise 3:
// Implement findPhoneByNameAndPrintPhoneBookIfNothingFound in PhoneBookCrawler that uses the implementation from exercise 1
//

        logger.info("-----------------------Excercise - 3 ----------------------------");



        String result4 = object2.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Nikita");
        logger.info(String.valueOf(result4));

        logger.info("IF Nothing found :");

        String result5 = object2.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("priya");
        logger.info(String.valueOf(result5));


//        Exercise 5
//        Can you reimplement exercise 2 using streams instead of using PhoneBook's findPhoneNumberByName

        logger.info("-----------------------Excercise - 5 ----------------------------");



        Optional result6 = object2.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Sonu");
        logger.info(String.valueOf(result6.get()));

        logger.info("IF Nothing found :");

        Optional result7 = object2.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Suraj");
        logger.info(String.valueOf(result7.get()));

// Exercise 6
// Can you reimplement exercise 3 using streams instead of using PhoneBook's findPhoneNumberByName

        logger.info("-----------------------Excercise - 6 ----------------------------");


        String result8 = object2.findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams("Mona");
        logger.info(String.valueOf(result8));

        logger.info("IF Nothing found :");

        String result9 = object2.findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams("Saumya");
        logger.info(String.valueOf(result9));


//        Exercise 7
//        Implement findNameByPhoneNumber in PhoneBook class that returns an optional.
//        Implement findPhoneNumberByNameOrNameByPhoneNumber in PhoneBookCrawler class. First search the phone book by name.
//        If that returns nothing search the phone book by phone number.

        logger.info("-----------------------Excercise - 7 ----------------------------");


        String result10 = object2.findPhoneNumberByNameOrNameByPhoneNumber("Nikit","9836154118");
         if(result10 != null) {
                 logger.info(result10); }
        else {
            logger.info("Not Found!");
        }
    }
}
