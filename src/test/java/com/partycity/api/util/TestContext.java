package com.partycity.api.util;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.partycity.api.manager.FileReaderManager;
import com.partycity.api.runner.TestRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
	public static WebDriver driver = TestRunner.driver;
	private ScenarioContext scenarioContext;
	
	
	//private WebDriverManager webDriverManager;
	
	public TestContext(){
		
		scenarioContext = new ScenarioContext();
	
	
		
	}
	
//	public WebDriverManager getWebDriverManager() {
//		return webDriverManager;
//	}
	


	
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}
