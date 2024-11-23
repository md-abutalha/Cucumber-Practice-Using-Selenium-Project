package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    //locator
    public WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    //click
    public void clickElement(By locator) {
        getElement(locator).click();
    }

    //write on element
    public void writeOnElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    //pageURL
    public String getPageUrl() {
        return getDriver().getCurrentUrl();
    }

    //pageTitle
    public String getPageTitle() {
        return getDriver().getTitle();
    }

    //page url 18 tharik class
    public void loadWebPage(String url) {
        getDriver().get(url);

    }

    public Boolean isElementVisible(By locator) {
       try {
           return getElement(locator).isDisplayed();
       }catch (Exception e){
           return false;
       }
    }

    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }



}
