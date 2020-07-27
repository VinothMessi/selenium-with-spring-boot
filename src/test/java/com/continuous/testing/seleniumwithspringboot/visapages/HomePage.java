package com.continuous.testing.seleniumwithspringboot.visapages;

import com.continuous.testing.seleniumwithspringboot.base.BasePage;
import com.continuous.testing.seleniumwithspringboot.visapageobjects.HomePageObjects;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
public class HomePage extends BasePage implements HomePageObjects {
    
    public void visit(final String url) {
        open(url);
        maximize();
    }

    public String title() {
        return getPageTitle();
    }

}