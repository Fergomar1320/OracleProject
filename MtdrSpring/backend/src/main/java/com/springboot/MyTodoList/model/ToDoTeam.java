package com.springboot.MyTodoList.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TODOTEAM")
public class ToDoTeam {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    @Column(name = "TEAM_NAME" ,length = 4000)
    private String teamName;

    @OneToMany(mappedBy = "teamId")
    private List<OracleUser> users;

    public ToDoTeam(){
        
    }

    public ToDoTeam(int teamId, String teamName){
        this.teamId = teamId;
        this.teamName = teamName;
    }

    //getters
    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<OracleUser> getUsers() {
        return users;
    }

    //setters
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setUsers(List<OracleUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
