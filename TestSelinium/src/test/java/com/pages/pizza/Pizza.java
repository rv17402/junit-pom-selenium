package com.pages.pizza;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

public class Pizza extends BasePage {

	By firstNameLocator = By.id("firstName");
	By lastNameLocator = By.id("lastName");
	By phoneLocator = By.id("phone");
	By deleveryMethodLocator = By.id("getMethod");
	By address1Locator = By.id("address1");
	By cityLocator = By.id("city");
	By stateLocator = By.id("state");
	By zipLocator = By.id("zip");
	By sizeLocator = By.id("size");
	By crustLocator = By.id("crust");
	By toppingsLocator = By.xpath(("//*[contains(@class,'form-check-label')]"));
	By instructionsLocator = By.id("instructions");
	By orderLocator = By.xpath("//*[@id='react-app']/div/div/div/div[2]/div/div[2]/div/form/div[10]/button");
	
	public Pizza(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public void firstName(String firstName) {
		sendKeys(getElement("FirstName", firstNameLocator, 10), firstName);
	}

	public void lastName(String lastName) {
		sendKeys(getElement("LastName", lastNameLocator, 10), lastName);
	}

	public void phone(String phone) {
		sendKeys(getElement("Phone", phoneLocator, 10), phone);
	}

	public void deliveryMethod(String method) {
		selectVisibleText("DeleveryMethod", deleveryMethodLocator, 10, method);
	}

	public void address1(String address1) {
		sendKeys(getElement("Address1", address1Locator, 10), address1);
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

	public void size(String size) {
		selectVisibleText("size", sizeLocator, 10, size);
	}

	public void crust(String crust) {
		selectVisibleText("crust", crustLocator, 10, crust);
	}

	public void instructions(String instructions) {
		sendKeys(getElement("instructions", instructionsLocator, 10), instructions);
	}

	public void order() {
		click(getElement("orderBtn", orderLocator, 10));

	}

	public void selectTopping(String value) {
		selectFromList("toppings", toppingsLocator, 10, value);
	}

}
