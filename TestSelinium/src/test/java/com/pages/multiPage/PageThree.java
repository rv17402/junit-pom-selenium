package com.pages.multiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

public class PageThree extends BasePage {
	By departmentlLocator = By.name("department");
	By messageLocator = By.id("message");
	By nextPageLocator = By.xpath("//*[@id='react-app']/div/div/div/div[2]/div/div[2]/div/form/div[3]/div[2]/button");

	public PageThree(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public PageThree() {
		if (getDriver() == null) {
			setDriver("chrome");
		}
	}

	public void department(String department) {
		selectVisibleText("department", departmentlLocator, 10, department);
	}

	public void message(String message) {
		sendKeys(getElement("message", messageLocator, 10), message);
	}

	public void nextPage() {
		click(getElement("Page3NxtBtn", nextPageLocator, 10));
	}
}
