package com.zestmoney.qa.testcases;

import com.zestmoney.qa.Base.TestBase;
import com.zestmoney.qa.Pages.HomePage;
import com.zestmoney.qa.Util.testUtil;
import org.testng.annotations.*;
import java.util.Random;

public class HomePageTest extends TestBase {

    private HomePage homePage;

    public HomePageTest(){
        super();
    }

   @BeforeClass
   public void setUp(){
       initialization();
       homePage = new HomePage();
       testUtil.waitForPageToLoad(driver);
    }

    @Test(priority = 1, description = "Searching with particular text")
    public void search() {
        homePage.searchForInput("Club Mahindra");
   }

    @Test(priority = 2, description = "Click on first results tab", dependsOnMethods = "search")
    public void clickOnFirstSearchResult() {
        homePage.clickOnSearchResult();
    }

    @Test(priority = 3, description = "Click on Write a review", dependsOnMethods = "clickOnFirstSearchResult")
    public void clickOnWriteReview() {
        homePage.clickOnWriteReviewButton();
    }

   @Test(priority = 4, description = "Mouse hover and click on fifth star for overall rating", dependsOnMethods = "clickOnWriteReview")
    public void hoverFirstRating() throws InterruptedException {
        homePage.hoverOverallRating();
    }

    @Test(priority = 5, description = "Set title of review")
    public void reviewTitle() {
        homePage.setTitle("AutomatedReview");
    }

   @Test(priority = 6, description = "Set random review description")
    public void reviewDescription(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 200;
        Random random = new Random();

        String randomText = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        homePage.setDescription(randomText);
    }

    @Test(priority = 7, description = "Check for Hotel Ratings option and rate")
    public void hotelRating() throws InterruptedException {
            homePage.setHotelRating();
    }

    @Test(priority = 8, description = "Click on checkbox")
    public void checkBox() {
        homePage.selectCheckBox();
    }

   @AfterClass
    public void tearDown() throws InterruptedException {
       Thread.sleep(3000);
       driver.quit();
   }
}
