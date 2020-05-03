package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashboardPage;
import com.cybertek.library.pages.UserPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PageNavigation {
    DashboardPage dashBoardPage = new DashboardPage();
    UserPage userPage =new UserPage();


    @When("I click on the {string} link")

    public void i_click_on_link(String link) {
        BrowserUtils.wait(2);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        switch (link.toLowerCase()) {
            case "dashboard":
                dashBoardPage.dashboard.click();
                break;
            case "users":
                dashBoardPage.users.click();
                break;
            case "books":
                dashBoardPage.books.click();
                break;
        }
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
   //     Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        switch (page.toLowerCase()) {
            case "users":
                String actual = dashBoardPage.pageHeader.getText();
                assertEquals("User Management", actual);
                break;
            case "books":
                actual = dashBoardPage.pageHeader.getText();
                assertEquals("Book Management", actual);
                break;
        }
    }
    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        System.out.println("selected =" +selected);

      Integer actual=Integer.parseInt(userPage.getShowRecords().getFirstSelectedOption().getText());
      assertEquals(selected,actual);
    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options = " + options.size());
        System.out.println(options);
        List<WebElement>webElements =userPage.getShowRecords().getOptions();
        List<String> elementText = BrowserUtils.getElementsText(webElements);
        assertEquals(options,elementText);
    }
    @When("I select Show {int} records'")
    public void i_select_Show_records(Integer options) {
        userPage.getShowRecords().selectByVisibleText(options.toString());
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(Integer expected) {
        BrowserUtils.wait(1);
        Integer actual =userPage.allRows.size();
        Assert.assertEquals(expected,actual);
    }

    @And("I go/navigate to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case LibraryConstants.DASHBOARD:
                dashBoardPage.dashboard.click();
                break;
            case LibraryConstants.USERS:
                dashBoardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                dashBoardPage.books.click();
                break;
        }

    }


}
