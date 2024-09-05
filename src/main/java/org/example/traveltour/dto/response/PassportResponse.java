package org.example.traveltour.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class PassportResponse {
    private Long id;
    private String passportNumber;
    private Date issueDate;
    private Date expiryDate;
    private String country;
}
