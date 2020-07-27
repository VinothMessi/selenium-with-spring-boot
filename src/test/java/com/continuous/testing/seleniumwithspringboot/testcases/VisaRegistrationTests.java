package com.continuous.testing.seleniumwithspringboot.testcases;

import com.continuous.testing.seleniumwithspringboot.base.TestBase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VisaRegistrationTests extends TestBase {

	@Test(priority = 1)
	public void verifyHomePage() throws IOException {
		print("Page Title is:" + homePage.title());

		Assert.assertTrue(homePage.title().equals("VISA Registration Form"));

		takeASnap.saveAs(Thread.currentThread().getId() + "_" + "HomePage.png");
	}

	@Test(priority = 2)
	public void verifyVisaRegistrationFormPage() {
		print("Page Header is:" + visaRegistrationFormPage.pageHeader());

		Assert.assertTrue(visaRegistrationFormPage.pageHeader().equals("VISA Registration Form"));

		print("Page SubHeader is:" + visaRegistrationFormPage.pageSubHeader());

		Assert.assertTrue(
				visaRegistrationFormPage.pageSubHeader().equals("Fill out the form carefully for registration"));
	}

	@Test(priority = 3)
	public void visaRegistration() throws IOException {
		visaRegistrationFormPage.fillInDetails("Test", "User", "One", "India", "Australia", "JANUARY", "1", "2000",
				"test@gmail.com", "+91", "0987654321", "Testing Visa Registration");

		visaRegistrationFormPage.submitForm();

		takeASnap.saveAs(Thread.currentThread().getId() + "_" + "Visa_Form.png");
	}

	@Test(priority = 4)
	public void registrationConfirmation() throws InterruptedException, IOException {
		Thread.sleep(1000);

		print("Visa Confirmation Message:" + visaConfirmationPage.getConfirmationMessage());

		print("Visa Request Number:" + visaConfirmationPage.getRequestNumber());

		takeASnap.saveAs(Thread.currentThread().getId() + "_" + "Visa_Confirmation.png");
	}

}