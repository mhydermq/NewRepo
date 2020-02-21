package com.cucum.cheese;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions
(plugin = {"pretty", "html:target/out.html"},
features="src/test/resources/feature",
dryRun = false,
monochrome=true)

public class BrowserAutomationRunner {

}
