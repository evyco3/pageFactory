package com.evy.pages.dashboard.components;

import com.evy.driver.Driver;
import com.evy.pages.BasePage;
import com.evy.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class UserDropdown extends BasePage {
    @FindBy(css = "li.dropdown.user")private WebElement dropdown_btn;
    @FindBy(xpath = "//*[contains(text(),'Logoff')]")private WebElement logoff_btn;

    public UserDropdown(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private UserDropdown clickDropdown(){
        click(dropdown_btn,"dropdown");
        return this;
    }
    private UserDropdown clickLogOff(){
        click(logoff_btn,"logoff btn");
        return this;
    }
    public LoginPage logoffFromApplication(){
        clickDropdown();
        clickLogOff();
        return new LoginPage();
    }
}
