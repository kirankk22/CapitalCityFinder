Write a dynamic xpath that would return the capital city corresponding to a country.

For example, if I write 'Afghanistan' in the xpath, the xpath should return 'Kabul';
if I write 'Albania', it must return 'Tirana' and so on. 

Use the following website URL :
https://www.countries-ofthe-world.com/capitals-of-the-world.html

This is implemented with 

1. Java-Selenium (CapitalCityFinder.java)
2. Page Object Model (CapitalCityPage.java, CapitalCityTest.java)
3. TestNG Data Provider (CapitalCityTestNGTest.java)
4. Excel Data (CapitalValidationUsingExcelTest.java)
5. Rest Assured (CapitalCityAPITest)
6. Extent Report

============================================

                 Test Plan Document


Test Plan ID
TP-001-CountryCapitalVerification

Project Overview
This test plan covers the automated validation of capital cities corresponding to their countries on the website:
https://www.countries-ofthe-world.com/capitals-of-the-world.html

It ensures that for a given input country, the correct capital is returned using dynamic XPath expressions with data-driven input from Excel.

Scope

In Scope:
- Web automation using Selenium and TestNG
- Data-driven test execution using Apache POI with Excel
- Dynamic XPath validation
- Browser: Chrome
  
Out of Scope:
- Testing other website sections
- Performance/load testing
- Non-country data
  
Test Objectives
- Validate capital city for each country in Excel
- Ensure XPath locators are robust
- Log mismatches and assert failures
  
Tools and Technologies

Language: Java
Test Framework: TestNG
Automation: Selenium WebDriver
Data Input: Apache POI (Excel)
Dependency Mgmt: Maven
Browser: Chrome

Test Data
Excel File: testdata.xlsx
| Country     | Capital   |
|-------------|-----------|
| Afghanistan | Kabul     |
| Albania     | Tirana    |
| Australia   | Canberra  |

Test Environment

OS: Windows/macOS/Linux
Java: 17 or 21
Browser: Chrome
Selenium: 4.17+
Excel path: src/test/resources/testdata.xlsx

Entry and Exit Criteria

Entry Criteria:
- Website is accessible
- Excel input is ready
- Dependencies resolved
  
Exit Criteria:
- All test cases executed
- Results logged
- Issues documented
  
Test Scenarios & Cases

| ID    | Scenario                         | Input        | Expected Result  |
|-------|----------------------------------|--------------|------------------|
| TC001 | Validate capital of Afghanistan  | Afghanistan  | Kabul            |
| TC002 | Validate capital of Albania      | Albania      | Tirana           |
| TC003 | Validate capital of Australia    | Australia    | Canberra         |

Risks & Mitigation
- XPath breaks -> Use robust dynamic XPath
- HTML spacing -> Use normalize-space()
- Browser issues -> Test on Chrome only
  
Deliverables
- Source code
- testdata.xlsx
- TestNG Report
- Test Plan Document
  
Review and Approvals

Name: [Kiran], Role: QA Engineer, Date: 2025-05-05

Name: [Manager], Role: QA Manager,    Date: 2025-05-05


