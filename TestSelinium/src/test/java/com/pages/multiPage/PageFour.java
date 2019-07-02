package com.pages.multiPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;

public class PageFour extends BasePage {
	By agreeLocator = By.name("agree");
	By submitLocator = By.xpath("//*[@id=\'react-app\']/div/div/div/div[2]/div/div[2]/div/form/div[3]/div[1]/button/span");
	By verifyLocator = By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]");
	
	public PageFour(WebDriver driver) {
		if (getDriver() == null || !getDriver().equals(driver)) {
			setDriver(driver);
		}
	}

	public PageFour() {
		if (getDriver() == null) {
			setDriver("chrome");
		}
	}

	public void agree() {
		click(getElement("agree", agreeLocator, 10));
	}

	public void submit() {
		click(getElement("submit", submitLocator, 10));
	}

	public String verify() {
		WebElement element = getDriver().findElement(verifyLocator);
		new WebDriverWait(getDriver(), 20).until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
}
