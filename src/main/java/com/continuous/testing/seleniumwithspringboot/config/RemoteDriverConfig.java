package com.continuous.testing.seleniumwithspringboot.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
@Profile("remote")
public class RemoteDriverConfig {

    @Value("${hub.url}")
    private String hubURL;

    @Bean
    @Scope("browser")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubURL), DesiredCapabilities.firefox());
    }

    @Bean
    @Scope("browser")
    @ConditionalOnMissingBean
    public WebDriver remoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubURL), DesiredCapabilities.chrome());
    }

}