package io.d3connect.d3connect.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/*
 *
 *
 *
 *
 *
 */

@Entity
public class SocialLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String socialTwitter;
    private String socialGithub;
    private String socialDribbble;
    private String socialBehance;
    private String socialLink1;
    private String socialLink2;
    private String scocialLink3;

    // Many To One with User
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    // Empty Constructor
    public SocialLinks() {
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialTwitter() {
        return socialTwitter;
    }

    public void setSocialTwitter(String socialTwitter) {
        this.socialTwitter = socialTwitter;
    }

    public String getSocialGithub() {
        return socialGithub;
    }

    public void setSocialGithub(String socialGithub) {
        this.socialGithub = socialGithub;
    }

    public String getSocialDribbble() {
        return socialDribbble;
    }

    public void setSocialDribbble(String socialDribbble) {
        this.socialDribbble = socialDribbble;
    }

    public String getSocialBehance() {
        return socialBehance;
    }

    public void setSocialBehance(String socialBehance) {
        this.socialBehance = socialBehance;
    }

    public String getSocialLink1() {
        return socialLink1;
    }

    public void setSocialLink1(String socialLink1) {
        this.socialLink1 = socialLink1;
    }

    public String getSocialLink2() {
        return socialLink2;
    }

    public void setSocialLink2(String socialLink2) {
        this.socialLink2 = socialLink2;
    }

    public String getScocialLink3() {
        return scocialLink3;
    }

    public void setScocialLink3(String scocialLink3) {
        this.scocialLink3 = scocialLink3;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
