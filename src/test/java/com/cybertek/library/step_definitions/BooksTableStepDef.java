package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BooksTableStepDef {
    BooksPage booksPage=new BooksPage();
    @Then("search table should contain results matching {}")
    public void search_table_should_contain_results_matching(String book) {
    BrowserUtils.wait(1);
     List<String>allBooks=BrowserUtils.getElementsText(booksPage.allRows);
     boolean match =true;
        for (String allBook : allBooks) {
           if(!allBook.toLowerCase().contains(book)){
               match=false;
               break;
           }
        }
        assertFalse(book+" was not found in the page ",match);
    }

    @When("I edit book {}")
    public void iEditBook(String book) {
        System.out.println("book = " + book);
        BrowserUtils.waitForClickability(booksPage.search,5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();

    }
    @DataTableType
    public Book convertBooks(Map<String,String> dataTable){
        Book book = new Book(dataTable.get("name"),dataTable.get("author"),dataTable.get("year"));
        return book;
    }
    @Then("I verify book information:")
    public void i_verify_book_information(Book book) {
        System.out.println(book);
        BrowserUtils.wait(1);
        assertEquals("Book name did not match",book.getName(),booksPage.bookName.getAttribute("value"));
        assertEquals("Book author didn't match",book.getAuthor(),booksPage.author.getAttribute("value"));
        assertEquals("Book year didn't match",book.getYear(),booksPage.year.getAttribute("value"));

    }



}
