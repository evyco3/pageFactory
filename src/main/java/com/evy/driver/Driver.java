package com.evy.driver;

import com.evy.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {
    private static final ThreadLocal<WebDriver>DRIVER_INSTANCE=new ThreadLocal<>();
    private Driver(){}

    public static void initDriver(){
       if(Objects.isNull(DRIVER_INSTANCE.get())){
           DRIVER_INSTANCE.set(DriverFactory.getDriver(PropertyUtils.get("browser")));
           DRIVER_INSTANCE.get().manage().window().maximize();
           DRIVER_INSTANCE.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
           DRIVER_INSTANCE.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
           DRIVER_INSTANCE.get().get(PropertyUtils.get("url"));
       }
    }
    public static void quitDriver(){
        if(Objects.nonNull(DRIVER_INSTANCE.get())){
            DRIVER_INSTANCE.get().quit();
            DRIVER_INSTANCE.remove();
        }
    }
    public static WebDriver getDriver(){
        return DRIVER_INSTANCE.get();
    }


}
