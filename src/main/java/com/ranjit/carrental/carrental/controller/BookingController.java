package com.ranjit.carrental.carrental.controller;

import com.ranjit.carrental.carrental.domain.entity.Booking;
import com.ranjit.carrental.carrental.dto.request.car.CreateBookingRequest;
import com.ranjit.carrental.carrental.exception.ForbiddenException;
import com.ranjit.carrental.carrental.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController extends BaseResourceController<Booking, Long, CreateBookingRequest, CreateBookingRequest> {
    private final BookingService service;

    @GetMapping("/cars/{id}")
    public ResponseEntity<List<Booking>> getCar(@PathVariable Long id) {

        List<Booking> bookings = service
                .carBookings(id);
//                .map(CarMapper::toResponse);

        return ResponseEntity.ok(bookings);
    }


    @Override
    public ResponseEntity<List<Booking>> getAll() {
        List<Booking> list = service
                .getAllItems();
//                .map(CarMapper::toResponse);

        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<Booking> getById(Long aLong) {
        throw new ForbiddenException("Method not allowed");
    }


    @Override
    public ResponseEntity<Booking> create(@RequestBody CreateBookingRequest request) {
        return ResponseEntity.ok(service.createBooking( request.getCarId(), request.getCustomerName(), request.getStartDate(), request.getEndDate() ));
    }

    @Override
    public ResponseEntity<Booking> update(Long aLong, CreateBookingRequest entity) {
        throw new ForbiddenException("Method not allowed");
    }

    @Override
    public ResponseEntity<Booking> partialUpdate(Long aLong, CreateBookingRequest entity) {
        throw new ForbiddenException("Method not allowed");
    }



    @Override
    public void delete(Long id) {
        service.cancelBooking(id);
    }
    @GetMapping("/availability")
    public boolean checkAvailability( @RequestParam Long carId, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        return service.isCarAvailable(carId, startDate, endDate);
    }

}
