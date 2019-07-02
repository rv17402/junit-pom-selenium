package com.pages.multiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.BasePage;

public class PageFour extends BasePage {
	By agreeLocator = By.name("agree");
	By submitLocator = By.xpath("//*[@id=\'react-app\']/div/div/div/div[2]/div/div[2]/div/form/div[3]/div[1]/button/span");

	public PageFour(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public void agree() {
		click(getElement("agree", agreeLocator, 10));
	}

	public void submit() {
		click(getElement("submit", submitLocator, 10));
	}
}
