package com.springboot.MyTodoList.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TODOSPRINT")
public class ToDoSprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sprintId;

    @Column(name = "SPRINT_STARRT_DATE")
    private LocalDate sprintStartDate;
    
    @Column(name = "SPRINT_END_DATE")
    private LocalDate sprintEndDate;

    @Column(name = "SPRINT_STATUS")
    @Enumerated(EnumType.STRING)
    private SprintStatus sprintStatus;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "TEAM_ID", nullable = false)
    private Team teamId;

    @OneToMany(mappedBy = "sprintId")
    private List<ToDoItem> todoItems;

    public ToDoSprint(){

    }

    public ToDoSprint(int sprintId, LocalDate sprintStartDate, LocalDate sprintEndDate, SprintStatus sprintStatus, Team teamId){
        this.sprintId = sprintId;
        this.sprintStartDate = sprintStartDate;
        this.sprintEndDate = sprintEndDate;
        this.sprintStatus = sprintStatus;
        this.teamId = teamId;
    }

    //getters
    public int getSprintId() {
        return sprintId;
    }

    public LocalDate getSprintStartDate() {
        return sprintStartDate;
    }

    public LocalDate getSprintEndDate() {
        return sprintEndDate;
    }

    public SprintStatus getSprintStatus() {
        return sprintStatus;
    }

    public Team getTeamId() {
        return teamId;
    }

    public List<ToDoItem> getTodoItems() {
        return todoItems;
    }

    //setters
    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public void setSprintStartDate(LocalDate sprintStartDate) {
        this.sprintStartDate = sprintStartDate;
    }

    public void setSprintEndDate(LocalDate sprintEndDate) {
        this.sprintEndDate = sprintEndDate;
    }

    public void setSprintStatus(SprintStatus sprintStatus) {
        this.sprintStatus = sprintStatus;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    public void setTodoItems(List<ToDoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public String toString() {
        return "ToDoSprint{" +
                "sprintId=" + sprintId +
                ", sprintStartDate=" + sprintStartDate +
                ", sprintEndDate=" + sprintEndDate +
                ", sprintStatus=" + sprintStatus +
                ", teamId=" + teamId +
                ", todoItems=" + todoItems +
                '}';
    }

    public enum SprintStatus{
        NotStarted,
        Open,
        Closed
    }

}
