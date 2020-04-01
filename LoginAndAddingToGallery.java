package Vivify;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndAddingToGallery {

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
		String LoginBtn = "//a[contains(text(),'Login')]";
		WebElement LoginButton = driver.findElement(By.xpath(LoginBtn));
		LoginButton.click();

		String Email_field = "//input[@id='email']";
		String Password_field = "//input[@id='password']";
		String Submit_button = "//button[@class='btn btn-custom']";

		WebElement Email_field1 = driver.findElement(By.xpath(Email_field));
		WebElement Password_field1 = driver.findElement(By.xpath(Password_field));
		WebElement Submit_button1 = driver.findElement(By.xpath(Submit_button));

		// Logging in using UserRandomData Excel file
		/*
		 * If you run Register class again, in order to register next user, in the next
		 * two columns of code you should change number for e-mail and password to
		 * number 2 and so on.. (depending on runs of Register class)
		 */
		String Email = Excel.getDataAt(1, 2);
		String Password = Excel.getDataAt(1, 3);

		Email_field1.clear();
		Password_field1.clear();
		Email_field1.sendKeys(Email);
		Password_field1.sendKeys(Password);
		Submit_button1.click();
		wait2();

		if (HomepageUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Successful login and return to Home Page");
		} else
			System.out.println("Error");

		// Switching to Create Gallery page, creating Gallery, adding name, description
		// and 2 images
		String Create_Gallery_link = "//a[contains(text(),'Create Gallery')]";
		WebElement Create_Gallery_link1 = driver.findElement(By.xpath(Create_Gallery_link));
		Create_Gallery_link1.click();

		String Title_field = "//input[@id='title']";
		String Descriptions_field = "//input[@id='description']";
		String Image1_field = "//body//div[@class='container']//div//div//div[1]//div[1]//input[1]";
		String Add_image_button = "//button[contains(text(),'Add image')]";
		String Submit_Gallery_button = "//button[contains(text(),'Submit')]";

		WebElement Title_field1 = driver.findElement(By.xpath(Title_field));
		WebElement Descriptions_field1 = driver.findElement(By.xpath(Descriptions_field));
		WebElement Image1_field1 = driver.findElement(By.xpath(Image1_field));
		WebElement Add_image_button1 = driver.findElement(By.xpath(Add_image_button));
		WebElement Submit_Gallery_button1 = driver.findElement(By.xpath(Submit_Gallery_button));

		Title_field1.sendKeys("QA");
		Descriptions_field1.sendKeys("Kill them bugs :D");
		Image1_field1.sendKeys("https://blog.testlodge.com/wp-content/uploads/2016/09/what_does_qa_stand_for.png");
		Add_image_button1.click();
		wait2();
		// Adding Image2 field here because before clicking on Add image button we don't
		// have it's path
		String Image2_field = "//div[@class='container']//div[2]//div[1]//input[1]";
		WebElement Image2_field1 = driver.findElement(By.xpath(Image2_field));
		Image2_field1.sendKeys("https://silktide.com/images/uploads/images/QA_Various-Characters.png");
		wait2();
		Submit_Gallery_button1.click();
		wait2();

		// Clicking on created gallery, listing of images, adding comment
		String QA_Gallery = "//a[contains(text(),'QA')]";
		WebElement QA_Gallery1 = driver.findElement(By.xpath(QA_Gallery));
		QA_Gallery1.click();
		wait2();
		wait2();

		String Next_picture = "//span[@class='carousel-control-next-icon']";
		WebElement Next_picture1 = driver.findElement(By.xpath(Next_picture));
		Next_picture1.click();

		wait2();
		String Previous_picture = "//span[@class='carousel-control-prev-icon']";
		WebElement Previous_picture1 = driver.findElement(By.xpath(Previous_picture));
		Previous_picture1.click();

		String Comment_field = "//textarea[@placeholder='Comment...']";
		WebElement Comment_field1 = driver.findElement(By.xpath(Comment_field));
		Comment_field1.sendKeys("Bug killers");
		wait2();

		String Submit_comment_btn = "//button[contains(text(),'Submit')]";
		WebElement Submit_comment_btn1 = driver.findElement(By.xpath(Submit_comment_btn));
		Submit_comment_btn1.click();
		wait2();

		// Click on Edit Gallery, changing title, description and adding one more image
		String Edit_gallery_btn = "//a[@class='btn btn-custom']";
		WebElement Edit_gallery_btn1 = driver.findElement(By.xpath(Edit_gallery_btn));
		Edit_gallery_btn1.click();

		String Edit_Title_field = "//input[@id='title']";
		String Edit_Descriptions_field = "//input[@id='description']";
		String Edit_Image1_field = "//body//div[@class='container']//div//div//div[1]//div[1]//input[1]";
		String Edit_Add_image_button = "//button[contains(text(),'Add image')]";
		String Edit_Submit_Gallery_button = "//button[contains(text(),'Submit')]";

		WebElement Edit_Title_field1 = driver.findElement(By.xpath(Edit_Title_field));
		WebElement Edit_Descriptions_field1 = driver.findElement(By.xpath(Edit_Descriptions_field));
		WebElement Edit_Image1_field1 = driver.findElement(By.xpath(Edit_Image1_field));
		WebElement Edit_Add_image_button1 = driver.findElement(By.xpath(Edit_Add_image_button));
		WebElement Edit_Submit_Gallery_button1 = driver.findElement(By.xpath(Edit_Submit_Gallery_button));

		Edit_Title_field1.clear();
		wait2();
		Edit_Title_field1.sendKeys("Quality assurance");
		Edit_Descriptions_field1.clear();
		wait2();
		Edit_Descriptions_field1.sendKeys("QA");
		Edit_Add_image_button1.click();
		wait2();
		String Edit_Image3_field = "//body//div[@class='container']//div//div//div//div[3]//div[1]//input[1]";
		WebElement Edit_Image3_field1 = driver.findElement(By.xpath(Edit_Image3_field));
		Edit_Image3_field1.sendKeys("https://www.memsource.com/uploads/2019/10/18/InstantQA_Blogpost.jpg");
		wait2();
		wait2();

		Edit_Submit_Gallery_button1.click();
		wait2();
		wait2();

		// Deleting Gallery
		String Delete_gallery_btn = "//button[contains(text(),'Delete Gallery')]";
		WebElement Delete_gallery_btn1 = driver.findElement(By.xpath(Delete_gallery_btn));
		Delete_gallery_btn1.click();
		wait2();
		driver.switchTo().alert().accept();

		
		
	}

}
