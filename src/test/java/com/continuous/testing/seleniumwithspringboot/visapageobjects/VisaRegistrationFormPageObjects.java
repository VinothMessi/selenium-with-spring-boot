package com.continuous.testing.seleniumwithspringboot.visapageobjects;

import org.openqa.selenium.By;

public interface VisaRegistrationFormPageObjects {
    By pageHeader = By.id("header_1");
    By subHeader = By.id("subHeader_1");

    By firstName = By.id("first_4");
    By middleName = By.id("middle_4");
    By lastName = By.id("last_4");

    By fromCountry = By.id("input_46");
    By toCountry = By.id("input_47");

    By birthDateMonth = By.id("input_24_month");
    By birthDateDay = By.id("input_24_day");
    By birthDateYear = By.id("input_24_year");

    By userEmail = By.id("input_6");
    By areaCode = By.id("input_27_area");
    By phoneNumber = By.id("input_27_phone");

    By comments = By.id("input_45");

    By submitButton = By.id("submitBtn");
}