package com.knoldus;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBookCrawler {

    /**
     * phoneBook.
     */
    private PhoneBook phoneBook;

    /**
     *
     *  Class constructor.
     * @param phoneBook
     */
    public PhoneBookCrawler(final PhoneBook phoneBook) {

        this.phoneBook = phoneBook;
    }
    /**
     * Implements findPhoneByName() method of PhoneBook.
     * @param name
     * @return Returns name if found else punishes
     */

    public Optional findPhoneByNameAndPunishIfNothingFound(final String name) {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.findPhoneNumberByName(name);

        return (result.isPresent()) ? Optional.of(result.get()) : Optional.of("Phone Number is not Found");
    }
 // Excercise - 3 :-

    /**
     * Implements findPhoneNumberByNameAndPrintPhoneBookIfNothingFound() method of PhoneBook.
     * @param name
     * @return Returns name if nothing found the print the whole list
     */
    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(final String name) {
        return phoneBook.findPhoneNumberByName(name).orElseGet(() -> phoneBook.toString());
    }

    /**
     * Implements findPhoneByNameAndPunishIfNothingFoundUsingStreams() method of PhoneBook.
     * @param name
     * @return Returns name if found else punishes
     */
    public Optional findPhoneByNameAndPunishIfNothingFoundUsingStreams(final String name) {
        PhoneBook phoneBook = new PhoneBook();
        Optional result = phoneBook.getPhoneBookEntries().entrySet().stream()
                .filter(e -> name.equals(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();

        return (result.isPresent()) ? Optional.of(result.get())
                : Optional.of("Phone Number is not Found");
    }

    /**
     * Implements findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreams() method of PhoneBook.
     * @param name
     * @return Returns name if nothing found the print the whole list
     */
   public String findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams(final String name) {
        PhoneBook phoneBookObj = new PhoneBook();
        Map<String, String> phoneBookMap = phoneBookObj.getPhoneBookEntries();
        String result = phoneBookMap.entrySet().stream()
                .filter(map -> name.equals(map.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.joining());
        return (result.equals("")) ? phoneBookObj.toString() : result;
    }

    /**
     * Implements findPhoneNumberByNameOrNameByPhoneNumber().
     * @param  name ,phoneNumber;
     * @return Return name if not found then return numbers
     */
    public String findPhoneNumberByNameOrNameByPhoneNumber(final String name, final String phoneNumber)
    {
        return Stream.of(phoneBook.findPhoneNumberByName(name),
                phoneBook.findNameByPhoneNumber(phoneNumber),
                phoneBook.findPhoneNumberByName("Gaurav"))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().get();
    }

    /**
     * getPhoneBook().
     * @return phoneBook
     */
    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

}
