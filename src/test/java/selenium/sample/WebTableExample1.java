package selenium.sample;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableExample1 {
	
	public static void main(String[] args) {
		

		
		
		/* USING DESIRED CAPABILITIES TO SET GECKODRIVER
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(cap);
		driver.get("https://demoqa.com");
	*/
		
		
		/*
	//	System.setProperty("webdriver.gecko.driver", "C:/Users/bharg/Downloads/geckodriver-v0.28.0-win64/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		*/
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://money.rediff.com/gainers/bsc/daily/gro");
		
		//getting number of rows and columns
		
		List<WebElement> cols  = driver.findElements(By.xpath("//table/thead/tr/th"));
		
		System.out.println("Number of cols is " + cols.size());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
		System.out.println("number of rows displayed is "+ rows.size());
		
		
		
		//get rownumber and col number of a certain value in the table
		
		
		//assume the value to search is "Borosil Renewables"
		String search = "NCC";
		for(int i=1;i<rows.size();i++) {
			
			for(int j=1;j<=cols.size();j++) {
				
				String txt = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
				if(txt.equalsIgnoreCase("NCC")) {
					System.out.println("position of the txt is " + i + " row " + " " + j + " column");
				}
			}
		}
	
	}
	

}
