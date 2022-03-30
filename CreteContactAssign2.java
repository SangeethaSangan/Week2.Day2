package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreteContactAssign2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");

		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Sangeetha");
		driver.findElement(By.id("lastNameField")).sendKeys("Sangan");
		;
		driver.findElement(By.name("firstNameLocal")).sendKeys("sangee");
		driver.findElement(By.name("lastNameLocal")).sendKeys("SS");
		driver.findElement(By.name("departmentName")).sendKeys("TCSS");
		driver.findElement(By.id("createContactForm_description")).sendKeys("type here");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("ss@gmail.com");
		WebElement dropdown1 = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(dropdown1);
		dd.selectByVisibleText("New York ");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Deactivate ')]/preceding::a[@class='subMenuButton']"))
				.click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.name("importantNote")).sendKeys("notes given here");
		driver.findElement(By.xpath("//textarea[@name=\"importantNote\"]/following::input[@value=\"Update\"]")).click();
		String title = driver.getTitle();

		System.out.println(title);

	}

}
