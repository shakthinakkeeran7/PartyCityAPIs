package com.partycity.api.stepDefinition;

import java.util.HashMap;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.partycity.api.baseclass.BaseClass;
import com.partycity.api.dataprovider.ConfigExcelFileReader;
import com.partycity.api.enums.Context;
import com.partycity.api.manager.FileReaderManager;
import com.partycity.api.runner.TestRunner;
import com.partycity.api.util.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginPageTestSteps extends BaseClass {

	TestContext testContext;

	public LoginPageTestSteps(TestContext context) throws Throwable {

		testContext = context;

	}


}
