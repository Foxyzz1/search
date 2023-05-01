

package org.example;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = chromeDriverSetup.getDriver();
        loginPage loginPage = new loginPage(driver);
        loginPage.acceptCookies();                               // The cookies get automatically accepted (if there are any)

        credentialsFile credentials = new credentialsFile();     // The credentials are read from the credentials.json file
        String email = credentials.getEmail();                   // "email" fetched
        String password = credentials.getPassword();             // "password" fetched

        loginPage.enterEmailAndPassword(email, password);        // The email and password gets entered into the fields
        loginPage.clickLoginButton();                            // The login button gets clicked
        loginPage.isLoginSuccessful();                           // Check if the login was successful or not

        searchPage searchPage = new searchPage(driver);
        String searchQuery = "Konrad";

        searchPage.enterSearchQuery(searchQuery);
        if (searchPage.isSearchSuccessful(searchQuery)) {
            logger.infoLogger("Search successful!");
        } else {
            logger.errorLogger("Search unsuccessful!");
        }

        loginPage.logout();                                      // Logout
        driver.quit();
    }
}