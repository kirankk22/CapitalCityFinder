package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CapitalCityPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CapitalCityTest {
	public static void main(String[] args) {
		// set chrome driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Open the URL
			driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
			driver.manage().window().maximize();

			// Create Page Object
			CapitalCityPage capitalPage = new CapitalCityPage(driver);

			// Example usage
			String country = "Afghanistan";
			String capital = capitalPage.getCapitalByCountry(country);

			System.out.println("Capital of " + country + " is: " + capital);

		} catch (Exception e) {
			System.out.println("Test failed: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}