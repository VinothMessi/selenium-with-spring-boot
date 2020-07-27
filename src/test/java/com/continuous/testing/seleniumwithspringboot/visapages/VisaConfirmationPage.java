package com.continuous.testing.seleniumwithspringboot.visapages;

import com.continuous.testing.seleniumwithspringboot.base.BasePage;
import com.continuous.testing.seleniumwithspringboot.visapageobjects.VisaConfirmationPageObjects;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
public class VisaConfirmationPage extends BasePage implements VisaConfirmationPageObjects {

    public String getConfirmationMessage() {
        return getTextFrom(panel);
    }

    public String getRequestNumber() {
        return getTextFrom(reqNumber);
    }

}