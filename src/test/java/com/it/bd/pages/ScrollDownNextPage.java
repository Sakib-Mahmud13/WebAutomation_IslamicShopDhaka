package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class ScrollDownNextPage {
	ExtentTest test;
	JavascriptExecutor js;
	
	
	
	public ScrollDownNextPage(ExtentTest test,JavascriptExecutor js) throws InterruptedException {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.js = (JavascriptExecutor) test;
		this.test = test;
		
	}

	@FindBy (xpath = "//body/div[@id='page']/a[@id='gotop']/span[1]/*[1]")
	WebElement campaignbar;

	
	public void failCase(String message, String scName) throws IOException {
		test.fail(
				"<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		@SuppressWarnings("unused")
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	
	public void nextpage() throws IOException, InterruptedException{
		
		try {
			((ExtentTest) js).info("Scroll Down");
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			Thread.sleep(10000);
			passCaseWithSC("Scroll", "Down");
			
		
		
		
		try {
			test.info("Click on Campaign Bar");
			if(campaignbar.isDisplayed()) {
				campaignbar.click();
				Thread.sleep(10000);
				passCaseWithSC("Clicked", "Campaign Bar");
			}
			
		
			
			
		} catch (Exception e) {
			failCase("Campaign Bar was not locateable.", "campaignbarfail");
		}
		
		
		} catch (Exception e) {
			failCase("Scroll Down was not locateable.", "scrolldownfail");
		}
			
			
	   }
	
}



