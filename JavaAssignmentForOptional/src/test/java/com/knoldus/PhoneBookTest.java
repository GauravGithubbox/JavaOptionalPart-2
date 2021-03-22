package com.knoldus;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    public void findPhoneNumberByNameTest1() {
        assertEquals(phoneBook.findPhoneNumberByName("Gaurav"), Optional.of("7269871259"));
    }



    @Test
    public void findPhoneByNameTestForThoseValueDoesNotExist(){
        PhoneBook obj = new PhoneBook();
        assertEquals(Optional.empty(),obj.findPhoneNumberByName("Sama"));
    }

}
