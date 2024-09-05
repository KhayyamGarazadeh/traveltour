package org.example.traveltour.mapper;

import org.example.traveltour.dto.request.DestinationRequest;
import org.example.traveltour.dto.response.DestinationResponse;
import org.example.traveltour.model.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    Destination destinationRequestToDestination(DestinationRequest destinationRequest);
    DestinationResponse destinationToDestinationResponse(Destination destination);
}
