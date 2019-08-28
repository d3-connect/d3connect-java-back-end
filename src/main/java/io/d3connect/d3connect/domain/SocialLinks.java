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

    private String socialUrl;
    private String socialName;

    //One to One with User

    // Empty Constructor
    public SocialLinks() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocialUrl() {
        return socialUrl;
    }

    public void setSocialUrl(String socialUrl) {
        this.socialUrl = socialUrl;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }
}
