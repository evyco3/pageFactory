package com.evy.pages;

import com.evy.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTaskPage extends BasePage {
    @FindBy(id = "form_projects_id")private WebElement project_name_dropdown;
    @FindBy(id = "tasks_tasks_type_id")private WebElement task_type_dropdown;
    @FindBy(id = "tasks_name")private WebElement task_name_textbox;
    @FindBy(id = "tasks_tasks_status_id")private WebElement task_status_dropdown;
    @FindBy(id = "tasks_tasks_priority_id")private WebElement task_priority_dropdown;
    @FindBy(id = "tasks_tasks_label_id")private WebElement task_label_dropdown;
    @FindBy(css = ".cke_wysiwyg_frame.cke_reset")private WebElement task_description_iframe;
    @FindBy(tagName = "p")private WebElement task_description_textbox;
    @FindBy(id = "tasks_created_by")private WebElement task_createdBy_dropdown;


    public AddTaskPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public AddTaskPage setProjectName(String projectName){
        selectByVisibleText(project_name_dropdown,projectName,"project name");
        return this;
    }
    public AddTaskPage setTaskType(String taskType){
        selectByVisibleText(task_type_dropdown,taskType,"task type");
        return this;
    }
    public AddTaskPage setTaskName(String taskName){
        sendKeys(task_name_textbox,taskName,"task name");
        return this;
    }
    public AddTaskPage setTaskStatus(String taskStatus){
        selectByVisibleText(task_status_dropdown,taskStatus,"task status");
        return this;
    }
    public AddTaskPage setTaskPriority(String taskPriority){
        selectByVisibleText(task_priority_dropdown,taskPriority,"task priority");
        return this;
    }
    public AddTaskPage setTaskLabel(String taskLabel){
        selectByVisibleText(task_label_dropdown,taskLabel,"task label");
        return this;
    }
    //add assigned to
    public AddTaskPage setTaskDescription(String taskDescription){
        switchToFrame(task_description_iframe);
        sendKeys(task_description_textbox,taskDescription,"task description");
        switchToDefaultContent();
        return this;
    }
    public AddTaskPage setTaskCreateBy(String taskCreateBy){
        selectByVisibleText(task_createdBy_dropdown,taskCreateBy,"task created by");
        return this;
    }





}
