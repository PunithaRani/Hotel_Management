package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dto.BookingDetailsDTO;

import java.util.List;

public interface IBookingService {
    String adduserRoomDetails(BookingDetailsDTO book);
    List<BookingDetailsDTO> getBookingDetails();
    List<BookingDetailsDTO> getBookingsByEmailId(String bookingName);
    String changeAvailableOption(int roomNumber);
}
