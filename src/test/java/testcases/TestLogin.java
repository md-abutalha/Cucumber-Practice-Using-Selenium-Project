package testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataSets;
import utilities.DriverSetup;

public class TestLogin extends DriverSetup {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    public void loadtestPage(){
        loginPage.navigateToLoginPage();
    }




    @Test(description = "Test with valid credentials")
    public void testLoginValidCredentials(){
//        getDriver().get(homePage.url);
//        homePage.clickElement(homePage.login_signup);

        loadtestPage();
        homePage.writeOnElement(loginPage.loginEmail,"nalop30291@chysir.com");
        homePage.writeOnElement(loginPage.loginPassword,"nalop30291@chysir.com");
        loginPage.clickElement(loginPage.loginSubmitButton);
        Assert.assertTrue(homePage.isElementVisible(homePage.logOut));
        Assert.assertFalse(loginPage.isElementVisible(loginPage.loginSubmitButton));
    }

    @Test
    public void testLoginInvalidPass(){
        loadtestPage();
        homePage.writeOnElement(loginPage.loginEmail,"nalop30291@chysir.com");
        homePage.writeOnElement(loginPage.loginPassword,"nalop30291@");
        loginPage.clickElement(loginPage.loginSubmitButton);
        Assert.assertEquals(loginPage.getElement(loginPage.errorMessage).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.isElementVisible(homePage.logOut));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.loginSubmitButton));
    }

    @Test
    public void testLoginInvalidEmailAndPass(){
        loadtestPage();
        homePage.writeOnElement(loginPage.loginEmail,"nalop30291@chys.co");
        homePage.writeOnElement(loginPage.loginPassword,"nalop30291@");
        loginPage.clickElement(loginPage.loginSubmitButton);
        Assert.assertEquals(loginPage.getElement(loginPage.errorMessage).getText(), "Your email or password is incorrect!");
        Assert.assertFalse(homePage.isElementVisible(homePage.logOut));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.loginSubmitButton));
    }

    @Test
    public void testLoginBlankEmailAndPass(){
        loadtestPage();
        homePage.writeOnElement(loginPage.loginEmail,"");
        homePage.writeOnElement(loginPage.loginPassword,"");
        loginPage.clickElement(loginPage.loginSubmitButton);
        Assert.assertEquals(loginPage.getElement(loginPage.loginEmail).getAttribute("validationMessage"), "Please fill out this field.");
        Assert.assertFalse(homePage.isElementVisible(homePage.logOut));
        Assert.assertTrue(loginPage.isElementVisible(loginPage.loginSubmitButton));
    }

// just Write one test case for the invliad test case check


    @Test(dataProvider = "invalideCredentials", dataProviderClass = DataSets.class)
    public void testLoginWithInvalidCredentials(String email, String password, String error_msg, String validation_msg){
        loadtestPage();
        homePage.writeOnElement(loginPage.loginEmail,email);
        homePage.writeOnElement(loginPage.loginPassword,password);
        loginPage.clickElement(loginPage.loginSubmitButton);
        Assert.assertEquals(loginPage.getElement(loginPage.loginEmail).getAttribute("validationMessage"), validation_msg);
        Assert.assertEquals(loginPage.getElement(loginPage.loginPassword).getAttribute("validationMessage"), validation_msg);
        if (loginPage.isElementVisible(loginPage.loginSubmitButton))
            Assert.assertEquals(loginPage.getElement(loginPage.errorMessage).getText(), error_msg);
        Assert.assertTrue(loginPage.isElementVisible(loginPage.loginSubmitButton));
    }





}

