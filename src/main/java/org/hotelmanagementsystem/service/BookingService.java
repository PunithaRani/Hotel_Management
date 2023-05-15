package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dao.BookingDAO;
import org.hotelmanagementsystem.dao.UserDAO;
import org.hotelmanagementsystem.dto.BookingDetailsDTO;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.model.BookingDetails;
import org.hotelmanagementsystem.model.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookingService implements IBookingService {
	
private String userinfo;
private String email;
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BookingDAO bookingDAO;
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public String adduserRoomDetails(BookingDetailsDTO book) {
		BookingDetails bookingDetails = modelMapper.map(book, BookingDetails.class);
		return bookingDAO.saveBookingsDAO(bookingDetails);
	}

	@Override
	public List<BookingDetailsDTO> getBookingDetails() {
		return bookingDAO.getBookingsDetails().stream()
				.map(bookingDetail -> modelMapper.map(bookingDetail, BookingDetailsDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BookingDetailsDTO> getBookingsByEmailId(String bookingName) {
		return bookingDAO.getBookingsDetailsByEmailId(bookingName).stream()
				.map(bookingDetail -> modelMapper.map(bookingDetail, BookingDetailsDTO.class))
				.collect(Collectors.toList());
	}
	
	 public int geLastBookingDetails() {
	        BookingDetails bookingDetails = bookingDAO.getLastBookingsDetails();
	        if (bookingDetails != null) {
	            return bookingDetails.getBookingId();
	        }
	        return 0;
	    }
	 
	@Override
	public String changeAvailableOption(int roomNumber) {
		return bookingDAO.changeAvailable(roomNumber);
	}
	
	
	
	///////
	
	 public void setuserlogged(String name)
	 {
		
		
		 this.userinfo=name;
	 }
	 public  String getuserlogged()
	 {
		
		
		 return userinfo;
	 }
	 public void setuserEmail(String name)
	 {
		
     
		 this.email=name;
		    UserInfo user=userDAO.getUserByEmail(email);
			setuserlogged(user.getFirstName()+" "+user.getLastName());
	 }
	 public String getprofilename()
	 {
			String username=userinfo.toUpperCase();
			String name[]=username.split(" ");
			
			return String.valueOf(name[0].charAt(0))+String.valueOf(name[1].charAt(0));
		
	 }
	 public  String getuserEmail()
	 {
		
		
		 return email;
	 }
}
