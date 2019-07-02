package com.pages.multiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

public class PageTwo extends BasePage {
	By address1Locator = By.xpath("//*[@id=\'address1\']");
	By cityLocator = By.id("city");
	By stateLocator = By.id("state");
	By zipLocator = By.id("zip");
	By countryLocator = By.id("country");
	By nextPageLocator = By.xpath("//*[@id='react-app']/div/div/div/div[2]/div/div[2]/div/form/div[5]/div[2]/button/span");

	public PageTwo(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public void address1(String address1) {
		sendKeys(getElement("address1", address1Locator, 10), address1);
	}

	public void city(String city) {
		sendKeys(getElement("city", cityLocator, 10), city);
	}

	public void state(String state) {
		sendKeys(getElement("state", stateLocator, 10), state);
	}

	public void zip(String zip) {
		sendKeys(getElement("zip", zipLocator, 10), zip);
	}

	public void country(String country) {
		selectVisibleText("country", countryLocator, 10, country);
	}

	public void nextPage() {
		click(getElement("Page2NxtBtn", nextPageLocator, 10));
	}
}
