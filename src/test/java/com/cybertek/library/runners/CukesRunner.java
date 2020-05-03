package com.cybertek.library.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"},
        features = "src\\test\\resources\\features",
        glue = "com\\cybertek\\library\\step_definitions",
        dryRun = false,
        tags = "@wip"

)
public class CukesRunner {
    //librarian or student syntax to run 2 scenarios
    //librarian and student only runs scenarios if both tags match
    //smoke and not student it will run scenarios which has smoke but not @staff

//mvn test -Dcucumber.filter.tags=@smoke to change tag from terminal and run it

}

