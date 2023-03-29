package com.evy.pages;

import com.evy.driver.Driver;
import com.evy.reports.ExtentTestLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected BasePage(){}
    protected String getTitle(){
       try{
           var title= Driver.getDriver().getTitle();
           ExtentTestLogger.info("Page Title: "+title);
           return title;
       }catch (Exception e){
           ExtentTestLogger.fail("Failed to return Page Title");
           return null;
       }
    }
    protected void sendKeys(WebElement element,String value,String elementName){
        try{
            element.sendKeys(value);
            ExtentTestLogger.info("send keys to "+elementName+":"+value);
        }catch (Exception e){
            ExtentTestLogger.fail("Failed to send to "+elementName);
        }
    }
    protected void click(WebElement element,String elementName){
        try{
            element.click();
            ExtentTestLogger.info("Clicked on "+elementName);
        }catch (Exception e){
            ExtentTestLogger.fail("Failed to click on "+elementName);
        }
    }
    protected void selectByVisibleText(WebElement element,String value,String elementName){
        try{
            Select select=new Select(new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element)));
            select.selectByVisibleText(value);
            ExtentTestLogger.info("Selected "+value+" from "+elementName+" dropdown");
        }catch (Exception e){
            ExtentTestLogger.fail("Failed to select "+value+" from "+elementName+" dropdown");
        }

    }
    protected void switchToFrame(WebElement element){
        try{
            Driver.getDriver().switchTo().frame(element);
            ExtentTestLogger.info("switch to frame.." );
        }catch (Exception e){
            ExtentTestLogger.fail("Failed to switch to frame"+element.getAccessibleName());
        }
    }
    protected void switchToDefaultContent(){
        try{
            Driver.getDriver().switchTo().defaultContent();
            ExtentTestLogger.info("switch to default content");
        }catch (Exception e){
            ExtentTestLogger.fail("Failed to switch to default content");
        }
    }
}
