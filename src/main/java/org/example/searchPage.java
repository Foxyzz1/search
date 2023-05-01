package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPage {

    private WebDriver driver;
    private By searchField = By.xpath("//input[@placeholder='Search Facebook']");

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchQuery(String searchQuery) throws InterruptedException {
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.click();
        searchFieldElement.sendKeys(searchQuery);
        searchFieldElement.sendKeys(Keys.ENTER);
        utils.delay(2000);
    }

    // Verify that the search results are accurate and relevant
    public boolean isSearchSuccessful(String searchQuery) {
        try {
            utils.delay(2000);
            // Check if the url contains the search query
            if (driver.getCurrentUrl().contains(searchQuery)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            logger.errorLogger(e.getMessage());
            return false;
        }
    }

}
