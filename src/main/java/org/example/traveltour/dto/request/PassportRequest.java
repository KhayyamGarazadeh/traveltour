package org.example.traveltour.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class PassportRequest {
    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
    private String country;
}
