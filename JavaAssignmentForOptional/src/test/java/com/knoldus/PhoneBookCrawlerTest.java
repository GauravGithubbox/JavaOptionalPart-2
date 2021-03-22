package com.knoldus;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

public class PhoneBookCrawlerTest {

    public ExpectedException expectedException = ExpectedException.none();
    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBook());

    @Test
    public void findPhoneByNameAndPunishIfNothingFoundTest1() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Gaurav"), Optional.of("7269871259"));
    }


    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFoundTest2() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Phone Number is not Found");

        phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Anamika");
    }



    @Test
    public void findPhoneNumberByNameAndPrintPhoneBookIfNothingFoundTest1() {
        String Excpected = "7269871259";
        String result = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Gaurav");
        assertEquals(Excpected,result);
    }

    @Test
    public void findPhoneNumberByNameAndPrintPhoneBookIfNothingFoundTest2() {
        String Excpected = "PhoneBook{phoneBookEntries={Mona=9865656325, Sonu=9987845418, Nikita=9836154118, Gaurav=7269871259, Rajat=8056635323}}";
        String value = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Asbin");
        assertEquals(Excpected, value);
    }



    @Test
    public void findPhoneByNameAndPunishIfNothingFoundUsingStreamsTest1() {
        assertEquals(phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Nikita"), Optional.of("9836154118"));
    }

    @Test
    public void findPhoneByNameAndPunishIfNothingFoundUsingStreamsTest2() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Phone Number is not Found");

        phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Anamika");
    }


    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreamsTest1() {
        String Expcected = "9865656325";
        String value = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams("Mona");
        assertEquals(Expcected,value);
  }
@Test
  public void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreamsTest2() {
       String Expcected = "PhoneBook{phoneBookEntries={Mona=9865656325, Sonu=9987845418, Nikita=9836154118, Gaurav=7269871259, Rajat=8056635323}}";

       String value = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams("Asbin");
        assertEquals(Expcected,value);
   }


    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumberTest1() {
        String Excpected = "7269871259";
        String result = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Gaurav","72");
        assertEquals(Excpected,result);
    }
    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumberTest2() {
        String Excpected = "Nikita";
        String result = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("N","9836154118");
        assertEquals(Excpected,result);

    }


}