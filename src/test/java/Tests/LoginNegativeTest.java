package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;

public class LoginNegativeTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        System.out.println("Before test");
    }

    @BeforeClass
    public void setUpClass() {
        System.out.println("Before class");
    }

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By buttonLocator = By.cssSelector("button[class='radius']");

    String expectedColor = "rgba(198, 15, 19, 1)";
    String expectedUsernameErrorText = "Your username is invalid!";
    String expectedPasswordErrorText = "Your password is invalid!";
    String actualErrorText;

    @Test
    public void test1() {
        System.out.println("TestNegative_UsernameBlank");
        typeIn(usernameLocator, "");
        typeIn(passwordLocator, Constants.PASSWORD);
        getElement(buttonLocator).click();
        WebElement errorLoginText = driver.findElement(By.cssSelector("#flash"));
        actualErrorText = getTextFromWebElement(errorLoginText);
        String actualColor = errorLoginText.getCssValue("background-color");
        System.out.println(actualColor);

        softAssert.assertEquals(actualColor, expectedColor, "Failed");
        softAssert.assertEquals(actualErrorText.trim(), expectedUsernameErrorText, "Failed");
        softAssert.assertAll();


    }

    @Test
    public void test2() {
        System.out.println("TestNegative_Username+Space");
        typeIn(usernameLocator, Constants.USERNAME + " ");
        typeIn(passwordLocator, Constants.PASSWORD);
        getElement(buttonLocator).click();
        WebElement errorLoginText = driver.findElement(By.cssSelector("#flash"));
        actualErrorText = getTextFromWebElement(errorLoginText);
        String actualColor = errorLoginText.getCssValue("background-color");
        System.out.println(actualColor);

        softAssert.assertEquals(actualColor, expectedColor, "Failed");
        softAssert.assertEquals(actualErrorText.trim(), expectedUsernameErrorText, "Failed");
        softAssert.assertAll();

    }

    @Test
    public void test3() {
        System.out.println("TestNegative_PasswordBlank");
        typeIn(usernameLocator, Constants.USERNAME);
        typeIn(passwordLocator, "");
        getElement(buttonLocator).click();
        WebElement errorLoginText = driver.findElement(By.cssSelector("#flash"));
        actualErrorText = getTextFromWebElement(errorLoginText);
        String actualColor = errorLoginText.getCssValue("background-color");
        System.out.println(actualColor);

        softAssert.assertEquals(actualColor, expectedColor, "Failed");
        softAssert.assertEquals(actualErrorText.trim(), expectedPasswordErrorText, "Failed");
        softAssert.assertAll();

    }

    @Test
    public void test4() {
        System.out.println("TestNegative_Password+Space");
        typeIn(usernameLocator, Constants.USERNAME);
        typeIn(passwordLocator, Constants.PASSWORD + " ");
        getElement(buttonLocator).click();
        WebElement errorLoginText = driver.findElement(By.cssSelector("#flash"));
        actualErrorText = getTextFromWebElement(errorLoginText);
        String actualColor = errorLoginText.getCssValue("background-color");
        System.out.println(actualColor);

        softAssert.assertEquals(actualColor, expectedColor, "Failed");
        softAssert.assertEquals(actualErrorText.trim(), expectedPasswordErrorText, "Failed");
        softAssert.assertAll();
    }

}
