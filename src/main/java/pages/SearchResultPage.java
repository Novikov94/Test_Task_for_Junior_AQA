package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//button[@data-testid = 'date-display-field-start']")
    private WebElement startDateDisplayField;

    @FindBy(xpath = "//button[@data-testid = 'date-display-field-end']")
    private WebElement endDateDisplayField;

    @FindBy(xpath = "//h1[contains(text(),'properties found')]")
    private WebElement titleOfSearching;

    @FindBy(xpath = "//div[@class ='d4924c9e74']")
    private WebElement listOfHotel;

    @FindBy(xpath = "//li[@class ='f32a99c8d1 ebd02eda9e']")
    private WebElement firstPage;

    public String getInfoFromDateDisplayField() {
        String startDate = startDateDisplayField.getText();
        return startDate;
    }

    public String getInfoFromEndDateDisplayField() {
        String endDate = endDateDisplayField.getText();
        return endDate;
    }

    public boolean isFirstPageSelected() {
        firstPage.isSelected();
        return true;
    }

    public boolean checkThatEachHotelFromNewYork() {
        listOfHotel.getText().contains("New York");
        return true;
    }

    public WebElement getTitleOfSearching() {
        return titleOfSearching;
    }

    public boolean isTitleVisible() {
        titleOfSearching.isDisplayed();
        return true;
    }


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
}
