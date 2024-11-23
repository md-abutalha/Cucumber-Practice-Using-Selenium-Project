package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    HomePage homePage = new HomePage();
    public String loginUrl = "https://automationexercise.com/login";
    public By loginEmail = By.name("email");
    public By loginPassword = By.xpath("//input[@placeholder='Password']");
    public By loginSubmitButton = By.xpath("//button[normalize-space()='Login']");
    public By errorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");



    public void navigateToLoginPage(){
        homePage.loadHomePage();
        homePage.clickElement(homePage.login_signup);
    }

}
