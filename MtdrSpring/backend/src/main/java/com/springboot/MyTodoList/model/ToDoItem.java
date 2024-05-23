package com.springboot.MyTodoList.model;


import javax.persistence.*;

import org.springframework.boot.task.TaskSchedulerCustomizer;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

/*
    representation of the TODOITEM table that exists already
    in the autonomous database
 */

//Edited by Fernando



@Entity
@Table(name = "TODOTASK")
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column(name = "TASK_DESCRIPTION")
    private String taskDescription;

    @Column(name = "TASK_CREATION_TS")
    private Date taskCreationTs;

    @Column(name = "TASK_STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private OracleUser userId;

    @ManyToOne
    @JoinColumn(name = "SPRINT_ID", referencedColumnName = "SPRINT_ID", nullable = false)
    private TodoSprint sprintId;


    public ToDoItem(){

    }

    public ToDoItem(int taskId, String taskDescription, Date taskCreationTs, TaskStatus taskStatus, OracleUser userId, TodoSprint sprintId){
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskCreationTs = taskCreationTs;
        this.taskStatus = taskStatus;
        this.userId = userId;
        this.sprintId = sprintId;
    }

    //getters
    public int getTaskId(){
        return this.taskId;
    }

    public String getTaskDescription(){
        return this.taskDescription;
    }

    public  Date getTaskCreationTS(){
        return this.taskCreationTs;
    }
    
    public TaskStatus getTaskStatus(){
        return this.taskStatus;
    }

    public OracleUser getOracleUser(){
        return this.userId;
    }

    public TodoSprint getTodoSprint(){
        return this.sprintId;
    }

    //setters
    public void setTaskId( int taskId){
        this.taskId = taskId;
    }

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public void setTaskCreation(Date taskCreationTs){
        this.taskCreationTs = taskCreationTs;
    }

    public void setTaskStatus (TaskStatus taskStatus){
        this.taskStatus = taskStatus;
    }

    public void setOracleUser(OracleUser userId){
        this.userId = userId;
    }

    public void setTodoSprint(TodoSprint sprintId){
        this.sprintId = sprintId;
    }

    @Override
    public String toString(){
        return "TodoTask{" +
                "taskId=" + taskId +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskCreationTs=" + taskCreationTs +
                ", taskStatus=" + taskStatus +
                ", userId=" + userId +
                ", sprintId=" + sprintId +
                '}';
    }

    public enum TaskStatus {
        NotStarted, InProgress, Done
    }
}
