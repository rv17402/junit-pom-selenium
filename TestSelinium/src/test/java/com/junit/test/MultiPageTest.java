package com.junit.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.multiPage.PageFour;
import com.pages.multiPage.PageOne;
import com.pages.multiPage.PageThree;
import com.pages.multiPage.PageTwo;
import com.pages.pizza.Pizza;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class MultiPageTest {
	static WebDriver driver;

	@BeforeClass
	public static void driverSetup() {
		System.out.println("In Before Class");
		System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Before
	public void beforeEachTestCaseL() {
		System.out.println("In Before");
		driver.get("http://bootcamp.ngc.training/");
	}

	@Test
	public void testMultiPage() {
		driver.findElement(By.cssSelector("#multiPageFormLink > span")).click();

		PageOne p1 = new PageOne(driver);
		try {
			p1.firstName("John");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		p1.lastName("Doe");
		p1.email("John.Doe@selenium.com");
		p1.confirmEmailAddress("John.Doe@selenium.com");
		p1.phoneNumber("410-812-4512");
		try {                  
			p1.takeScreenShot("./Report/Multipage1.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1.nextPage();

		PageTwo p2 = new PageTwo(driver);
		p2.address1("1 North Pole");
		p2.city("ANCHORAGE");
		p2.state("AK");
		p2.zip("99530");
		p2.country("United States");
		try {
			p2.takeScreenShot("./Report/Multipage2.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p2.nextPage();

		PageThree p3 = new PageThree(driver);
		p3.department("Technical Support");
		p3.message("This is a test to navigate http://bootcamp.ngc.training using Selenium");
		try {
			p3.takeScreenShot("./Report/Multipage3.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p3.nextPage();

		PageFour p4 = new PageFour(driver);
		p4.agree();
		try {
			p4.takeScreenShot("./Report/Multipage4.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p4.submit();

		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.getText());
		Assert.assertEquals("Click OK to return to the Main Dashboard", element.getText());
		try {
			p4.takeScreenShot("./Report/MultipageAfterSubmit.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void driverTakedown() {
		System.out.println("In After Class");
		driver.quit();
	}

	@Test
	public void pizzaiPage() {
		driver.findElement(By.xpath(("//*[@id=\'pizzaPageLink\']"))).click();
		Pizza pizza = new Pizza(driver);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pizza.order();

		
		WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		System.out.println(element.getText());
		Assert.assertEquals("Click OK to return to the Main Dashboard", element.getText());
		try {
			pizza.takeScreenShot("./Report/pizzaAfterOrder.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
