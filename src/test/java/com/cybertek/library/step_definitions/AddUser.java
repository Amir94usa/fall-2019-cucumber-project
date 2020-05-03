package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AddUser {
    UserPage userPage= new UserPage();
    @When("dialog fields must have matching placeholder:")
    public void dialog_fields_must_have_matching_placeholder(Map<String,String> fields) {
        for (String key : fields.keySet()) {
            System.out.println("key = " + key);
            System.out.println("value ="+fields.get(key));
            System.out.println();
        }
        String expectedName= fields.get("full name");
        String actualFullname=userPage.fullname.getAttribute("placeholder");
        assertEquals(expectedName,actualFullname);
        String expectedEmail= fields.get("email");
        String actualEmail=userPage.email.getAttribute("placeholder");
        assertEquals(expectedEmail,actualEmail);
        String expectedPassword= fields.get("password");
        String actualPassword=userPage.password.getAttribute("placeholder");
        assertEquals(expectedPassword,actualPassword);

        String actualAddress=userPage.address.getAttribute("placeholder");
        assertEquals("Address should be empty ","",actualAddress);

    }
    @Given("I click on Add Users")
    public void i_click_on_Add_User() {
        userPage.addUsers.click();
    }
}
