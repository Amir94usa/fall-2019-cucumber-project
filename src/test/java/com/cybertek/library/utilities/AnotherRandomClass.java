package com.cybertek.library.utilities;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.Instant;

public class AnotherRandomClass {

    public static void main(String[] args) {
        Instant start =Instant.now();
        for (int i = 0; i <5 ; i++) {

            SomeRandomClass someRandomClass =new SomeRandomClass();
            someRandomClass.start();
        }
        Instant finish =Instant.now();
        long time = Duration.between(start,finish).toMillis();
        System.out.println("TotalTime = " + time);
    }
    @Test
    public void test1(){
        WebDriver driver= Driver.getDriver();
        driver.get("http://jqueryui.com/droppable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        BrowserUtils.wait(1);
        Actions actions =new Actions(driver);
        WebElement source =driver.findElement(By.cssSelector("div#draggable"));
        WebElement target =driver.findElement(By.cssSelector("div#droppable"));
        actions.dragAndDrop(source,target).build().perform();
        String expectedColor ="yellow";
        String actualColor =target.getCssValue("color");
        System.out.println(actualColor.toString());
    }
}
