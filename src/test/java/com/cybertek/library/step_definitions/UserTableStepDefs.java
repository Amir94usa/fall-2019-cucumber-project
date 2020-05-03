package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.bs.I;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTableStepDefs {
    UserPage userPage =new UserPage();
    @When("I search for {string}")
    public void i_search_for(String searchString) {
        BrowserUtils.waitForClickability(userPage.search,5);
        userPage.search.sendKeys(searchString);

    }
    @Then("table should contain row with {string}")
    public void table_should_contain_row_with(String string) {
        int size= userPage.allUserIds.size();
        BrowserUtils.wait(1);
        for (int i = 0; i <size ; i++) {
            String id =userPage.allUserIds.get(i).getText().toLowerCase();
            String name= userPage.allFullNames.get(i).getText().toLowerCase();
            String email= userPage.allEmails.get(i).getText().toLowerCase();
            System.out.println("Row "+(i+1));
            System.out.println(id+"\t"+name+"\t"+email);
            boolean found =id.contains(string)||name.contains(string)||email.contains(string);
           assertTrue("test was supposed to get records wich contains test ",found);


        }
    }
    @Then("table should have following columns names:")
    public void table_should_have_following_columns_names(List<String> expectedColumnNames) {
        System.out.println(expectedColumnNames);
      List<String> actualColumnsNames=  BrowserUtils.getElementsText(userPage.columnsNames);
        System.out.println(actualColumnsNames);
        assertEquals(expectedColumnNames,actualColumnsNames);

    }
    @Then("table should contain this data")
    public void table_should_contain_this_data(Map<String,String> user) {
        System.out.println(user.entrySet());
        String name = user.get("Full Name");
        String email = user.get("Email");
        String Id = user.get("User Id");
        System.out.println("ID = " + Id);
        System.out.println("email = " + email);
        System.out.println("name = " + name);
        BrowserUtils.wait(1);
        List<WebElement> allRows = userPage.allRows;

        List<String> allRowsTxt = BrowserUtils.getElementsText(allRows);
        boolean found = true;
        for (String row : allRowsTxt) {
            System.out.println("row = " + row);
            found = row.contains(Id) && row.contains(name) && row.contains(email);
            if (found) {
                break;
            }
        }
        assertTrue(user + " was not found", found);

    }
}
