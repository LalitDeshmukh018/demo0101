package com.Lalitdk.project.uber.uberApp.controllers;

import com.Lalitdk.project.uber.uberApp.dto.DriverDto;
import com.Lalitdk.project.uber.uberApp.dto.RatingDto;
import com.Lalitdk.project.uber.uberApp.dto.RideDto;
import com.Lalitdk.project.uber.uberApp.dto.RideStartDto;
import com.Lalitdk.project.uber.uberApp.dto.RiderDto;
import com.Lalitdk.project.uber.uberApp.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestId) {
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }

    @PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDto> startRide(@PathVariable Long rideRequestId,
                                              @RequestBody RideStartDto rideStartDto) {
        return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDto.getOtp()));
    }

    @PostMapping("/endRide/{rideId}")
    public ResponseEntity<RideDto> endRide(@PathVariable Long rideId) {
        return ResponseEntity.ok(driverService.endRide(rideId));
    }

    @PostMapping ("/cancelRide/{rideId}")
    public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId){
        return ResponseEntity.ok(driverService.cancelRide(rideId));
    }

    @PostMapping("/rateRider")
    public ResponseEntity<RiderDto> rateRider(@RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(driverService.rateRider(ratingDto.getRideId(),ratingDto.getRating()));
    }

    @GetMapping("/getMyProfile")
    public ResponseEntity<DriverDto>getMyProfile(){
        return ResponseEntity.ok(driverService.getMyProfile());
    }

    @GetMapping ("/getMyRides")
    public ResponseEntity<Page<RideDto>>getAllMyRides(@RequestParam (defaultValue = "0") Integer pageOffset,
                                                      @RequestParam (defaultValue = "10",required = false ) Integer pageSize ){
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize);                                                   
        return ResponseEntity.ok(driverService.getAllMyRides(pageRequest));
    }

    @PostMapping("/rateRider/{rideId}/{rating}")
    public ResponseEntity<RiderDto> rateRider(@PathVariable Long rideId , @PathVariable Integer rating ){
        return ResponseEntity.ok(driverService.rateRider(rideId, rating));
    }



}