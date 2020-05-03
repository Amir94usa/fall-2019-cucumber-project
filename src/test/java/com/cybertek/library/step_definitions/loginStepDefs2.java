package com.cybertek.library.step_definitions;


import com.cybertek.library.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefs2 {
    LoginPage loginPage =new LoginPage();

    @When("I enter username {string}")
    public void i_enter_username(String string) {
        System.out.println(string);
    }



    @When("I enter password {string}")
    public void i_enter_password(String string) {
        System.out.println(string);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {

        System.out.println("clicking sign in button");
    }
    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {
        loginPage.login(username,password);

    }
    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) {
        System.out.printf("Verifying user count "+int1);
    }
    @Then("there should be {int} {string}")
    public void there_should_be(Integer userCount, String users) {
        System.out.println("Verifying "+userCount+" "+users);

    }

}
