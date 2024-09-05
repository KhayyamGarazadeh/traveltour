package org.example.traveltour.mapper;

import org.example.traveltour.dto.request.PassportRequest;
import org.example.traveltour.dto.response.PassportResponse;
import org.example.traveltour.model.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport passportRequestToPassport(PassportRequest passportRequest);
    PassportResponse passportToPassportResponse(Passport passport);
}
