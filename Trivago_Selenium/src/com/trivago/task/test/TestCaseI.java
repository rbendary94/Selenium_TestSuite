package com.trivago.task.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCaseI {

	static WebDriver webDriver = new ChromeDriver();

	public static void main(String[] args) {
		String os = System.getProperty("os.name").toLowerCase();
		
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		}
		
		String url = "http://www.trivago.co.uk.";
		webDriver.get(url);

		TestCaseI x = new TestCaseI();
		x.searchPage("Cairo");

	}

	public void searchPage(String city) {
		System.out.println("---- Search Page ----");
		webDriver.findElement(By.id("horus-querytext")).sendKeys(city);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement citiesList = webDriver.findElement(By.tagName("ul"));
		citiesList.findElements(By.tagName("li")).get(0).click();
		System.out.println("Clicked: " + city);

		webDriver
				.findElement(By.xpath(
						"//*[@id=\"js-fullscreen-hero\"]/div/div[2]/form/div[2]/div[2]/div/table/tbody/tr[3]/td[6]"))
				.click();
		System.out.println("Selected Check-in Date: " + "15-06-2019");
		webDriver
				.findElement(By.xpath(
						"//*[@id=\"js-fullscreen-hero\"]/div/div[2]/form/div[2]/div[2]/div/table/tbody/tr[4]/td[6]"))
				.click();
		System.out.println("Selected Check-out Date: " + "22-06-2019");

		webDriver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div/div[2]/form/div/div/div[3]/button"))
				.click();
		System.out.println("Clicked: Search");
	}

}
