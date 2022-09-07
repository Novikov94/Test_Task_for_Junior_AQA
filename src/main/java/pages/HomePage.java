package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    String month = "December 2022";

    public WebElement getUserAvatar() {
        return userAvatar;
    }

    @FindBy(xpath = "//div[@class ='bui-avatar-block']")
    private WebElement userAvatar;
    @FindBy(xpath = "//a[@class = 'bui-button bui-button--secondary js-header-login-link'][1]")
    private WebElement signInBtn;

    @FindBy(xpath = "//input[@class = 'c-autocomplete__input sb-searchbox__input sb-destination__input']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class =  'sb-searchbox__button ']")
    private WebElement submitBtn;

    @FindBy(xpath = "//span[@class ='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb'][1]")
    private WebElement checkIn;

    @FindBy(xpath = "//div[@class ='sb-date-field__display'][2]")
    private WebElement checkOut;

    @FindBy(xpath = "//div[@class ='sb-autocomplete__section-title']")
    private WebElement popUpWithCity;

    @FindBy(xpath = "//div[@class= 'bui-calendar']")
    private WebElement calendar;

    @FindBy(xpath = "//li[@class = 'c-autocomplete__item sb-autocomplete__item sb-autocomplete__item-with_photo " +
            "sb-autocomplete__item__item--elipsis sb-autocomplete__item--icon_revamp sb-autocomplete__item--city']")
    private WebElement searchCityInList;

    @FindBy(xpath = "//div[@class= 'bui-calendar__control bui-calendar__control--next']")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//div[@class= 'bui-calendar__month'][1]")
    private WebElement nameOfMonth;

    @FindBy(xpath = "//td[@data-date = '2022-12-01']")
    private WebElement firstDate;

    @FindBy(xpath = "//td[@data-date = '2022-12-31']")
    private WebElement endDate;


    public boolean isUserAvatarVisible() {
        userAvatar.isDisplayed();
        return true;
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public boolean isCalendarDisplayed() {
        calendar.isDisplayed();
        return true;
    }

    public void selectFirstDate() {
        firstDate.click();
    }

    public void selectEndDate() {
        endDate.click();
    }

    public void checkThatMonthIsCorrect() {
        while (true) {
            String text = nameOfMonth.getText();
            if (text.equals(month)) {
                break;
            } else {
                nextMonthBtn.click();
            }
        }
    }


    public void getTextFromList() {
        searchCityInList.getText();
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public WebElement getCheckIn() {
        return checkIn;
    }

    public WebElement getCheckOut() {
        return checkOut;
    }

    public WebElement getPopUpWithCity() {
        return popUpWithCity;
    }

    public boolean isPopUpWithCityVisible() {
        popUpWithCity.isDisplayed();
        return true;
    }

    public boolean isSearchFieldVisible() {
        searchField.isDisplayed();
        return true;
    }

    public boolean isSubmitBtnVisible() {
        submitBtn.isDisplayed();
        return true;
    }

    public boolean isCheckInVisible() {
        checkIn.isDisplayed();
        return true;
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public void clickOnSearchField() {
        searchField.click();
    }

    public void enterCityToSearchField(String city) {
        searchField.sendKeys(city);
    }

    public void clickOnCheckIn() {
        checkIn.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }
}
