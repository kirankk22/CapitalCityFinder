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

Sample Manual Test Cases: Capital City Finder Web App

| **TC ID** | **Test Case Description**                           | **Preconditions**                    | **Test Steps** | **Expected Result**                            | **Status** |                                                                                                                                                                                              | --------- | --------------------------------------------------- | ------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------- | ---------- |
| TC\_001   | Verify that the homepage loads correctly            | Browser launched, Internet connected | 1. Navigate to the URL \[[https://www.countries-ofthe-world.com/capitals-of-the-world.html](https://www.countries-ofthe-world.com/capitals-of-the-world.html)] | Page loads with list of countries and capitals | Pass/Fail  |
| TC\_002   | Validate capital city for given country             | Homepage is loaded                   | 1. Locate the country “Afghanistan”<br>2. Note the adjacent capital column                                                                                     | Capital should be “Kabul”                      | Pass/Fail  |
| TC\_003   | Check dynamic XPath returns correct capital         | Page DOM is inspectable              | 1. Open DevTools<br>2. Use XPath: `//td[text()='Albania']/following-sibling::td`<br>3. Evaluate                                                                | XPath returns “Tirana”                         | Pass/Fail  |
| TC\_004   | Verify page handles invalid countries gracefully    | Homepage is loaded                   | 1. Try searching via DevTools for a country not listed<br>2. Use XPath with invalid country                                                                    | XPath returns no match                         | Pass/Fail  |
| TC\_005   | Verify UI alignment of country and capital columns  | Page is loaded                       | 1. Scroll through table<br>2. Verify data alignment and readability                                                                                            | Columns are well-aligned                       | Pass/Fail  |
| TC\_006   | Check responsiveness on different screen sizes      | Developer tools open                 | 1. Switch to mobile view<br>2. Resize screen<br>3. Scroll and check usability                                                                                  | Table should remain usable                     | Pass/Fail  |
| TC\_007   | Verify source page is not broken or missing content | Website is accessible                | 1. Navigate through the table<br>2. Ensure all entries are visible and none are truncated or missing                                                           | All country-capital pairs are displayed        | Pass/Fail  |
| TC\_008   | Confirm page title and metadata                     | Browser is on correct page           | 1. Inspect title tag<br>2. Check for correct metadata (e.g., charset, description)                                                                             | Page title is accurate and metadata exists     | Pass/Fail  |




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


