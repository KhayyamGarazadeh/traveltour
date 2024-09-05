package org.example.traveltour.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableTravelerResponse {

    private List<TravelerResponse> travelers;
    private int lastPageNumber;
    private int totalElements;
    private boolean hasNextPage;
}
