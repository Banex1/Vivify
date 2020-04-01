package Vivify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VivifySmokeTest {

	public static void wait2sec() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src\\\\Vivify\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String HomepageUrl = "https://gallery-app.vivifyideas.com/";

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(HomepageUrl);
		driver.manage().window().maximize();

		// test1 - Url test

		if (HomepageUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Desired page is opened");
		} else
			System.out.println("Error");
		wait2sec();

		// test2 - Title test
		String title = "gallery-app";
		String currentTitle = driver.getTitle();

		if (title.equals(currentTitle)) {
			System.out.println("Expected title matches actual title");
		} else
			System.out.println("Error");
		wait2sec();

		// test3 - Login link test
		String loginBtn = "//a[contains(text(),'Login')]";
		String loginUrl = "https://gallery-app.vivifyideas.com/login";
		WebElement loginButton = driver.findElement(By.xpath(loginBtn));
		loginButton.click();

		if (loginUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successfully redirected to Login page");
		} else
			System.out.println("Error");
		wait2sec();

		// test4 - Testing navigation button
		driver.navigate().back();

		if (HomepageUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successfully redirected to Home Page");
		} else
			System.out.println("Error");
		wait2sec();

		// test5 - Register link test
		String RegisterBtn = "/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/ul[2]/li[2]/a[1]";
		String RegisterUrl = "https://gallery-app.vivifyideas.com/register";
		WebElement RegisterButton = driver.findElement(By.xpath(RegisterBtn));
		RegisterButton.click();

		if (RegisterUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successfully redirected to Register page");
		} else
			System.out.println("Error");
		wait2sec();

		// test6 - Gallery App link test
		String GalleryApp = "//a[@class='navbar-brand router-link-active']";
		WebElement GalleryAppBtn = driver.findElement(By.xpath(GalleryApp));
		GalleryAppBtn.click();

		wait2sec();
		if (HomepageUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successfully redirected to Home Page using Gallery App link");
		} else
			System.out.println("Error");
		wait2sec();

		// test7 - Search field and Filter button check
		String SearchFld = "//input[@placeholder='Search...']";
		String FilterBtn = "//button[@class='btn btn-outline-secondary input-button']";
		WebElement SearchField = driver.findElement(By.xpath(SearchFld));
		WebElement FilterButton = driver.findElement(By.xpath(FilterBtn));
		SearchField.sendKeys("Edit");
		wait2sec();
		FilterButton.click();
		wait2sec();

		if (driver.getPageSource().contains("Edit")) {
			System.out.println("Successful search of Gallerie containg text: 'Edit'");
		} else
			System.out.println("Error");
		wait2sec();

		// test8 - All Galleries link test
		/*
		 * Firstly clicking on 1st result of search because directly after search we
		 * can't go back to home page by clicking on All Galleries link
		 */
		String EditGallery = "//div[@class='grid']//div[1]//h2[1]//a[1]";
		WebElement EditGalleryLink = driver.findElement(By.xpath(EditGallery));
		EditGalleryLink.click();
		wait2sec();
		String AllGalleries = "//a[@class='nav-link nav-buttons router-link-active']";
		WebElement AllGalleriesBtn = driver.findElement(By.xpath(AllGalleries));
		AllGalleriesBtn.click();

		wait2sec();
		if (HomepageUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successfully redirected to Home Page using All Galleries link");
		} else
			System.out.println("Error");
		wait2sec();

		System.out.println("Smoke testing completed!");
		driver.close();
	}
}