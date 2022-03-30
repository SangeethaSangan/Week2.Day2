package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DelecteLeadAssign2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		/// select first leadid
		Thread.sleep(10000);
		WebElement leadid = driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'partyId')]"));
		String text = leadid.getText();
		System.out.println("Print lead id" + text);
		leadid.click();
		//// delete selected lead id
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		///// check whether lead id is deleted or not
		driver.findElement(By.xpath("//a[contains(text(),'Catalog')]/preceding::a[text()='Find Leads']")).click();
		driver.findElement(By.name("id")).sendKeys(text);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("page info" + text2);

		if (text2.contains("No records")) {

			System.out.println(" Lead id is deleted sucessfully!!");
		} else {
			System.out.println(" Lead id is not deleted");
		}

		/*
		 * driver.findElement(By.xpath("//span[text()='Phone']")).click();
		 * driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("");
		 * driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(
		 * "9973757439");
		 * driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 * Thread.sleep(10000); WebElement element = driver.findElement(By.xpath(
		 * "//table[contains(@class,'table')]//tr//div[contains(@class,'Id')]/a[contains(@href,'partyId')]"
		 * )); String text = element.getText(); System.out.println("print leadid" +
		 * text); element.click();
		 */

	}

}
