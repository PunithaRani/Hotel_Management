package org.hotelmanagementsystem.dto;

import java.util.List;

public class BookingDTOList {

    private List<BookingDetailsDTO> bookingDetailsDTOList;

    public List<BookingDetailsDTO> getBookingDetailsDTOList() {
        return bookingDetailsDTOList;
    }

    public void setBookingDetailsDTOList(List<BookingDetailsDTO> bookingDetailsDTOList) {
        this.bookingDetailsDTOList = bookingDetailsDTOList;
    }
}
