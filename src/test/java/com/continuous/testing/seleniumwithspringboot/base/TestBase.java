package com.continuous.testing.seleniumwithspringboot.base;

import com.continuous.testing.seleniumwithspringboot.services.TakeASnap;
import com.continuous.testing.seleniumwithspringboot.visapages.HomePage;
import com.continuous.testing.seleniumwithspringboot.visapages.VisaConfirmationPage;
import com.continuous.testing.seleniumwithspringboot.visapages.VisaRegistrationFormPage;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@SpringBootTest
public class TestBase extends AbstractTestNGSpringContextTests {

    @Lazy
	@Autowired
    protected WebDriver browser;
    
    @Lazy
	@Autowired
    protected TakeASnap takeASnap;

    @Lazy
	@Autowired
    protected HomePage homePage;

    @Lazy
	@Autowired
    protected VisaConfirmationPage visaConfirmationPage;

    @Lazy
	@Autowired
    protected VisaRegistrationFormPage visaRegistrationFormPage;
    
    @Value("${app1.url}")
    private String app1URL;

    @BeforeClass
    public void setUp() {
        homePage.visit(app1URL);
    }
    
    @AfterClass
    public void tearDown() {
        homePage.closeAll();
    }
    
    protected void print(final String message) {
		System.out.println(message);
	}
    
}