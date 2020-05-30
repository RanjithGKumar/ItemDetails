package com.BrokenLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLink {
	WebDriver driver;
	static List<String> listofLinks;
	static HttpURLConnection urlCon;

	@Test
	public void findBrokenLinks() {
		List<WebElement> linkTag = driver.findElements(By.tagName("a"));
		for (int i = 0; i < linkTag.size(); i++) {
			String url = linkTag.get(i).getAttribute("href");
			System.out.println("Available URL's: " + url);
			if (url != null && url.trim() != "") {
				listofLinks.add(url);
			} else {
				System.out.println(i + "th URL contains nothing or NULL");
			}
				
			try {

				URL link = new URL(url);
				urlCon = (HttpURLConnection) link.openConnection();
				urlCon.setReadTimeout(2000);
				urlCon.connect();
				int respo = urlCon.getResponseCode();
				System.out.println("Response Value is :" + respo);
				if (respo >= 400) {
					System.out.println(i + " of Link is Broken");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@BeforeTest
	public void launchApp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ranjith\\Desktop\\REsumes\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get("http://www.learn-automation.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
	}
}
