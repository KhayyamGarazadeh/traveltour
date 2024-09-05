package org.example.traveltour.service;

import lombok.RequiredArgsConstructor;

import org.example.traveltour.criteria.PageCriteria;
import org.example.traveltour.criteria.TravelerCriteria;
import org.example.traveltour.dto.request.*;
import org.example.traveltour.dto.response.*;
import org.example.traveltour.exception.IllegalArgumentException;
import org.example.traveltour.exception.NotFoundException;
import org.example.traveltour.mapper.*;
import org.example.traveltour.model.*;

import org.example.traveltour.repository.*;

import org.example.traveltour.service.specfication.TravelerSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.example.traveltour.model.enums.ExceptionConstants.*;

@Service
@RequiredArgsConstructor
public class TourService {
    private final TourRepository tourRepository;
    private final DestinationRepository destinationRepository;
    private final GuideRepository guideRepository;
    private final TravelerRepository travelerRepository;
    private final PassportRepository passportRepository;

    private final TourMapper tourMapper;
    private final DestinationMapper destinationMapper;
    private final GuideMapper guideMapper;
    private final TravelerMapper travelerMapper;
    private final PassportMapper passportMapper;


    public TourResponse addTour(TourRequest tourRequest) {
        Tour tour = tourMapper.tourRequestToTour(tourRequest);
        tour= tourRepository.save(tour);
        return tourMapper.tourToTourResponse(tour);
    }

    public DestinationResponse addDestination(DestinationRequest destinationRequest) {
        Destination destination = destinationMapper.destinationRequestToDestination(destinationRequest);
        destination = destinationRepository.save(destination);
        return destinationMapper.destinationToDestinationResponse(destination);
    }

    public TravelerResponse addTraveler(TravelerRequest travelerRequest) {
        Traveler traveler= travelerMapper.travelerRequestToTraveler(travelerRequest);
        traveler = travelerRepository.save(traveler);
        return travelerMapper.travelerToTravelerResponse(traveler);
    }

    public GuideResponse addGuide(GuideRequest guideRequest) {
        Guide guide = guideMapper.guideRequestToGuide(guideRequest);
        Passport passport = passportMapper.passportRequestToPassport(guideRequest.getPassport());
        guide= guideRepository.save(guide);
        passport.setGuide(guide);
        passportRepository.save(passport);
        return guideMapper.guideToGuideResponse(guide);

    }

    public PassportResponse addPassport(PassportRequest passportRequest) {
        Passport passport = passportMapper.passportRequestToPassport(passportRequest);
        passport = passportRepository.save(passport);
        return passportMapper.passportToPassportResponse(passport);
    }

    public SuccessMessage assignGuideToTour(Long guideId, Long tourId) {
        Tour tour = tourRepository.findById(guideId).orElseThrow(() -> new NotFoundException(TOUR_NOT_FOUND.getMessage(),TOUR_NOT_FOUND.getCode() ));
        Guide guide = guideRepository.findById(guideId).orElseThrow(() -> new NotFoundException(GUIDE_NOT_FOUND.getMessage(), GUIDE_NOT_FOUND.getCode() ));
        List<Tour> existingTours = guide.getTours();
        for (Tour existingTour : existingTours) {
            if ((tour.getStartDate().before(existingTour.getEndDate()) &&
                    tour.getStartDate().after(existingTour.getStartDate())) ||
                    (tour.getEndDate().before(existingTour.getEndDate())
                            && tour.getEndDate().after(existingTour.getStartDate())))
                throw new IllegalArgumentException(ILLEGAL_EXCEPTION.getCode(), ILLEGAL_EXCEPTION.getMessage());
        }
        tour.getGuides().add(guide);
        guide.getTours().add(tour);

        tourRepository.save(tour);
        guideRepository.save(guide);

        return new SuccessMessage("Guide successfully assigned to tour");
    }

    public List<DestinationResponse> getDestinationsForTour(Long tourId) {
        List<Destination> destinations=tourRepository.findDestinationsByTourId(tourId);
        return destinations.stream().map(destinationMapper::destinationToDestinationResponse).toList();
    }

    public List<TravelerResponse> getTravelersForTour(Long tourId) {
        List<Traveler> travelers=tourRepository.findTravelersByTourId(tourId);
        return travelers.stream().map(travelerMapper::travelerToTravelerResponse).toList();
    }
    public List<TourResponse> getToursByTravelerId(Long travelerId) {
        List<Tour> tours=tourRepository.findToursByTravelerId(travelerId);
        return tours.stream().map(tourMapper::tourToTourResponse).toList();
    }

    public List<GuideResponse> getGuidesByTourId(Long tourId) {
        List<Guide> guides=tourRepository.findGuidesByTourId(tourId);
        return guides.stream().map(guideMapper::guideToGuideResponse).toList();
    }
    public List<GuideResponse> getAvailableGuidesDuringPeriod(Date startdate,Date enddate) {
        List<Guide> guides=tourRepository.findAvailableGuidesDuringPeriod(startdate,enddate);
        return guides.stream().map(guideMapper::guideToGuideResponse).toList();
    }

//    public PageableTravelerResponse getTravelers(PageCriteria pageCriteria,
//                                                 TravelerCriteria travelerCriteria) {
//        var travelersPage=travelerRepository.findAll(
//                new TravelerSpecification(travelerCriteria),
//                PageRequest.of(pageCriteria.getPage(),pageCriteria.getCount(), Sort.by("id").descending()));
//        return travelerMapper.mapToPageableResponse(travelersPage);
//
//    } TODO: Update olunacaq hissələr qalıb 



}



