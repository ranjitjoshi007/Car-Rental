package com.ranjit.carrental.carrental.repository;

import com.ranjit.carrental.carrental.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long> {
    @Query("""
    SELECT b FROM Booking b
    WHERE b.car.id = :carId
    AND b.startDate <= :endDate
    AND b.endDate >= :startDate
""")
    List<Booking> findOverlappingBookings(Long carId, LocalDateTime startDate, LocalDateTime endDate);
    List<Booking> findByCarId(Long carId);

}
