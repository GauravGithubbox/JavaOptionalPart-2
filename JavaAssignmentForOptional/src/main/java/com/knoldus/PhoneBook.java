/**
 * @Author Gaurav.
 * @Version 1.0
 *
 * */
package com.knoldus;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class PhoneBook {


    /**
     * @hashMap
     */
    private static final HashMap<String, String> contacts = new HashMap<>() {
            {
                put("Gaurav", "7269871259");
                put("Rajat", "8056635323");
                put("Mona", "9865656325");
                put("Sonu", "9987845418");
                put("Nikita", "9836154118");
            }
        };

    /**
     * @getLogger
     */
    private Logger logger = Logger.getLogger(PhoneBook.class.getName());

   // private PhoneBook phoneBook;


    /**
     * @Assigning the value.
     *
     */
    private HashMap<String, String> phoneBookEntries = contacts;

     /**
     *
     * @return phoneBookEntries
     */
    public HashMap<String, String> getPhoneBookEntries() {
        return phoneBookEntries;
    }


  // Excercise - 1

    /**
     *
     * @param name
     * @return Returns name if found else punishes.
     */
    public Optional<String> findPhoneNumberByName(final String name) {
        if (phoneBookEntries.containsKey(name)) {
            return Optional.of(phoneBookEntries.get(name));
        }
        return Optional.empty();
    }

    /**
     *
     * @param phoneNumber
     * @return Returns name if found else punishes.
     */
    public Optional<String> findNameByPhoneNumber(final String phoneNumber) {
        for (Map.Entry<String, String> entry : phoneBookEntries.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    /**
     * Overridden toString() for PhoneBook.
     * @return return phoneBookEntries
     */
    @Override
    public String toString() {
        logger.info("Hello from PhoneBook's toString method");
        return "PhoneBook{"
                +
                "phoneBookEntries=" + phoneBookEntries
                +
                '}';
    }
}
