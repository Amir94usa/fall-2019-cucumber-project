package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static org.junit.Assert.*;


public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String url = null;

        if (System.getProperty("env") != null) {

            url = ConfigurationReader.getProperties(System.getProperty("env")+"_url");
        } else {
            url = ConfigurationReader.getProperties("url");
        }


        System.out.println("In login page");
        String utl = ConfigurationReader.getProperties("url");
        Driver.getDriver().get(utl);

    }

    @When("I login as a librarian user")
    public void i_login_as_a_admin_user() {
        System.out.println("As a librarian");
        String username =ConfigurationReader.getProperties("librarian_email");
        String password =ConfigurationReader.getProperties("librarian_password");
        loginPage.login(username,password);
    }


    @When("I login as a student user")
    public void i_login_as_a_student() {
        System.out.println("Logging in as a student");

        String email = ConfigurationReader.getProperties("student_email");

        String password = ConfigurationReader.getProperties("student_password");

        loginPage.login(email, password);
    }
    @When("I login as a admin")
    public void i_login_as_a_admin() {
        System.out.println("Login as a admin");

    }


        @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
            WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
            wait.until(ExpectedConditions.urlContains("dashboard"));
        assertTrue(Driver.getDriver().getCurrentUrl().endsWith("dashboard"));
    }
    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String,String> credentials) {

        loginPage.login(credentials.get("email"),credentials.get("password"));
    }


    @Then("I login to application as a {word}")
    public void i_login_to_application_as_a(String userType) throws Exception {
        if(userType.equalsIgnoreCase(LibraryConstants.STUDENT)){
            String email = ConfigurationReader.getProperties("student_email");
            String password = ConfigurationReader.getProperties("student_password");
            loginPage.login(email, password);
        }else if(userType.equalsIgnoreCase(LibraryConstants.LIBRARIAN)){
            String username =ConfigurationReader.getProperties("librarian_email");
            String password =ConfigurationReader.getProperties("librarian_password");
            loginPage.login(username,password);
        }else {
            throw new Exception("Wrong user type provided "+userType);
        }

    }
}
