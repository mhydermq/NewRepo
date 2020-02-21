package com.cucum.cheese;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheeseStepdef{
	
	WebDriver driver;
	String titleStartsWith;
	
	@Before
	public void openBrowser() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\hyder\\Downloads\\webdrivers\\"
			+ "chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^I am on the Google search page$")
	public void i_am_on_the_Google_search_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.google.com");
	}
			

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String query) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement element = driver.findElement(By.name("q"));
		
	    //enter something to search for
		element.sendKeys(query);
		
		//now submit the form, WebDriver will find the form for us from the element
		element.submit();
	   
	}

	@Then("^the page title should start with \"([^\"]*)\"$")
	public void the_page_title_should_start_with(String titleStartsWith) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		//google's search is rendered dynamically with javascript
		//wait for the page to load timeout after 10 seconds
		new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
	           public Boolean apply(WebDriver d) {
	               return driver.getTitle().toLowerCase().startsWith(titleStartsWith);
	           }
	       });    
	}
		
	@After
     public void closeBrowser() {
		driver.close();
       driver.quit();
     }
}




