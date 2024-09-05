package org.example.traveltour.dto.request;

import lombok.Data;

@Data
public class GuideRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private PassportRequest passport;
}

