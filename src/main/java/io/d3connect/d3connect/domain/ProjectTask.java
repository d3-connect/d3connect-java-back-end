package io.d3connect.d3connect.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class ProjectTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private String projectSequence;

    @NotBlank(message = "Please include a task summary")
    private String taskSummary;

    @Column(updatable = false)
    private String projectIdentifier;

    private String acceptanceCriteria;
    private String taskStatus;
    private Integer taskPriority;
    private Date dueDate;
    private Date created_At;
    private Date updated_At;

    //

    @PrePersist
    protected void onCreate() {
        this.created_At = new Date();
    }

    @PrePersist
    protected void onUpdate() {
        this.updated_At = new Date();
    }

    public ProjectTask() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectSequence() {
        return projectSequence;
    }

    public void setProjectSequence(String projectSequence) {
        this.projectSequence = projectSequence;
    }

    public String getTaskSummary() {
        return taskSummary;
    }

    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getAcceptanceCriteria() {
        return acceptanceCriteria;
    }

    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(Integer taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", projectSequence='" + projectSequence + '\'' +
                ", taskSummary='" + taskSummary + '\'' +
                ", projectIdentifier='" + projectIdentifier + '\'' +
                ", acceptanceCriteria='" + acceptanceCriteria + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskPriority=" + taskPriority +
                ", dueDate=" + dueDate +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }
}
