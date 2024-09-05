package org.example.traveltour.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "guide_tour",
            joinColumns = @JoinColumn(name = "guide_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id")
    )
    private List<Tour> tours;

    @OneToOne(mappedBy = "guide", cascade = CascadeType.ALL)
    private Passport passport;

}
