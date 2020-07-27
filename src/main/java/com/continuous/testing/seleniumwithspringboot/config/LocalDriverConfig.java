package com.continuous.testing.seleniumwithspringboot.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import io.github.bonigarcia.wdm.WebDriverManager;

@Lazy
@Configuration
@Profile("local")
public class LocalDriverConfig {

    @Value("${chrome.version}")
    private String chVersion;

    @Value("${firefox.version}")
    private String ffVersion;

    @Bean
    @Scope("browser")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefox() {
        WebDriverManager.firefoxdriver().browserVersion(ffVersion).setup();
        return new FirefoxDriver();
    }

    @Bean
    @Scope("browser")
    @ConditionalOnMissingBean
    public WebDriver chrome() {
        WebDriverManager.chromedriver().browserVersion(chVersion).setup();
        return new ChromeDriver();
    }

}