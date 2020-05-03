package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class AddUsersHomework {
    UserPage userPage= new UserPage();
    Faker faker= new Faker();
    Random random =new Random();
    String email=faker.name().firstName()+random.nextInt(90)+"@gmail.com";
    String fullname= faker.name().fullName();
    String password=faker.number().digits(6);
    String address=faker.address().fullAddress();
    WebDriverWait wait =new WebDriverWait(Driver.getDriver(),5);
    LoginPage loginPage =new LoginPage();
    DashboardPage dashboardPage =new DashboardPage();





    @Then("start date should be today's date")
    public void start_date_should_be_today_s_date() {
        String startDate = userPage.startDate.getAttribute("value");

        String currentDate = LocalDate.now().toString();

        Assert.assertEquals(startDate,currentDate);

    }

    @Then("end date should be one month from today")
    public void end_date_should_be_one_month_from_today() {
        String endData =userPage.endDate.getAttribute("value");
        String startDate =userPage.startDate.getAttribute("value");
        System.out.println( BrowserUtils.checkMonth(startDate,endData));

    }



    @Given("I enter new user information with random email")
    public void i_enter_new_user_information_with_random_email() {
        userPage.fullname.sendKeys(fullname);
        userPage.password.sendKeys(password);
        userPage.address.sendKeys(address);

       userPage.email.sendKeys(email);
    }

    @When("I click the Close link")
    public void i_click_the_Close_link() {
        userPage.closeButton.click();
    }

    @Then("the users table should not contain user with that email")
    public void the_users_table_should_not_contain_user_with_that_email() {
        userPage.search.sendKeys(email);
        Driver.getDriver().findElement(By.className("dataTables_empty")).isDisplayed();
    }



    @Given("I click on Add User")
    public void i_click_on_Add_User() {
        wait.until(ExpectedConditions.elementToBeClickable(userPage.addUsers));
        userPage.addUsers.click();
    }

    @When("I save new user information with random email")
    public void i_save_new_user_information_with_random_email() {
        userPage.fullname.sendKeys(fullname);
        userPage.password.sendKeys(password);
        userPage.address.sendKeys(address);

        userPage.email.sendKeys(email);
        userPage.saveChangesButton.click();


    }

    @When("the users table must contain the correct user information")
    public void the_users_table_must_contain_the_correct_user_information() {
        List<WebElement> allRows=userPage.allRows;
        BrowserUtils.wait(1);
        List<String> allRowsText=BrowserUtils.getElementsText(allRows);
        boolean found = false;
        for (String element : allRowsText) {
            found= element.contains(email)&&element.contains(fullname);
            if(found){
                break;
            }
        }
        assertTrue(found);
    }
    @When("I try to add new with the same email")
    public void i_try_to_add_new_with_the_same_email() {
        userPage.fullname.sendKeys(faker.name().fullName());
        userPage.password.sendKeys(faker.number().digits(6));
        userPage.address.sendKeys(faker.address().fullAddress());

        userPage.email.sendKeys(email);
        userPage.saveChangesButton.click();

    }

    @Then("Add User dialog should still be open")
    public void add_User_dialog_should_still_be_open() {

    }


    @Given("I access Users page as a student")
    public void iAccessUsersPageAsAStudent() {
        String url = ConfigurationReader.getProperties("url");

        Driver.getDriver().get(url);

        loginPage.login(ConfigurationReader.getProperties("student_email"),
                ConfigurationReader.getProperties("student_password"));

        dashboardPage.users.click();
    }
}
