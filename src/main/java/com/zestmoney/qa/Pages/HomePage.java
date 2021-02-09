package com.zestmoney.qa.Pages;

import com.zestmoney.qa.Base.TestBase;
import com.zestmoney.qa.Util.testUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends TestBase {

    @FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[3]/div/div/div[2]/div[2]/div/form/input[1]")
    WebElement searchBar;

    @FindBy(xpath="//*[@id=\"lithium-root\"]/main/div[3]/div/div/div[2]/div[2]/div[2]/form/button[2]")
    WebElement searchButton;

    @FindBy(xpath = "(//div[@class='result inner-columns-wrapper'])[1]")
    WebElement searchedFirstResult;

    @FindBy(xpath = "//span[@class='_2GIfqQkr PsUadXSP test-target-tab-Reviews sLZhlLAo']")
    WebElement tillReviewButton;

    @FindBy(xpath = "//div[@class='_2cefqRQ2']")
    WebElement writeReviewButton;

    @FindBy(xpath = "//*[@id=\"bubble_rating\"]")
    WebElement overallRating;

    @FindBy(xpath = "//*[@id=\"ReviewTitle\"]")
    WebElement titleBar;

    @FindBy(xpath = "//*[@id=\"ReviewText\"]")
    WebElement descBar;

    @FindBy(xpath = "//*[@id=\"DQ_RATINGS\"]")
    WebElement hotelRating;

    @FindBy(xpath = "(//div[@class='detailsRatings'])[1]")
    WebElement firstHotelRating;

    @FindBy(xpath = "(//div[@class='detailsRatings'])[2]")
    WebElement secondHotelRating;

    @FindBy(xpath = "(//div[@class='detailsRatings'])[3]")
    WebElement thirdHotelRating;

    @FindBy(xpath = "//*[@id=\"noFraud\"]")
    WebElement checkBox;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void searchForInput(String input) {
        searchBar.click();
        searchBar.sendKeys(input);
        searchBar.sendKeys(Keys.ENTER);
    }

    public void clickOnSearchResult() {
        testUtil.waitTillElementIsClickable(driver,searchedFirstResult);
        searchedFirstResult.click();
    }

    public void clickOnWriteReviewButton() {
        //Switching to second tab
        testUtil.waitForPageToLoad(driver);
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        testUtil.waitTillElementIsClickable(driver,writeReviewButton);
        testUtil.scrollTillView(driver,tillReviewButton);
        writeReviewButton.click();
    }

    public void hoverOverallRating() throws InterruptedException {
        //Switching to third tab
        testUtil.waitForPageToLoad(driver);
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(2));

        testUtil.waitTillElementIsClickable(driver,overallRating);
        testUtil.hoverAndRate(driver,overallRating);
    }

    public void setTitle(String title) {
        titleBar.sendKeys(title);
    }

    public void setDescription(String desc) {
        descBar.sendKeys(desc);
    }

    public void setHotelRating() throws InterruptedException {
        if(hotelRating.isDisplayed())
        {
            testUtil.scrollTillView(driver,hotelRating);
            testUtil.hoverAndRate(driver,firstHotelRating);
            testUtil.hoverAndRate(driver,secondHotelRating);
            testUtil.hoverAndRate(driver,thirdHotelRating);
        }
    }

    public void selectCheckBox()
    {
        testUtil.waitTillElementIsClickable(driver,checkBox);
        checkBox.click();
    }

}
