package com.interbanking.testcases;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.interbanking.utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	ReadConfig rs = new ReadConfig();
	public String BaseUrl = rs.getAppUrl();
	public String UserID = rs.UserID();
	public String password = rs.password();
	public Logger log;

	// Specify path of driver to server.
	static {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
	}

	@Parameters("browsers")
	@BeforeClass
	public void setup(String browsers) throws Exception {
		log = Logger.getLogger("Interbanking");
		PropertyConfigurator.configure("log4j.properties");
		if (browsers.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.get(BaseUrl);
			log.info("Bank URL has been entered in browser");
			Thread.sleep(3000);// wait for 3 seconds
		} else {
			driver = new ChromeDriver();
			driver.get(BaseUrl);
			log.info("Bank URL has been entered in browser");
			Thread.sleep(3000);// wait for 3 seconds

		}

	}

	@AfterClass
	public void teardown() throws Exception {
		driver.quit();
	}

	// Capture Screenshot Method
	public void captureScreen(WebDriver driver, String tname) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		Date d = new Date();
		String d1 = d.toString();
		String dateformatted = d1.replaceAll(":","-");
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + " " + dateformatted + ".png");
		FileUtils.copyFile(src, dst);
		System.out.println("Screenshot Captured....");

	}

	public boolean alertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
