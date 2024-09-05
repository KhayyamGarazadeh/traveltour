package org.example.traveltour.mapper;

import org.example.traveltour.dto.request.TravelerRequest;
import org.example.traveltour.dto.response.PageableTravelerResponse;
import org.example.traveltour.dto.response.TravelerResponse;
import org.example.traveltour.model.Traveler;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TravelerMapper {

    Traveler travelerRequestToTraveler(TravelerRequest travelerRequest);
    TravelerResponse travelerToTravelerResponse(Traveler traveler);

   // PageableTravelerResponse mapToPageableResponse(Object travelersPage);
}
