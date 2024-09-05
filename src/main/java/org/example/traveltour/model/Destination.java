package org.example.traveltour.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String location;
    private String description;
    private Date visitDate;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

}
