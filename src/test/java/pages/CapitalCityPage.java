package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CapitalCityPage {
	//set chrome driver
	private WebDriver driver;
	
	  // Constructor
    public CapitalCityPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get capital based on country
    public String getCapitalByCountry(String country) {
    	String xpath = "//td[text()='" + country + "']/following-sibling::td";
        WebElement capitalElement = driver.findElement(By.xpath(xpath));
        return capitalElement.getText();
    }

}
