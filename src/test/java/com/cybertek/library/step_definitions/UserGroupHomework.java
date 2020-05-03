package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserGroupHomework {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage =new DashboardPage();
    UserPage userPage =new UserPage();

    @Given("I access Users page as a librarian")
    public void i_access_Users_page_as_a_librarian() {
        String url = ConfigurationReader.getProperties("url");

        Driver.getDriver().get(url);

                loginPage.login(ConfigurationReader.getProperties("librarian_email"),
                        ConfigurationReader.getProperties("librarian_password"));

        dashboardPage.users.click();
    }

    @Then("User group default value should be {string}")
    public void user_group_default_value_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Groups columns in user table should only contain {string}")
    public void groups_columns_in_user_table_should_only_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Given("I select Show {int} records")
    public void i_select_Show_records(Integer int1) {
        userPage.getShowRecords().selectByVisibleText(int1.toString());
    }

    @When("I select User group {string}")
    public void i_select_User_group(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
