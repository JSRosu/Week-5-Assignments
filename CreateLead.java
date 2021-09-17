package testcase;


import java.io.IOException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	@Test(dataProvider = "sendData")//intergrating with the TEST 
	public  void runCreateLead(String firstName, String lastName, String cmpnyName, String phnNo)// giving arguments
	{
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpnyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnNo);
		driver.findElement(By.name("submitButton")).click();
		
}
	@DataProvider
	public String[][] sendData() throws IOException {
		
		//String[][] readData = ReadExel.readData(); // since ReadExel is static no need of declaration on obj
		return ReadExel.readData();
		
	}
}






