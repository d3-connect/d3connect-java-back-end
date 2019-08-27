package io.d3connect.d3connect.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SocialLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String twitter;
    private String github;
    private String behance;
    private String linkedin;
    private String dribbble;
    private String OtherLink1;
    private String OtherLink2;

    public SocialLinks() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getBehance() {
        return behance;
    }

    public void setBehance(String behance) {
        this.behance = behance;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getDribbble() {
        return dribbble;
    }

    public void setDribbble(String dribbble) {
        this.dribbble = dribbble;
    }

    public String getOtherLink1() {
        return OtherLink1;
    }

    public void setOtherLink1(String otherLink1) {
        OtherLink1 = otherLink1;
    }

    public String getOtherLink2() {
        return OtherLink2;
    }

    public void setOtherLink2(String otherLink2) {
        OtherLink2 = otherLink2;
    }
}
