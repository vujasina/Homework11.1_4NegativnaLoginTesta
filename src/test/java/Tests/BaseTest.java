package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }
    protected String getTextFromWebElement(WebElement webElement){
        String actualText = webElement.getText();
        String actual = webElement.getText().substring(0, webElement.getText().length()-1);
        String [] actualRegexArray = webElement.getText().split("(?<=!)");
        String actualRegexText = actualRegexArray[0];
        return actualRegexText;

    }

    @BeforeMethod
    public void setupBeforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        softAssert = new SoftAssert();

        System.out.println("Before method");
    }
    @AfterMethod
    public void setupAfterMethod(){
        driver.quit();//zatvara sve otvoreno
        System.out.println("After method");
    }

}
