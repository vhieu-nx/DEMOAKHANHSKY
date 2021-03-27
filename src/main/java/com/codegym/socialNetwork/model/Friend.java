package com.codegym.socialNetwork.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateRequest;
    private Integer status;
    @ManyToOne
    private AppUser UserTo;

    @ManyToOne
    private AppUser UserFrom;
}
