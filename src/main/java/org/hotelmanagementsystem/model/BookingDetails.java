package org.hotelmanagementsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "BookingDetails")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;
    private String bookingName;
    private String checkIn;
    private String checkOut;
    private String roomNumber;
    private String roomType;
    private String address;
    private String email;
    private String mobileNumber;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobilenumber) {
        this.mobileNumber = mobilenumber;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "bookingId=" + bookingId +
                ", bookingName='" + bookingName + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType='" + roomType + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mobilenumber='" + mobileNumber + '\'' +
                '}';
    }
}

