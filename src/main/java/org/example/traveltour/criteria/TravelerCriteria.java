package org.example.traveltour.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelerCriteria {
    private Integer ageFrom;
    private Integer ageTo;
    private String birthPlace ;
}
