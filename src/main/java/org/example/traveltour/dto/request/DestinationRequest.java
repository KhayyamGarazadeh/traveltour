package org.example.traveltour.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class DestinationRequest {
    private String location;
    private String description;
    private Date visitDate;
}
