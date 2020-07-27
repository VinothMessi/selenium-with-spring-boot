package com.continuous.testing.seleniumwithspringboot.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public abstract class BasePage {

	@Lazy
	@Autowired
	protected WebDriver myBrowser;

	@Lazy
	@Autowired
	protected JavascriptExecutor js;
	
	protected void maximize() {
		this.myBrowser.manage().window().maximize();
	}

	protected void closeAll() {
		this.myBrowser.quit();
	}

	protected void open(final String url) {
		this.myBrowser.get(url);
		this.myBrowser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	protected String getPageTitle() {
		return this.myBrowser.getTitle();
	}

	protected WebElement find(By locator) {
		return this.myBrowser.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return this.myBrowser.findElements(locator);
	}

	protected boolean isPresent(By locator) {
		List<WebElement> list = findAll(locator);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	protected void clickOn(By locator) {
		find(locator).click();
	}

	protected void type(final String text, By locator) {
		find(locator).sendKeys(text);
	}

	protected String getTextFrom(By locator) {
		return find(locator).getText();
	}

	protected void selectText(final String text, By locator) {
		Select dropDown = new Select(find(locator));
		dropDown.selectByVisibleText(text);
	}

	protected void selectValue(final String value, By locator) {
		Select dropDown = new Select(find(locator));
		dropDown.selectByValue(value);
	}

	protected void selectIndex(final int index, By locator) {
		Select dropDown = new Select(find(locator));
		dropDown.selectByIndex(index);
	}

	protected boolean canWeSee(By locator) {
		return find(locator).isDisplayed();
	}

	protected boolean canWeClickOn(By locator) {
		return find(locator).isEnabled();
	}

	protected boolean canWeSelect(By locator) {
		return find(locator).isSelected();
	}

}