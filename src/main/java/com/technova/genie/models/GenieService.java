package com.technova.genie.models;

import javax.persistence.*;

@Entity
public class GenieService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "genie_id")
    Genie genie;

    @ManyToOne
    @JoinColumn(name = "service_id")
    Service service;
}
