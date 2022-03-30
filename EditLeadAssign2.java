package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLeadAssign2 {

	// 1 Launch the browser ,2 Enter the username,3 Enter the password,4 Click
	// Login,5 Click crm/sfa link,
	// 6 Click Leads link,7 Click Find leads ,8 Enter first name,9 Click Find leads
	// button,10 Click on first resulting lead,11 Verify title of the page,12 Click
	// Edit,
	// 13 Change the company name,14 Click Update,15 Confirm the changed name
	// appears,16 Close the browser (Do not log out)

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

		driver.findElement(By.xpath("//a[contains(text(),'Catalog')]/preceding::a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@id=\"findLeads\"]//input[@name=\"firstName\"]")).sendKeys("Sangeetha");
        driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();

		Thread.sleep(5000);
		WebElement getleadid = driver.findElement(By.xpath(
				"//table[contains(@class,'table')]//tr//div[contains(@class,'partyId')]/a[contains(@href,'partyId')]"));

		String leadid = getleadid.getText();
		System.out.println("print lead id" + leadid);
		getleadid.click();
		String title = driver.getTitle();
		System.out.println("print title" + title);
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		WebElement companyName = driver.findElement(By.id("updateLeadForm_companyName"));
		companyName.clear();
		companyName.sendKeys("TCS");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		WebElement companyname = driver.findElement(By.id("viewLead_companyName_sp"));
		String text = companyname.getText();
		System.out.println("print updated company name" + text);

		

	}

}
