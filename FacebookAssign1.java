package week2day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookAssign1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		  driver.findElement(By.name("firstname")).sendKeys("Sangeetha");
		  driver.findElement(By.name("lastname")).sendKeys("Sangan");
		  driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(
		  "8056564412");
		  driver.findElement(By.id("password_step_input")).sendKeys("test");
		  WebElement dropdown1 = driver.findElement(By.name("birthday_day"));
		  Select dd1=new Select(dropdown1); dd1.selectByVisibleText("31");
		  
		  WebElement dropdown2 = driver.findElement(By.name("birthday_month")); 
		  Select dd2=new Select(dropdown2); 
		  dd2.selectByIndex(11); 
		  
		  WebElement dropdown3 =driver.findElement(By.name("birthday_year")); 
		  Select dd3=new Select(dropdown3); 
		  dd3.selectByVisibleText("1990");
		  
		  driver.findElement(By.xpath("//label[text()='Female']")).click();
		 
	}

}
