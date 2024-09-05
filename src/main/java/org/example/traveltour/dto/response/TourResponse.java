package org.example.traveltour.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TourResponse {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
    private List<DestinationResponse> destinations;
    private List<TravelerResponse> travelers;
    private List<GuideResponse> guides;
}
