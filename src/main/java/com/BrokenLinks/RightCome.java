package com.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RightCome {

	WebDriver driver;
	

	@Test
	public void findBrokenLinks() {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Surveys')]")));
			if(driver.findElement(By.xpath("//h4[contains(text(),'Surveys')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'add_circle')]")).click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("Home page not loaded");
		}
	}

	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ranjith\\Desktop\\REsumes\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("https://rightcom.rightsurvey.rightcomtech.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}

}
