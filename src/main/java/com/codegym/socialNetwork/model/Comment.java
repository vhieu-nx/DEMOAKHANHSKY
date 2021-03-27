package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date dateComment;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Post post;
}
