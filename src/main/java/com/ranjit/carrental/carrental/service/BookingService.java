package com.ranjit.carrental.carrental.service;

import com.ranjit.carrental.carrental.domain.entity.Booking;
import com.ranjit.carrental.carrental.domain.entity.Car;
import com.ranjit.carrental.carrental.repository.BookingRepository;
import com.ranjit.carrental.carrental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository repository;
    private final CarRepository carRepository;
    public List<Booking> getAllItems() {
        return repository.findAll();
    }
    public Booking createBooking(Long carId, String customerName, LocalDateTime startDate, LocalDateTime endDate)
    {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date must not be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before start date");
        }
        Car car = carRepository.findById(carId)
            .orElseThrow(() ->
                    new RuntimeException("Car not found"));
        if (endDate.isBefore(startDate)) {
            throw new RuntimeException("End date cannot be before start date");
        }
        List<Booking> conflicts = repository.findOverlappingBookings(carId, startDate, endDate);
        if (!conflicts.isEmpty()) {
            throw new RuntimeException("Car is not available for these dates");
        }
        long hours = ChronoUnit.HOURS.between(startDate, endDate);
        if (hours == 0) {
            hours = 1; // minimum 1 hour charge
        }

        double totalPricePerHour = (hours%24) * car.getPricePerHour();
        double totalPricePerDay = ( hours /24) * car.getPricePerDay();
        Booking booking = new Booking(customerName, car, startDate, endDate, (totalPricePerHour+totalPricePerDay));
        return repository.save(booking);

    }

    public boolean isCarAvailable(Long carId, LocalDateTime start, LocalDateTime end) {
        return repository.findOverlappingBookings(carId, start, end) .isEmpty();
    }
    public List<Booking> carBookings(Long carId) {
        return repository.findByCarId(carId);
    }
    public void cancelBooking(Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(()->
                new RuntimeException("Booking not found")
                );
        repository.delete(booking); }
}
