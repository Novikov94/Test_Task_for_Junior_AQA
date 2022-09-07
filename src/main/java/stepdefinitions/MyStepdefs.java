package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import pages.SearchResultPage;
import pages.SignInPage;


import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;

public class MyStepdefs {

    private static final long DEFAULT_TIMEOUT = 100;

    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    PageFactoryManager pageFactoryManager;

    SignInPage signInPage;

    @Before
    public void testsSetUp() {
        edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }


    @Given("Open {string} of website")
    public void openHomePageOfWebsite(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSearchField());
        Assert.assertTrue(homePage.isSearchFieldVisible());
        Assert.assertTrue(homePage.isSubmitBtnVisible());
    }


    @When("user clicks on the search button")
    public void userClicksOnTheSearchButton() {
        homePage.clickOnSearchField();
        Assert.assertTrue(homePage.isPopUpWithCityVisible());
    }

    @And("user enters {string}")
    public void userEntersCity(String city) {
        homePage.enterCityToSearchField(city);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getPopUpWithCity());
        Assert.assertTrue(homePage.isPopUpWithCityVisible());
    }

    @And("user select start date and end date")
    public void userSelectStartDateAndEndDate() {
        homePage.clickOnCheckIn();
        homePage.checkThatMonthIsCorrect();
        homePage.selectFirstDate();
        homePage.selectEndDate();
    }

    @And("user clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        homePage.clickOnSubmitBtn();
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getTitleOfSearching());
        Assert.assertTrue(searchResultPage.isTitleVisible());
    }


    @Then("check that all hotels contain New York")
    public void checkThatAllHotelsContainNewYork() {
        Assert.assertTrue(searchResultPage.checkThatEachHotelFromNewYork());
    }

    @Then("check that this page is first")
    public void checkThatThisPageIsFirst() {
        Assert.assertTrue(searchResultPage.isFirstPageSelected());
    }

    @Then("check date matching.")
    public void checkDateMatching() {
        String expected_start_date = "Thursday 1 December 2022";
        String expected_end_date = "Saturday 31 December 2022";
        Assert.assertTrue(searchResultPage.getInfoFromDateDisplayField().contains(expected_start_date));
        Assert.assertTrue(searchResultPage.getInfoFromEndDateDisplayField().contains(expected_end_date));
    }

    @When("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        homePage.clickSignInBtn();
        signInPage = pageFactoryManager.getSignInPage();
        Assert.assertTrue(signInPage.isEmailTextFieldVisible());
    }

    @And("User enters {string}")
    public void userEntersEmail(final String email) {
        String expected_email = "user1994@gmail.com";
        signInPage.enterEmail(email);
        Assert.assertTrue(expected_email.equals(email));

    }

    @And("User clicks on continue button")
    public void userClicksOnContinueButton() {
        signInPage.clickOnSubmitBtn();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordTextField());
        Assert.assertTrue(signInPage.isPasswordTextFieldVisible());
    }

    @And("User enter {string}")
    public void userEnterPassword(final String password) {
        String expected_password = "User1994kram";
        signInPage.enterPassword(password);
        Assert.assertTrue(expected_password.equals(password));
    }

    @And("user clicks on confirm button")
    public void userClicksOnConfirmButton() {
        signInPage.clickOnSubmitBtn();
    }


    @Then("Check that user logged in.")
    public void checkThatUserLoggedIn() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getUserAvatar());
        Assert.assertTrue(homePage.isUserAvatarVisible());
    }
}
