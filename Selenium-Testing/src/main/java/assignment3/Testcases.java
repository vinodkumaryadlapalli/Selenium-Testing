package assignment3;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Testcases {

	@Test
	public void testTask01() {

	}

	@Test
	public void testTask02() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinod\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://www.google.com/maps";

		driver.get(baseUrl);
		WebElement button = driver.findElement(By.xpath("//button[@aria-label='Directions']"));
		button.click();

		Thread.sleep(1000);

		WebElement startLoc = driver.findElement(By.xpath("//div[@id='directions-searchbox-0']" + "//input"));
		startLoc.sendKeys("Lambton College");
		startLoc.sendKeys(Keys.ENTER);

		WebElement endLoc = driver.findElement(By.xpath("//div[@id='directions-searchbox-1']" + "//input"));
		endLoc.sendKeys("Blue Mountain ski resort");
		endLoc.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement details = driver
				.findElement(By.xpath("//div[@id='section-directions-trip-0']" + "//div/div//div//div[2]//div"));
		System.out.println(details.getText());
		Thread.sleep(1000);
		driver.close();


	}

	@Test
	public void testTask03() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vinod\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://www.wealthsimple.com/en-ca/tool/tax-calculator";

		driver.get(baseUrl);

		// get the actual value of the title
		Select regions = new Select(driver.findElement(By.id("territoryInput")));
		regions.selectByValue("ON");

		Thread.sleep(1000);

		WebElement employmentIncome = driver.findElement(By.id("employmentIncome"));
		employmentIncome.sendKeys("62000");

		WebElement rrspDeduction = driver.findElement(By.id("rrspDeduction"));
		rrspDeduction.sendKeys("4000");

		WebElement taxPaid = driver.findElement(By.id("incomeTaxesPaid"));
		taxPaid.sendKeys("10510");

		WebElement refundOwingAmt = driver.findElement(By.id("refundOrAmountOwing"));
		String actual = refundOwingAmt.getText();

		Assert.assertEquals("$1,186", actual);
		;

	
		driver.close();

	}

}
