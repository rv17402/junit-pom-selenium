package com.junit.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.BasePage;
import com.pages.multiPage.PageFour;
import com.pages.multiPage.PageOne;
import com.pages.multiPage.PageThree;
import com.pages.multiPage.PageTwo;
import com.pages.pizza.Pizza;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class JunitTest {
	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	static ExtentTest multiPageLogger;
	static ExtentTest pizzaLogger;

	@BeforeClass
	public static void driverSetup() {
		System.out.println("In Before Class");
		BasePage.setDriver("chrome");
		
		reporter = new ExtentHtmlReporter("./Report/JunitTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		multiPageLogger = extent.createTest("testMultiPage");
		pizzaLogger = extent.createTest("pizzaiPage");
	}

	@Before
	public void beforeEachTestCaseL() {
		System.out.println("In Before");
		BasePage.homePage("http://bootcamp.ngc.training/");
	}

	@Test
	public void testMultiPage() {

		try {
			PageOne p1 = new PageOne();
			
			p1.multiPageLink();
			p1.firstName("John");
			p1.lastName("Doe");
			p1.email("John.Doe@selenium.com");
			p1.confirmEmailAddress("John.Doe@selenium.com");
			p1.phoneNumber("410-812-4512");
			try {
				p1.takeScreenShot("./Report/Multipage1.png");
				multiPageLogger.log(Status.INFO, "Entered Page 1");
				multiPageLogger.addScreencastFromPath("/TestSelinium/Report/Multipage1.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			p1.nextPage();
		} catch (Exception e) {
			multiPageLogger.log(Status.FAIL, "Entered Page 1 - Failed. " + e.getMessage());
			e.printStackTrace();
		}

		try {
			PageTwo p2 = new PageTwo();
			p2.address1("1 North Pole");
			p2.city("ANCHORAGE");
			p2.state("AK");
			p2.zip("99530");
			p2.country("United States");
			try {
				p2.takeScreenShot("./Report/Multipage2.png");
				multiPageLogger.log(Status.INFO, "Entered Page 2");
				multiPageLogger.addScreencastFromPath("C:\\git\\junit-pom-selenium\\TestSelinium\\Report\\Multipage2.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			p2.nextPage();
		} catch (Exception e) {
			multiPageLogger.log(Status.FAIL, "Entered Page 2 - Failed. " + e.getMessage());
			e.printStackTrace();
		}

		try {
			PageThree p3 = new PageThree();
			p3.department("Technical Support");
			p3.message("This is a test to navigate http://bootcamp.ngc.training using Selenium");
			try {
				p3.takeScreenShot("./Report/Multipage3.png");
				multiPageLogger.log(Status.INFO, "Entered Page 3");
				multiPageLogger.addScreencastFromPath("./Report/Multipage3.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
			p3.nextPage();
		} catch (Exception e) {
			multiPageLogger.log(Status.FAIL, "Entered Page 3 - Failed. " + e.getMessage());
			e.printStackTrace();
		}

		try {
			PageFour p4 = new PageFour();
			p4.agree();
			try {
				p4.takeScreenShot("./Report/Multipage4.png");
				multiPageLogger.log(Status.INFO, "Entered Page 4");
				multiPageLogger.addScreencastFromPath("./Report/Multipage4.png");				
			} catch (IOException e) {
				e.printStackTrace();
			}
			p4.submit();
			
			String actualResult = p4.verify();
			Assert.assertEquals("Click OK to return to the Main Dashboard", actualResult);
			try {
				p4.takeScreenShot("./Report/MultipageAfterSubmit.png");
				multiPageLogger.log(Status.PASS, "Multipage Success");
				multiPageLogger.addScreencastFromPath("./Report/MultipageAfterSubmit.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			multiPageLogger.log(Status.FAIL, "Entered Page 4 - Failed. " + e.getMessage());
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void driverTakedown() {
		System.out.println("In After Class");
		BasePage.TakeDown();

		extent.flush();
	}

	@Test
	public void pizzaiPage() {

		try {
			Pizza pizza = new Pizza();
			pizza.pizzaLink();
			pizza.firstName("John");
			pizza.lastName("Doe");
			pizza.phone("510-586-7000");
			pizza.deliveryMethod("Delivery");
			pizza.address1("1 North Pole");
			pizza.city("ANCHORAGE");
			pizza.state("AK");
			pizza.zip("99530");
			pizza.size("Medium");
			pizza.crust("Original Hand Tossed Crust");
			pizza.selectTopping("Pineapple");
			pizza.selectTopping("Peppers");
			pizza.instructions("Please hurry!!! I am hungry");
			try {
				pizza.takeScreenShot("./Report/pizzaBeforeOrder.png");
				pizzaLogger.log(Status.INFO, "Pizza Order Entered");
				pizzaLogger.addScreencastFromPath("./Report/pizzaBeforeOrder.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			pizza.order();
	
			String actualResult = pizza.verify();
			Assert.assertEquals("Click OK to return to the Main Dashboard", actualResult);
			try {
				pizza.takeScreenShot("./Report/pizzaAfterOrder.png");
				pizzaLogger.log(Status.PASS, "Pizza Order Success");
				pizzaLogger.addScreencastFromPath("./Report/pizzaAfterOrder.png");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			pizzaLogger.log(Status.FAIL, "Pizza Order- Failed. " + e.getMessage());
			e.printStackTrace();
		}
	}
}
