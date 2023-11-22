package com.it.bd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.it.bd.basedrivers.BaseDrivers;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.pages.ClickOderPage;
import com.it.bd.utilities.ExtentFactory;

public class ClickOderTest extends BaseDrivers {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;

	@BeforeClass
	public void start () throws InterruptedException {
		PageDriver.getCurrentDriver().get(url);
		Thread.sleep(10000);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>ISLAMIC SHOP DHAKA</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
		
	}
	@Test
	public void viewTest() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Click Oder Book</b></p>");
		ClickOderPage clickoderPage = new ClickOderPage(childTest);
		clickoderPage.oder();
	}
	@AfterClass
	public void report() {
		report.flush();
	}

}
