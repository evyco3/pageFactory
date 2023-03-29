package com.evy.pages;

import com.evy.driver.Driver;
import com.evy.pages.dashboard.DashBoardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage extends BasePage{
    @FindBy(name = "login[email]")private WebElement email_textbox;
    @FindBy(name = "login[password]")private WebElement password_textbox;
    @FindBy(css = "button[type='submit']")private WebElement login_btn;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private LoginPage setEmail(String email){
        sendKeys(email_textbox,email,"email");
        return this;
    }
    private LoginPage setPassword(String password){
        sendKeys(password_textbox,password,"password");
        return this;
    }
    private LoginPage clickLoginBtn(){
        click(login_btn,"login button");
        return this;
    }
    public String getPageTitle(){
        return getTitle();
    }
    public DashBoardPage loginToApplication(String email, String password){
        setEmail(email);
        setPassword(password);
        clickLoginBtn();
        return new DashBoardPage();
    }
}
