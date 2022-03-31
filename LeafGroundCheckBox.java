package week2day2;

import java.nio.channels.SelectableChannel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		WebElement checkbox1 = driver.findElement(
				By.xpath("//label[contains(text(),'languages')]/following-sibling::input[@type='checkbox']" + ""));
		checkbox1.click();

		WebElement checkbox2 = driver.findElement(
				By.xpath("//label[contains(text(),'Confirm')]/following-sibling::input[@type='checkbox'][1]"));
		boolean b = checkbox2.isSelected();

		WebElement checkbox3 = driver.findElement(
				By.xpath("//label[contains(text(),'DeSelect')]/following-sibling::input[@type='checkbox'][2]"));
		boolean c = checkbox3.isSelected();
		System.out.println("checkbox3 is selected:" + c);
		if (c == true) {
			checkbox3.click();
			boolean d = checkbox3.isSelected();
			System.out.println("checkbox3 is after unchecked:" + d);

		}

		List<WebElement> checkbox4 = driver.findElements(
				By.xpath("//label[contains(text(),'below ')]/following-sibling::input[@type='checkbox']"));

		int size = checkbox4.size();
		System.out.println("size" + size);
		System.out.println("print value in checkbox4");
		for (int i = 0; i < size; i++) {
			checkbox4.get(i).click();

		}

	}
}
