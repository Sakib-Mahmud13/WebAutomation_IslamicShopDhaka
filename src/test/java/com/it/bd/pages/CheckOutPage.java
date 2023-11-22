package com.it.bd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.it.bd.basedrivers.PageDriver;
import com.it.bd.utilities.GetScreenShot;

public class CheckOutPage {
	ExtentTest test;
	
	public CheckOutPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
		
	}
	@FindBy(xpath = "//body/div[@id='page']/div[@id='content']/article[@id='post-10812']/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement book;
	
	@FindBy(xpath = "//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]")
	WebElement oder;
	@FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[2]/a[1]/span[1]/*[1]")
	WebElement cart;
	@FindBy(xpath = "//a[contains(text(),'Order Now')]")
	WebElement odernow;
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
	
	public void odernow() throws IOException {
		try {
			test.info("Click on Book");
			if(book.isDisplayed()) {
				book.click();
				Thread.sleep(10000);
				passCaseWithSC("Clicked", "Book");
			}
			try {
				test.info("Click on Oder Book");
				if(oder.isDisplayed()) {
					oder.click();
					Thread.sleep(10000);
					passCaseWithSC("Clicked", "Oder Book");
				}	
				try {
					test.info("Click on Cart");
					if(cart.isDisplayed()) {
						cart.click();
						Thread.sleep(10000);
						passCaseWithSC("Clicked", "Cart");
					}
					
	
		  try {
			test.info("Click on Odernow");
			if(odernow.isDisplayed()) {
				odernow.click();
				Thread.sleep(10000);
				passCaseWithSC("Clicked", "Odernowt");
			}
			
			
		} catch (Exception e) {
			failCase("Odernow was not locateable.", "odernow");
	       }
	} catch (Exception e) {
     		failCase("Cart was not locateable.", "gotocartfail");
     		}
	} catch (Exception e) {
		failCase("Oder Book was not locateable.", "oderbookfail");
	}
		
	} catch (Exception e) {
		failCase("Book was not locateable.", "bookfail");
	}
  }
	

		
		


}
