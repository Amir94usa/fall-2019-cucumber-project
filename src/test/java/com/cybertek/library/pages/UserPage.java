package com.cybertek.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserPage extends PageBase {
    @FindBy(name = "tbl_users_length")
    public WebElement showRecords;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;
    @FindBy(tagName = "input")
    public WebElement search;
   @FindBy(xpath = "//table/tbody/tr/td[2]")
   public List<WebElement> allUserIds;
   @FindBy(xpath = "//table/tbody/tr/td[3]")
   public List<WebElement> allFullNames;
    @FindBy(xpath = "//table/tbody/tr/td[4]")
   public List<WebElement> allEmails;
    @FindBy(tagName = "th")
    public List<WebElement> columnsNames;
    @FindBy(css = "a.btn-lg")
    public WebElement addUsers;
    @FindBy(name = "full_name")
    public WebElement fullname;
    @FindBy(name = "email")
    public WebElement email;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(id = "address")
    public WebElement address;
    @FindBy(name = "start_date")
    public WebElement startDate;
    @FindBy(name = "end_date")
    public WebElement endDate;
    @FindBy(xpath = "//button[@type='cancel']")
    public WebElement closeButton;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesButton;
    @FindBy(className = "dataTables_empty")
    public WebElement EmptyTable;
    @FindBy(xpath = "//th[@data-name='id']")
    public WebElement userIdColumn;
    @FindBy(xpath = "//th[@data-name='email']")
    public WebElement emailColumn;



    public Select getShowRecords(){
        return new Select(showRecords);
    }
}
