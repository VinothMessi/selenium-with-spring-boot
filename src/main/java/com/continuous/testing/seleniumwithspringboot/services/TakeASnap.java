package com.continuous.testing.seleniumwithspringboot.services;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TakeASnap {

	@Autowired
	private ApplicationContext appCtx;

	@Value("${user.dir}" + "${snap.shot.path}")
	private String lSnapShotPath;

	public String saveAs(final String imageName) throws IOException {
		FileUtils.copyFile(printScreen(), create(imageName));
		return create(imageName).getAbsolutePath();
	}

	private File printScreen() {
		return appCtx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
	}

	private File create(final String imageName) {
		return new File(lSnapShotPath + imageName);
	}

}