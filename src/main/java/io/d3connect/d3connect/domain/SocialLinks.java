package io.d3connect.d3connect.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SocialLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
