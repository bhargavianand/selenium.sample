package selenium.sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable2 {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
	
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/gro");
		
	}
	
	/**
	 * 
	 * Test CaseID : TC001
	 * Date: 13-01-2021
	 * Author: Bhargavi
	 * TestCase Title : Verify Number of column headers displayed in gainers page 
	 * 
	 */
	
@Test(enabled=false)
public void NumberOfColumnsTest() {		
		List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));		
		Assert.assertEquals(5, cols.size());	
	}

/**
 * 
 * Test CaseID : TC002
 * TestCase Title: Verify that Group based display of companies 
 * Date: 13-01-2021
 * Author: Bhargavi
 * 
 */
@Test
public void Verify_Group_based_display_of_companies() {
	boolean flag = false;
	try {
			driver.findElement(By.xpath("//a[contains(text(),\"Group A\")]")).click();
			if(driver.findElement(By.xpath("//strong[contains(text(),\"Group A\")]")).isDisplayed()) 
				{
					List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
					System.out.println("Number of rows displayed is " + rows.size());
					for(int i=1;i<rows.size();i++) {
						String actualText = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[2]")).getText();
							System.out.println(actualText);
						if(actualText.equalsIgnoreCase("A")) {
								flag = true;
							}
							else
								flag = false;
					}
		
				}
			if(flag) {
				System.out.println("Group A elements");
			}
			else
				System.out.println("Others group elements are also displayed");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

}
