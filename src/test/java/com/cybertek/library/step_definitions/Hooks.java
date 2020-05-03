package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before(order = 0)
    public void setUpScenario() {

        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

//    @Before(value = "@db", order = 1)
//    public void connect() {
//        System.out.println("Connecting to db");
//    }

    @After
    public void tearDownScenario(Scenario scenario) {
      scenario.write("scenario info "+scenario.getName());
       if( scenario.isFailed()){
           //take screen shot using selenium
          byte[]screenshot= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           //attach to report
           scenario.embed(screenshot,"image/png",scenario.getName());
       }
       // BrowserUtils.wait(2);
        Driver.closeDriver();
    }

//    @After("@db")
//    public void closeConnection() {
//        System.out.println("closing connection to db");
//    }


    //    @BeforeStep
//    public void setUpStep(){
//        System.out.println("hi hi hi");
//    }
//    @AfterStep
//    public void tearDownStep(){
//        System.out.println("bye bye");
//    }

}
