package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
	
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		driver.navigate().back();

		System.out.println("location:"+driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		System.out.println("background clr is:"+driver.findElement(By.id("color")).getCssValue("background-color"));
		System.out.println("size:"+driver.findElement(By.id("size")).getSize());

	}

}
