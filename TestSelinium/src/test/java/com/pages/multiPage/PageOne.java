package com.pages.multiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

public class PageOne extends BasePage {
	By firstNameLocator = By.id("firstName");
	By lastNameLocator = By.id("lastName");
	By emailLocator = By.id("email");
	By confirmationEmailLocator = By.id("confirmEmailAddress");
	By phoneNumberLocator = By.id("phoneNumber");
	By nextPageLocator = By
			.xpath("//*[@id=\'react-app\']/div/div/div/div[2]/div/div[2]/div/form/div[4]/div/div[2]/button/span");
	By multiPageHomeLocator = By.cssSelector("#multiPageFormLink > span");

	public PageOne(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public PageOne() {
		if (getDriver() == null) {
			setDriver("chrome");
		}
	}

	public void multiPageLink() {
		click(getElement("multiPageLink", multiPageHomeLocator, 10));

	}

	public void firstName(String name) {
		sendKeys(getElement("FirstName", firstNameLocator, 10), name);
	}

	public void lastName(String name) {
		sendKeys(getElement("LastName", lastNameLocator, 10), name);
	}

	public void email(String email) {
		sendKeys(getElement("email", emailLocator, 10), email);
	}

	public void confirmEmailAddress(String email) {
		sendKeys(getElement("confirmationEmail", confirmationEmailLocator, 10), email);
	}

	public void phoneNumber(String phoneNumber) {
		sendKeys(getElement("phoneNumber", phoneNumberLocator, 10), phoneNumber);
	}

	public void nextPage() {
		click(getElement("Page1NxtBtn", nextPageLocator, 10));
	}

}
