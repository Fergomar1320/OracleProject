package com.springboot.MyTodoList.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ORACLEUSER")
public class OracleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "USER_NAME", length = 4000)
    private String userName;

    @Column(name = "USER_ROLE")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false)
    private ToDoTeam teamId;

    @OneToMany(mappedBy = "userId")
    private Set<ToDoItem> todoItems;

    public OracleUser(){

    }

    public OracleUser(int userId, String userName, UserRole userRole, ToDoTeam teamId){
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.teamId = teamId;
    }

    //getters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public ToDoTeam getTeamId() {
        return teamId;
    }

    //setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setTeamId(ToDoTeam teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "OracleUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                ", teamId=" + teamId +
                '}';
    }

    public Set<ToDoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(Set<ToDoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public enum UserRole{
        Developer,
        Manager
    }

}
