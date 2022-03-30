package week2day2;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.service.DriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadAssign2 {

	public static void main(String[] args) throws InterruptedException {
		/*1	Launch the browser,2	Enter the username,3	Enter the password,
		 * 4	Click Login,5	Click crm/sfa link,
		 * 6	Click Leads link,7	Click Find leads,8	Click on Email,9	Enter Email
		,10	Click find leads button,11	Capture name of First Resulting lead,12	Click First Resulting lead,13	Click Duplicate Lead
		
		,14	Verify the title as 'Duplicate Lead',15	Click Create Lead,16	Confirm the duplicated lead name is same as captured name,
		17	Close the browser (Do not log out)*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
		driver.findElement(By.xpath("//input[@id='password'][@type='password']")).sendKeys("crmsfa",Keys.TAB,Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("sanga.gg@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		
		String getLeadid = driver.findElement(By.xpath("//table[contains(@class,'table')]//tr//div[contains(@class,'partyId')]/a[contains(@href,'partyId')]")).getText();
		
		Thread.sleep(5000);
		WebElement getFN = driver.findElement(By.xpath("//table[contains(@class,'table')]//tr//div[contains(@class,'firstName')]/a[contains(@href,'partyId')]"));
		String firstname = getFN.getText();
		System.out.println("Print first name:"+firstname);
		getFN.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Duplicate')]")).click();
		String title1 = driver.getTitle();
		System.out.println("Print title:"+title1);
		
		////check for different firstname scenario
		/*
		 * WebElement frname = driver.findElement(By.id("createLeadForm_firstName"));
		 * frname.clear(); frname.sendKeys("Mahesh");
		 */
		
	
        driver.findElement(By.xpath("//input[contains(@value,'Create')]")).click();
		String title2 = driver.getTitle();
		String DupFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Print title:"+title2+ "firstname is:"+DupFirstName);
		
		String companyname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String DupLeadId=companyname.substring(companyname.indexOf("(")+1,companyname.indexOf(")"));

		/////Check whether first name is same or not
		 System.out.println("Comparing first name" + firstname + " with duplicate firstname " + DupFirstName
                 + " : " + Objects.equals(firstname, DupFirstName));
		 
		 ////Check whether Leadid is unique
		 System.out.println("Comparing lead id" + getLeadid + " with duplicate lead id " + DupLeadId
                 + " : " + Objects.equals(getLeadid, DupLeadId));
	}
 
}
