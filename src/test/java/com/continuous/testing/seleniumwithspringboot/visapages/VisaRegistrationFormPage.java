package com.continuous.testing.seleniumwithspringboot.visapages;

import com.continuous.testing.seleniumwithspringboot.base.BasePage;
import com.continuous.testing.seleniumwithspringboot.visapageobjects.VisaRegistrationFormPageObjects;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
public class VisaRegistrationFormPage extends BasePage implements VisaRegistrationFormPageObjects {

    public String pageHeader() {
        return getTextFrom(pageHeader);
    }

    public String pageSubHeader() {
        return getTextFrom(subHeader);
    }

    public void fillInDetails(String fName, String mName, String lName, String fCountry, String tCountry, String bMon,
            String bDay, String bYear, String uEmail, String aCode, String pNumber, String comMents) {
        type(fName, firstName);
        type(lName, middleName);
        type(mName, lastName);

        selectValue(fCountry, fromCountry);
        selectValue(tCountry, toCountry);

        selectValue(bMon, birthDateMonth);
        selectValue(bDay, birthDateDay);
        selectValue(bYear, birthDateYear);

        type(uEmail, userEmail);
        type(aCode, areaCode);
        type(pNumber, phoneNumber);
        type(comMents, comments);
    }

    public void submitForm() {
        clickOn(submitButton);
    }

}