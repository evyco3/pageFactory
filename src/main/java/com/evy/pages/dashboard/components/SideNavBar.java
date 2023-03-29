package com.evy.pages.dashboard.components;

import com.evy.driver.Driver;
import com.evy.pages.BasePage;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public final class SideNavBar extends BasePage {
    public SideNavBar(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    private SideNavBar setMainSideBar(String mainSideBar){
        String main_side_navBar = "//ul[@class='page-sidebar-menu']/li/a/span[@class='title'][text()='%s']";
        String value=String.format(main_side_navBar,mainSideBar);
        click(Driver.getDriver().findElement(By.xpath(value)), String.valueOf(mainSideBar));
        return this;
    }
    private SideNavBar setSubSideBar(String item){
        String sub_side_nav_bar = "//ul[@class='sub-menu']//span[text()='%s']";
        String value=String.format(sub_side_nav_bar,item);
        click(Driver.getDriver().findElement(By.xpath(value)),item );
        return this;
    }
    @SneakyThrows
    public <T>T setSideBarItems(String main,String sub,Class<T> cls){
        setMainSideBar(main);
        setSubSideBar(sub);
        return  cls.getDeclaredConstructor().newInstance();
    }




}
