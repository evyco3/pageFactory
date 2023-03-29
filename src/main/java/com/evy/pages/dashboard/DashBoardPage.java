package com.evy.pages.dashboard;

import com.evy.driver.Driver;
import com.evy.pages.dashboard.components.SideNavBar;
import com.evy.pages.dashboard.components.UserDropdown;
import org.openqa.selenium.support.PageFactory;

public final class DashBoardPage  {
    private UserDropdown userDropdown;
    private SideNavBar sideNavBar;

    public DashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        userDropdown=new UserDropdown();
        sideNavBar=new SideNavBar();
    }
    public UserDropdown getUserDropdown(){
        return userDropdown;
    }
    public SideNavBar getSideNavBar(){
        return sideNavBar;
    }
}
