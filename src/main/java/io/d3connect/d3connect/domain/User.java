package io.d3connect.d3connect.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/*
 *
 *
 *
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "E-mail is required")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "Username is required and must be unique")
    @Size(min=4, max=15, message = "Please use 4 - 15 characters for your username")
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

    @Value("${file-upload-path}")
    private String uploadPath;

    // One to one with comment class. Each user can have a comment
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<Comment> comments;

    // One to ?? with Project
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user",
            orphanRemoval = true)
    // @NotBlank(message = "User ID is required for each project")
    private List<Project> projects;

    // One to One with Social Links
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    private SocialLinks socialLinks;


    // One to May Relationship with Projects. Each user can have many projects
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user",
            orphanRemoval = true)
    private List<Specialization> specializations;

    // Empty Constructor
    public User() { }

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

    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void setUser(User userById) {
    }


}
