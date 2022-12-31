package com.mycompany.testmavin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class TestMavinIT {

    static WebDriver driver;

    @org.testng.annotations.BeforeTest
    public static void setUpClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @org.testng.annotations.AfterTest
    public static void tearDownClass() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }

    @DataProvider(name = "testLogin")
    public Object[][] datasetLogin() {
        return new Object[][]{{
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
            "username",
            "Admin",
            "password",
            "admin123",
            "orangehrm-login-button",
            "oxd-userdropdown-name",
            "Mohammed lastName",}};
    }

    @org.testng.annotations.Test(dataProvider = "testLogin")
    public void testLogin(String urlVisitor, String userName, String nameVal, String password, String passwVal, String btn, String value, String expectedValue) throws Exception {

        driver.get(urlVisitor);
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.name(userName));
        name.sendKeys(nameVal);
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.name(password));
        pass.sendKeys(passwVal);
        Thread.sleep(2000);
        driver.findElement(By.className(btn)).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.className(value)).getText(), expectedValue);
        Thread.sleep(2000);
    }

    @DataProvider(name = "tesOpenDrawer")
    public Object[][] datasetOpenDrawer() {
        return new Object[][]{{"bi-chevron-left"}};
    }

    @org.testng.annotations.Test(dataProvider = "tesOpenDrawer")
    @Test
    public void testOpenDrawer(String biChevronLeftBtn) throws Exception {
        WebElement openDrawer = driver.findElement(By.className(biChevronLeftBtn));
        openDrawer.click();
        Thread.sleep(2000);
        openDrawer.click();
        Thread.sleep(2000);
    }

    @DataProvider(name = "testSignOut")
    public Object[][] datasetSignOut() {
        return new Object[][]{{
            "oxd-userdropdown-tab",
            "//ul[@role='menu']/li[4]",}};
    }

    @org.testng.annotations.Test(dataProvider = "testSignOut")
    @Test
    public void testSignOut(String classDropDown, String textLogOut) throws Exception {
        WebElement openToLogOut = driver.findElement(By.className(classDropDown));
        openToLogOut.click();
        WebElement logOut = driver.findElement(By.xpath(textLogOut));
        Thread.sleep(1000);
        logOut.click();
        Thread.sleep(2000);
    }

    @DataProvider(name = "testOneItemPim")
    public Object[][] datasetOneItemPim() {
        return new Object[][]{{
            "#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(1) > div:nth-child(2) > input",
            "abdelrhman",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(2) > div:nth-child(2) > input",
            "aboMesalam",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(1) > div.oxd-grid-1.orangehrm-full-width-grid > div > div > div.--name-grouped-field > div:nth-child(3) > div:nth-child(2) > input",
            "effat",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-form-header > div > label > span",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div:nth-child(4) > div > div:nth-child(1) > div > div:nth-child(2) > input",
            "ali youssef2",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-password-row > div > div.oxd-grid-item.oxd-grid-item--gutters.user-password-cell > div > div:nth-child(2) > input",
            "123456@@@Qaa&*#02",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-form > div.oxd-form-row.user-password-row > div > div:nth-child(2) > div > div:nth-child(2) > input",
            "123456@@@Qaa&*#02", "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.orangehrm-employee-container > div.orangehrm-employee-image > div > div:nth-child(2) > div > div > img",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space",}};
    }

    @org.testng.annotations.Test(dataProvider = "testOneItemPim")
    @Test
    public void testOneItemPimAdd(String getLink, String btnAdd, String getFirstName, String setFirstName, String getMiddleName, String setMiddleName, String getLastName, String setLastName, String getSwitchLink, String getUserName, String setUserMame, String getPassword, String setPassword, String getConfirmPssword, String setConfirmPassword, String getImageOfUser, String setImage, String getOpen, String getSaveBtn) throws Exception {
        driver.findElement(By.cssSelector(getLink)).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(btnAdd)).click();
        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.cssSelector(getFirstName));
        firstName.sendKeys(setFirstName);
        Thread.sleep(1000);
        WebElement middleName = driver.findElement(By.cssSelector(getMiddleName));
        middleName.sendKeys(setMiddleName);
        Thread.sleep(1000);
        WebElement lastName = driver.findElement(By.cssSelector(getLastName));
        lastName.sendKeys(setLastName);
        Thread.sleep(1000);
        WebElement switchCheck = driver.findElement(By.cssSelector(getSwitchLink));
        switchCheck.click();
        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.cssSelector(getUserName));
        userName.sendKeys(setUserMame);
        Thread.sleep(1000);
        WebElement pass = driver.findElement(By.cssSelector(getPassword));
        pass.sendKeys(setPassword);
        Thread.sleep(1000);
        WebElement cconfirmPass = driver.findElement(By.cssSelector(getConfirmPssword));
        cconfirmPass.sendKeys(setConfirmPassword);
        Thread.sleep(2000);
        WebElement saveBtn = driver.findElement(By.cssSelector(getSaveBtn));
        saveBtn.click();
        Thread.sleep(2000);
    }

    @DataProvider(name = "testSelectEmployeeStatusAndSearch")
    public Object[][] datasetSelectEmployeeStatusAndSearch() {
        return new Object[][]{{"#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > ul > li:nth-child(2) > a",
            "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]",
            "#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.oxd-table-filter > div.oxd-table-filter-area > form > div.oxd-form-actions > button.oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"}};
    }

    @org.testng.annotations.Test(dataProvider = "testSelectEmployeeStatusAndSearch")
    @Test
    public void testSelectEmployeeStatusAndSearch(String drowDownEmployeeStatus, String getInput, String btnSearch) throws Exception {

        driver.findElement(By.cssSelector(drowDownEmployeeStatus)).click();
        Thread.sleep(2000);
        WebElement select = driver.findElement(By.xpath(getInput));
        Thread.sleep(2000);
        select.sendKeys(Keys.ARROW_DOWN);
        select.sendKeys(Keys.ARROW_DOWN);
        select.click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(btnSearch)).click();
        Thread.sleep(3000);

    }

    @DataProvider(name = "deleteItem")
    public Object[][] datasetdeleteItem() {
        return new Object[][]{{"#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-container > div > div.oxd-table-body > div:nth-child(1) > div > div:nth-child(9) > div > button:nth-child(1)",
            "#app > div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered > div > div > div > div.orangehrm-modal-footer > button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin"}};
    }

    @org.testng.annotations.Test(dataProvider = "deleteItem")
    @Test
    public void testDeleteItem(String iconDeleteLink, String deleteYesBtn) throws Exception {

        WebElement delete = driver.findElement(By.cssSelector(iconDeleteLink));
        delete.click();
        Thread.sleep(2000);
        WebElement deleteYesBtton = driver.findElement(By.cssSelector(deleteYesBtn));
        Thread.sleep(1000);
        deleteYesBtton.click();
        Thread.sleep(7000);
    }

    @DataProvider(name = "testTabs")
    public Object[][] datasetTaps() {
        return new Object[][]{{
            ".oxd-main-menu-item[href='/web/index.php/admin/viewAdminModule']",
            "oxd-topbar-header-breadcrumb-level",
            "User Management",
            ".oxd-main-menu-item[href='/web/index.php/pim/viewPimModule']",
            "oxd-topbar-header-breadcrumb-module",
            "PIM",
            ".oxd-main-menu-item[href='/web/index.php/leave/viewLeaveModule']",
            "Leave",
            ".oxd-main-menu-item[href='/web/index.php/time/viewTimeModule']",
            "Time",
            ".oxd-main-menu-item[href='/web/index.php/recruitment/viewRecruitmentModule']",
            "Recruitment",
            ".oxd-main-menu-item[href='/web/index.php/pim/viewMyDetails']",
            "orangehrm-main-title",
            "Personal Details",
            ".oxd-main-menu-item[href='/web/index.php/performance/viewPerformanceModule']",
            "Performance",
            ".oxd-main-menu-item[href='/web/index.php/dashboard/index']",
            "Dashboard",
            ".oxd-main-menu-item[href='/web/index.php/directory/viewDirectory']",
            "Directory",
            ".oxd-main-menu-item[href='/web/index.php/maintenance/viewMaintenanceModule']",
            "orangehrm-admin-access-title",
            "Administrator Access",
            "password",
            "admin123",
            "orangehrm-admin-access-button",
            ".oxd-main-menu-item[href='/web/index.php/buzz/viewBuzz']",
            "Buzz"
        }};
    }

    @org.testng.annotations.Test(dataProvider = "testTabs")
    public void testTabs(String adminButton, String tab, String tab_text, String pimButton, String pim_tab, String pim_text, String leaveButton, String leave_text,
            String timeButton, String time_text, String recruitButton, String recruit_text,
            String infoButton, String info_tab, String info_text, String performButton, String perform_text, String dashButton, String dash_text, String directButton, String direct_text, String maintainButton, String maintain_tab, String maintain_text, String pass_field, String pass_value,
            String confirmButton, String buzz_Button, String buzz_text) throws Exception {
        driver.findElement(By.cssSelector(adminButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(tab)).getText(), tab_text);
        driver.findElement(By.cssSelector(pimButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), pim_text);
        driver.findElement(By.cssSelector(leaveButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), leave_text);
        driver.findElement(By.cssSelector(timeButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), time_text);
        driver.findElement(By.cssSelector(recruitButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), recruit_text);
        driver.findElement(By.cssSelector(infoButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(info_tab)).getText(), info_text);
        driver.findElement(By.cssSelector(performButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), perform_text);
        driver.findElement(By.cssSelector(dashButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), dash_text);
        driver.findElement(By.cssSelector(directButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), direct_text);
        driver.findElement(By.cssSelector(maintainButton)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.className(maintain_tab)).getText(), maintain_text);
        driver.findElement(By.name(pass_field)).sendKeys(pass_value);
        driver.findElement(By.className(confirmButton)).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(buzz_Button)).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.className(pim_tab)).getText(), buzz_text);

    }

}
