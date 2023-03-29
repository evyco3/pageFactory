package com.evy.tests;

import com.evy.enums.MainSideBarType;
import com.evy.enums.SubSideBarType;
import com.evy.listener.ListenerTestNG;
import com.evy.pages.AddTaskPage;
import com.evy.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTestNG.class)
public class AddTaskTest extends BaseTest {
    private AddTaskTest() {
    }

    @Test
    public void tc_addTask() {
        new LoginPage()
                .loginToApplication("administrator@localhost.com", "administrator")
                .getSideNavBar()
                .setSideBarItems(MainSideBarType.TASKS.getName(), SubSideBarType.ADD_TASK.getName(), AddTaskPage.class)
                .setProjectName("Test Project 1")
                .setTaskType("Changes (Hourly rate $15.00)")
                .setTaskName("evi task")
                .setTaskStatus("Lost")
                .setTaskPriority("Low")
                .setTaskLabel("Bug")
                .setTaskDescription("evi task description")
                .setTaskCreateBy("developer");

    }
}
