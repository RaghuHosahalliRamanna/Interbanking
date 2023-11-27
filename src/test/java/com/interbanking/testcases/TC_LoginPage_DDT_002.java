package com.interbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.interbanking.pageobjects.LoginPage;
import com.interbanking.utilities.XLUtils;

public class TC_LoginPage_DDT_002 extends BaseClass {

	@Test(dataProvider = "ExcelData")
	public void Login(String UserID, String password) throws Exception {
		LoginPage lp = new LoginPage(driver);

		// Enter Username
		lp.usn(UserID);

		log.info("Username entered");

		// Enter Password
		lp.pwd(password);

		log.info("password entered");

		// click on login button
		lp.loginbutton();

		log.info("Login button clicked");

		Thread.sleep(2000);

		if (alertpresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login Failed");
			captureScreen(driver, "Login");
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			lp.logoutbutton();
			log.info("login successfull");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	@DataProvider(name = "ExcelData")
	String[][] getData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/java/com/interbanking/testdata/LoginTestData.xlsx";
		int NoOfRows = XLUtils.getRowCount(path, "Sheet1");
		int NoOfColumns = XLUtils.getCellCount(path, "Sheet1", 1);

		String data[][] = new String[NoOfRows][NoOfColumns];
		for (int i = 0; i < NoOfRows; i++) {
			for (int j = 0; j < NoOfColumns; j++) {
				log.info("Entering excel data one by one");
				data[i][j] = XLUtils.getCellData(path, "Sheet1", (i + 1), j);
			}
		}
		return data;
	}

}
