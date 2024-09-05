package org.example.traveltour.controller;

import lombok.RequiredArgsConstructor;
import org.example.traveltour.criteria.PageCriteria;
import org.example.traveltour.criteria.TravelerCriteria;
import org.example.traveltour.dto.GuidePassportDTO;
import org.example.traveltour.dto.request.*;
import org.example.traveltour.dto.response.*;
import org.example.traveltour.model.*;
import org.example.traveltour.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping("/addTour")
    public ResponseEntity<TourResponse> addTour(@RequestBody TourRequest tourRequest) {
        TourResponse createdTour = tourService.addTour(tourRequest);
        return new ResponseEntity<>(createdTour, CREATED);
    }

    @PostMapping("/addDestinations")
    public ResponseEntity<DestinationResponse> addDestination(@RequestBody DestinationRequest destinationRequest) {
        DestinationResponse createdDestination = tourService.addDestination(destinationRequest);
        return new ResponseEntity<>(createdDestination, CREATED);
    }

    @PostMapping("/addTraveler")
    public ResponseEntity<TravelerResponse> addTraveler(@RequestBody TravelerRequest travelerRequest) {
        TravelerResponse createdTraveler = tourService.addTraveler(travelerRequest);
        return new ResponseEntity<>(createdTraveler, CREATED);
    }

    @PostMapping("/addGuide")
    public ResponseEntity<GuideResponse> addGuide(@RequestBody GuideRequest guideRequest) {
        GuideResponse createdGuide = tourService.addGuide(guideRequest);
        return new ResponseEntity<>(createdGuide, CREATED);
    }

    @PostMapping("/addPassport")
    public ResponseEntity<PassportResponse> addPassport(@RequestBody PassportRequest passportRequest) {
        PassportResponse createdPassport = tourService.addPassport(passportRequest);
        return new ResponseEntity<>(createdPassport, CREATED);
    }

    @PostMapping("/{tourId}/assign-guide/{guideId}")
    public ResponseEntity<SuccessMessage> assignGuideToTour(@PathVariable Long tourId, @PathVariable Long guideId) {
        SuccessMessage successMessage = tourService.assignGuideToTour(tourId, guideId);
        return new ResponseEntity<>(successMessage, CREATED);
    }

    @GetMapping("{id}/destinations")
    public ResponseEntity<List<DestinationResponse>> getDestinationsForTour(@PathVariable Long id) {
        List<DestinationResponse> destinations = tourService.getDestinationsForTour(id);
        return new ResponseEntity<>(destinations, CREATED);

    }

    @GetMapping("{id}travelers")
    public ResponseEntity<List<TravelerResponse>> getTravelersForTour(@PathVariable Long id) {
        List<TravelerResponse> travelers = tourService.getTravelersForTour(id);
        return new ResponseEntity<>(travelers, CREATED);
    }

    @GetMapping("/traveler/{travelerId}")
    public ResponseEntity<List<TourResponse>> getToursByTravelerId(@PathVariable Long travelerId) {
        List<TourResponse> tours = tourService.getToursByTravelerId(travelerId);
        return new ResponseEntity<>(tours, CREATED);
    }

    @GetMapping("/{tourId}/guides")
    public ResponseEntity<List<GuideResponse>> getGuidesByTourId(@PathVariable Long tourId) {
        List<GuideResponse> guides = tourService.getGuidesByTourId(tourId);
        return new ResponseEntity<>(guides, CREATED);
    }

    @GetMapping("/guides/available")
    public ResponseEntity<List<GuideResponse>> getAvailableGuidesDuringPeriod(@RequestParam Date startDate, Date endDate) {
        List<GuideResponse> guides = tourService.getAvailableGuidesDuringPeriod(startDate, endDate);
        return new ResponseEntity<>(guides, CREATED);
    }
//    @GetMapping
//    public PageableTravelerResponse getTravelers(PageCriteria pageCriteria,
//                                                 TravelerCriteria travelerCriteria){
//        return tourService.getTravelers(pageCriteria, travelerCriteria);
//    } TODO: Update olunacaq hissələr qalıb


}
