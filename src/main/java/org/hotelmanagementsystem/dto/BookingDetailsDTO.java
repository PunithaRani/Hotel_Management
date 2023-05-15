package org.hotelmanagementsystem.dto;

import java.io.Serializable;

public class BookingDetailsDTO implements Serializable {

	private int bookingId;
	private int userId;
	private String bookingName;
	private String checkIn;
	private String checkOut;
	private String roomNumber;
	private String roomType;
	private String email;
	private String mobileNumber;
	private String address;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		return "BookingDetailsModelDTO{" +
				"bookingId=" + bookingId +
				", userId=" + userId +
				", bookingName='" + bookingName + '\'' +
				", checkIn='" + checkIn + '\'' +
				", checkOut='" + checkOut + '\'' +
				", roomNumber='" + roomNumber + '\'' +
				", roomType='" + roomType + '\'' +
				", email='" + email + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
