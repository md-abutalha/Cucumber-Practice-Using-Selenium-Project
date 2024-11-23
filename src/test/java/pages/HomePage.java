package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
   public String url = "https://automationexercise.com/";
   public String pageTitle = "Automation Exercise";

   public By login_signup = By.xpath("//a[normalize-space()='Signup / Login']");

   public By logOut = By.xpath("//a[normalize-space()='Logout']");

   public void loadHomePage(){
      loadWebPage(url);
   }


}
