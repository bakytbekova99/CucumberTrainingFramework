package utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement location, String value, String methodName){
        Select select = new Select(location);
        switch (methodName.toLowerCase()){
            case "text":
            select.selectByVisibleText(value);
            break;

            case "value":
                select.selectByValue(value);
                break;

            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                Assert.fail("The method name is not matching with text, value or index");
        }

    }
    public static void JSClick(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
    public static void JSScroll(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    public static void switchWindow(WebDriver driver, String title){
        Set<String> pageIDs = driver.getWindowHandles();
        for (String pageID : pageIDs) {
            driver.switchTo().window(pageID);
            if (driver.getTitle().contains(title)){
                break;
            }
        }
    }

    public static void waitTime(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public static void getScreenShotForCucumber(WebDriver driver, Scenario scenario){
        Date currentDate=new Date();
        String screenShotFileName=currentDate.toString().replace(" ","-").replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/" + screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
