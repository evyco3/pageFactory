package com.evy.driver;

import com.evy.driver.manager.ChromeDriverManager;
import com.evy.driver.manager.EdgeDriverManager;
import com.evy.driver.manager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.function.Supplier;


public final class DriverFactory {

    private static HashMap<String, Supplier<WebDriver>>MAP=new HashMap<>();
    private DriverFactory(){}

    static {
        MAP.put("chrome", new ChromeDriverManager()::getDriver);
        MAP.put("firefox", new FirefoxDriverManager()::getDriver);
        MAP.put("edge", new EdgeDriverManager()::getDriver);
    }
    public static WebDriver getDriver(String browser){
        return MAP.get(browser).get();
    }


}
