package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {



//    object create
    HomePage homePage = new HomePage();


    @Test
    public void homePageUrl(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageUrl(), homePage.url);
    }
    @Test
    public void homePageTitle(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getPageTitle(), homePage.pageTitle);
    }


}
