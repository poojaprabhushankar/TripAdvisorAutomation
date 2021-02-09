package com.zestmoney.qa.Util;
import com.zestmoney.qa.Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testUtil extends TestBase {

    public static WebElement waitTillElementIsClickable(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void scrollTillView(WebDriver driver, WebElement section){
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView();", section);
    }

    public static void waitForPageToLoad(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public static void hoverAndRate(WebDriver driver, WebElement element) throws InterruptedException {
        Actions actions = new Actions(driver);

        actions.moveToElement(element,-50,0).build().perform();
        Thread.sleep(500); //Using sleeps just to visualise mouse hover on each
        actions.moveToElement(element,-30,0).build().perform();
        Thread.sleep(500);
        actions.moveToElement(element,0,0).build().perform();
        Thread.sleep(500);
        actions.moveToElement(element,30,0).build().perform();
        Thread.sleep(500);
        actions.moveToElement(element,50,0).click().build().perform();
    }

}
