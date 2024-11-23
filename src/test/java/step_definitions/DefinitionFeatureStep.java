package step_definitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class DefinitionFeatureStep {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User should be on the login screen")
    public void userShouldBeOnTheLoginScreen() {
        loginPage.navigateToLoginPage();
    }

    @When("User enters a valid username and password")
    public void userEnterValidUsernameAndPassword() {
        homePage.writeOnElement(loginPage.loginEmail, "nalop30291@chysir.com");
        homePage.writeOnElement(loginPage.loginPassword, "nalop30291@chysir.com");
    }

    @And("User clicks on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickElement(loginPage.loginSubmitButton);
    }

    @Then("User should see the logout button")
    public void userShouldSeeTheLogoutButton() {
        Assert.assertTrue(homePage.isElementVisible(homePage.logOut));
    }

    @And("User should navigate to the inventory page")
    public void userShouldNavigateToTheInventoryPage() {
        Assert.assertEquals(homePage.getCurrentUrl(), homePage.url);
    }

    @But("User should not be on the login page")
    public void userShouldNotBeOnTheLoginPage() {
        Assert.assertNotEquals(homePage.getCurrentUrl(), loginPage.loginUrl);
    }

//    2nd scenario
    @When("User enter valid {string} on the user name field")
    public void userEnterValidOnTheUserNameField(String arg0) {
        loginPage.writeOnElement(loginPage.loginEmail,arg0);
    }

    @And("User enter {string} on the password field")
    public void userEnterOnThePasswordField(String arg0) {
        loginPage.writeOnElement(loginPage.loginPassword,arg0);
    }


    @Then("User should see {string} error message")
    public void userShouldSeeErrorMessage(String arg0) {
        if (loginPage.isElementVisible(loginPage.errorMessage)){
            Assert.assertEquals(loginPage.getElement(loginPage.errorMessage).getText(),arg0);
        }

    }


    @When("User enter {string} on the username filed")
    public void userEnterOnTheUsernameFiled(String arg0) {
        loginPage.writeOnElement(loginPage.loginPassword,arg0);
    }


    @Then("User should see {string} validation message")
    public void userShouldSeeValidationMessage(String arg0) {

        Assert.assertEquals(loginPage.getElement(loginPage.loginEmail).getAttribute("validationMessage"),arg0);
    }

    @Then("User should see {string} validation message for username")
    public void userShouldSeeValidationMessageForUsername(String arg0) {
        Assert.assertEquals(loginPage.getElement(loginPage.loginEmail).getAttribute("validationMessage"),arg0);
    }
    @Then("User should see {string} validation message for password")
    public void userShouldSeeValidationMessageForPassword(String arg0) {
        Assert.assertEquals(loginPage.getElement(loginPage.loginPassword).getAttribute("validationMessage"),arg0);
    }


}
