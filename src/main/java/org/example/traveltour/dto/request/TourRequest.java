package org.example.traveltour.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class TourRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
    private List<Long> destinationIds;
    private List<Long> travelerIds;
    private List<Long> guideIds;
}
