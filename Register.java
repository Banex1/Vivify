package Vivify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

	public static void wait2() {
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

		String DATA_SOURCE = "src\\Vivify\\UserRandomData.xlsx";

		Excel.setExcell(DATA_SOURCE);
		Excel.setWorkSheet(0);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(HomepageUrl);
		wait2();
		wait2();
		String RegisterBtn = "//a[contains(text(),'Register')]";
		WebElement RegisterButton = driver.findElement(By.xpath(RegisterBtn));
		RegisterButton.click();

		String First_name_field = "//input[@id='first-name']";
		String Last_name_field = "//input[@id='last-name']";
		String Email_field = "//input[@id='email']";
		String New_password_field = "//input[@id='password']";
		String Repeat_password_field = "//input[@id='password-confirmation']";
		String Terms_conditions_checkbox = "//input[@class='form-check-input']";
		String Submit_button = "//button[@class='btn btn-custom']";

		WebElement First_name_field1 = driver.findElement(By.xpath(First_name_field));
		WebElement Last_name_field1 = driver.findElement(By.xpath(Last_name_field));
		WebElement Email_field1 = driver.findElement(By.xpath(Email_field));
		WebElement New_password_field1 = driver.findElement(By.xpath(New_password_field));
		WebElement Repeat_password_field1 = driver.findElement(By.xpath(Repeat_password_field));
		WebElement Terms_conditions_checkbox1 = driver.findElement(By.xpath(Terms_conditions_checkbox));
		WebElement Submit_button1 = driver.findElement(By.xpath(Submit_button));

		// Adding registration data from excel table
		// "i" begins with 2 here because i already ran this test and registered user
		// from first row
		// on next instance i should be 3, and i<4 up to number of users you wish to
		// register
		for (int i = 2; i < 3; i++) {

			String First_name = Excel.getDataAt(i, 0);
			String Last_name = Excel.getDataAt(i, 1);
			String Email = Excel.getDataAt(i, 2);
			String New_password = Excel.getDataAt(i, 3);
			String Repeat_password = Excel.getDataAt(i, 3);

			// clearing of fields in case data stays in field and we are trying to register
			// more users
			First_name_field1.clear();
			Last_name_field1.clear();
			Email_field1.clear();
			New_password_field1.clear();
			Repeat_password_field1.clear();
			// Adding user data, checking Accept Terms and click on Sumbit
			First_name_field1.sendKeys(First_name);
			Last_name_field1.sendKeys(Last_name);
			Email_field1.sendKeys(Email);
			New_password_field1.sendKeys(New_password);
			Repeat_password_field1.sendKeys(Repeat_password);
			Terms_conditions_checkbox1.click();
			wait2();
			Submit_button1.click();
			wait2();

			if (HomepageUrl.equals(driver.getCurrentUrl())) {
				System.out.println("Successful registration and return to Home Page");
			} else
				System.out.println("Error");
		}

		wait2();
		driver.quit();
	}
}