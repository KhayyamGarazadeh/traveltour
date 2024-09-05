package org.example.traveltour.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.traveltour.dto.request.*;
import org.example.traveltour.dto.response.*;
import org.example.traveltour.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface TourMapper {

    Tour tourRequestToTour(TourRequest tourRequest);
    TourResponse tourToTourResponse(Tour tour);






}
