package programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CapitalCityFinder {

	public static void main(String[] args) {
		//set chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		try {
			
			//navigate to website
			driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
			driver.manage().window().maximize();
			
			
			//country input
			String country = "India";
			
			//Dynamic xpath to find the capital city
			String xpath = "//td[text()='" + country + "']/following-sibling::td";
			
			//locate element and get the capital
			WebElement capitalElement = driver.findElement(By.xpath(xpath));
			String capital = capitalElement.getText();
			
			//output the result
			System.out.println("Capital of " + country + " is : " + capital);
			
			
		} catch(Exception e) {
			System.out.println("Error : " + e.getMessage());
		} finally {
			//close browser
			driver.quit();
		}
		
	}

}
