package io.d3connect.d3connect.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "E-mail is required")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "Username is required and must be unique")
    @Size(min=4, max=12, message = "Please use 4 - 12 characters for your username")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min=4, max=15, message = "Please use 4 - 15 characters for your password")
    private String password;

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Date joinDate;

    private String bio;
    private String profileImage;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Comment comment;

    // One to Many with Project
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Project> project;


    // One to One with Social Links

    // Empty Constructor
    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
}
