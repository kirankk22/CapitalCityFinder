package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CapitalCityTestNGTest {
	WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "countryCapitalData")
    public Object[][] countryCapitalData() {
        return new Object[][] {
            {"Afghanistan", "Kabul"},
            {"Albania", "Tirana"},
            {"Algeria", "Algiers"},
            {"Argentina", "Buenos Aires"},
            {"Australia", "Canberra"}
        };
    }

    @Test(dataProvider = "countryCapitalData")
    public void verifyCapitalCity(String country, String expectedCapital) {
        // Dynamic XPath to get the capital corresponding to the country
    	String xpath = "//td[text()='" + country + "']/following-sibling::td";
        WebElement capitalElement = driver.findElement(By.xpath(xpath));
        String actualCapital = capitalElement.getText().trim();

        System.out.println("Country: " + country + " | Expected: " + expectedCapital + " | Actual: " + actualCapital);
        Assert.assertEquals(actualCapital, expectedCapital, "Capital mismatch for country: " + country);
    }

}
