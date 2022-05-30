package com.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "location_name")
    private String locationName;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "location")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "location")
    private Status status;

}
