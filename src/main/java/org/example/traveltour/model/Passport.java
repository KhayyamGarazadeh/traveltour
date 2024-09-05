package org.example.traveltour.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
    private String country;

    @OneToOne
    @JoinColumn(name = "guide_id")
    private Guide guide;
}
