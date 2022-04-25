package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTableHwSteps {
    UserPage userPage = new UserPage();
    Random random = new Random();
    Faker faker = new Faker();

    @When("I search for any valid email")
    public void i_search_for_any_valid_email() {
        List<String> allEmail = BrowserUtils.getElementsText(userPage.allEmails);
        String randomEmail = allEmail.get(random.nextInt(allEmail.size()));
        userPage.search.sendKeys(randomEmail);

    }

    @When("I search for any invalid email")
    public void i_search_for_any_invalid_email() {
        userPage.search.sendKeys(faker.name().fullName() + faker.number().digit() + ".com");
fghfgh
    }

    @Then("the users table must display message {string}")
    public void the_users_table_must_display_message(String expected) {
        String actual = Driver.getDriver().findElement(By.className("dataTables_empty")).getText();
        assertEquals(expected, actual);
    }

    @Then("users table should be sorted by {string} in {string} order")

    public void users_table_should_be_sorted_by_in_order(String columnName, String order) {
        
        switch (columnName.toLowerCase()) {
            case "user id":
                switch (order.toLowerCase()) {
                    case "ascending":
                        BrowserUtils.wait(1);
                        Assert.assertTrue(BrowserUtils.isSortedAscendingOrder(userPage.allUserIds));
                        break;
                    case "descending":
                        BrowserUtils.wait(1);
                        Assert.assertTrue(BrowserUtils.isSortedDescendingOrder(userPage.allUserIds));
                        break;
                }
                break;

            case "email":
                switch (order.toLowerCase()) {
                    case "ascending":
                        BrowserUtils.wait(1);
                        String expected ="sorting_asc";
                        Assert.assertEquals(expected,userPage.emailColumn.getAttribute("class"));
                        break;
                    case "descending":
                        BrowserUtils.wait(1);
                        expected ="sorting_desc";
                        Assert.assertEquals(expected,userPage.emailColumn.getAttribute("class"));
                        break;
                }
                break;
        }
    }

    @When("I click on the {string} column")

    public void i_click_on_the_column(String columnName) {

        switch (columnName.toLowerCase()) {

            case "user id":

                BrowserUtils.wait(1);

                userPage.userIdColumn.click();

                break;

            case "email":

                BrowserUtils.wait(1);

                userPage.emailColumn.click();

                break;

        }

    }


}

