package com.academy.techcenture.takeScreenshot;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExperiment extends BaseTest {


    @Test(dataProvider = "CustomerAccountInformation")
    public void takeScreenshotTest() throws IOException {

        WebDriver driver = Driver.getDriver();
        driver.get("https://google.com");

        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String filename = "first_screenshot" + ".png";
        String destination =  System.getProperty("user.dir") + "/test-output/" + filename;
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);

    }
}
