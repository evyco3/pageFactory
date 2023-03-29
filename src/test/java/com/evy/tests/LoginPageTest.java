package com.evy.tests;

import com.evy.listener.ListenerTestNG;
import com.evy.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTestNG.class)

public final class LoginPageTest extends BaseTest {
    private LoginPageTest(){}
    @Test
    public void tc_loginLogout() {
        String loginPageTitle=new LoginPage()
                .loginToApplication("administrator@localhost.com","administrator")
                .getUserDropdown()
                .logoffFromApplication()
                .getPageTitle();
        Assertions.assertThat(loginPageTitle).isEqualTo("qdPM | Login");
    }
}
