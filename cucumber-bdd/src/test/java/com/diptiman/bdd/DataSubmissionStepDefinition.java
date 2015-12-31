package com.diptiman.bdd;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataSubmissionStepDefinition {
	
	private WebElement element;
	private WebDriver driver;
	
	@Given("^user navigates to data entry page$")
	public void user_navigaes_to_data_entry_page() throws Throwable {
	    driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://localhost:8080/bddweb/userDataEntry.jsp");
	}

	@When("^user enters data$")
	public void user_enters_data() throws Throwable {
		driver.findElement(By.id("mytext")).sendKeys("Cool Cucumber !"); 
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("^Message Displayed data submitted successfully$")
	public void message_displayed_data_submitted_successfully() throws Throwable {
		 String successTitle = driver.getTitle();
		 assertEquals("Success Title Matched", successTitle, "Success Page");
		 driver.close();
	}
}
