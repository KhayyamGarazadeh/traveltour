package org.example.traveltour.mapper;

import org.example.traveltour.dto.request.GuideRequest;
import org.example.traveltour.dto.response.GuideResponse;
import org.example.traveltour.model.Guide;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GuideMapper {
    Guide guideRequestToGuide(GuideRequest guideRequest);
    GuideResponse guideToGuideResponse(Guide guide);

}
