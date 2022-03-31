package week2day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		WebElement dropdown1 = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(dropdown1);
		dd1.selectByVisibleText("Appium");
		System.out.println("dropdown1" + dd1.getFirstSelectedOption().getText());

		WebElement Dropdown2 = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(Dropdown2);
		dd2.selectByIndex(1);
		System.out.println("Dropdown2:" + dd2.getFirstSelectedOption().getText());

		WebElement dropdown3 = driver.findElement(By.id("dropdown3"));
		Select dd3 = new Select(dropdown3);
		dd3.selectByValue("3");
		System.out.println("Dropdown3:" + dd3.getFirstSelectedOption().getText());

		WebElement Dropdown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));

		Select dd4 = new Select(Dropdown4);
		dd4.selectByVisibleText("Selenium");

		List<WebElement> options = dd4.getOptions();
		System.out.println("Dropdown4 size is :" + dd4.getOptions().size());

		WebElement Dropdown5 = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		Select dd5 = new Select(Dropdown5);
		boolean c = dd5.isMultiple();
		System.out.println("dropdown5 is multiple:"+c);
		Dropdown5.sendKeys("Selenium");
		System.out.println("Dropdown5 is :" + dd5.getFirstSelectedOption().getText());

		WebElement Dropdown6 = driver.findElement(By.xpath("//select[@multiple='']"));
		Select dd6 = new Select(Dropdown6);
		boolean b = dd6.isMultiple();
		System.out.println("dropdown6 is multiple:"+b);
		dd6.selectByIndex(2);
		dd6.selectByIndex(3);

		List<WebElement> allSelectedOptions = dd6.getAllSelectedOptions();
		
		int size = dd6.getAllSelectedOptions().size();
		
		System.out.println("selected elements in dropdown6:"+size );
		for (WebElement selectedOption : allSelectedOptions) {
			
			System.out.println(selectedOption.getText());
		}
		
		
		
		
		/*
		 * List<WebElement> options2 = dd6.getOptions();
		 * 
		 * for (WebElement allOption : options2) {
		 * System.out.println("All elements in dropdown" + allOption.getText()); }
		 */
	}

}
