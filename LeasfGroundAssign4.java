package week2day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeasfGroundAssign4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		/////Edit
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys("Sangeetha", Keys.TAB);
		String defaultText = driver.findElement(By.xpath("//input[@value='TestLeaf']")).getAttribute("value");
		System.out.println(defaultText);
		driver.findElement(By.xpath("//input[contains(@value,'Clear')] ")).clear();
		boolean enabled = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/div/div/input"))
				.isEnabled();

		if (enabled == true) {
			System.out.println("filed is enabled");
		} else {
			System.out.println("filed is disabled");
		}
	
	}
}
