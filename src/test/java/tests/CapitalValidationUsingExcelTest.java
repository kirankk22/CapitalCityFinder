package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class CapitalValidationUsingExcelTest {
	
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.countries-ofthe-world.com/capitals-of-the-world.html");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws Exception {
        FileInputStream fis = new FileInputStream(new File("src/test/resources/testdata.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Object[]> data = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header row
            Row row = sheet.getRow(i);
            String country = row.getCell(0).getStringCellValue();
            String expectedCapital = row.getCell(1).getStringCellValue();
            data.add(new Object[] { country, expectedCapital });
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][0]);
    }
    
    @Test(dataProvider = "excelData")
    public void testCapital(String country, String expectedCapital) {
        String xpath = "//td[normalize-space(text())='" + country + "']/following-sibling::td[1]";
        WebElement capitalCell = driver.findElement(By.xpath(xpath));
        String actualCapital = capitalCell.getText().trim();
        System.out.println("Verifying capital for " + country + ": expected=" + expectedCapital + ", actual=" + actualCapital);
        Assert.assertEquals(actualCapital, expectedCapital, "Mismatch for: " + country);
    }

}
