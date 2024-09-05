package org.example.traveltour.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<Destination> destinations;

    @ManyToMany
    @JoinTable(
            name = "tour_traveler",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "traveler_id")
    )
    private List<Traveler> travelers;

    @ManyToMany(mappedBy = "tours")
    private List<Guide> guides;

}
