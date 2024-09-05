package org.example.traveltour.dto;

import lombok.Data;
import org.example.traveltour.model.Guide;
import org.example.traveltour.model.Passport;

@Data
public class GuidePassportDTO {
    private Guide guide;
    private Passport passport;
}
