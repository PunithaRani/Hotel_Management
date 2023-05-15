package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dao.BookingDAO;
import org.hotelmanagementsystem.dao.RoomDAO;
import org.hotelmanagementsystem.dao.UserDAO;
import org.hotelmanagementsystem.dto.BookingDetailsDTO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.model.BookingDetails;
import org.hotelmanagementsystem.model.RoomDetails;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.MethodOrderer.*;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BookingServiceTest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoomDAO roomDAO;
    
    @Autowired
	private BookingDAO bookdao;
	
	@Autowired
	private UserDAO userdao;

    @Test
    @Order(1)
    @DisplayName("Adding Booking Details")
	void BookingDetailsAddTest() {
		BookingDetailsDTO bookingdetails = new BookingDetailsDTO();
		bookingdetails.setBookingName("Punitha");
		bookingdetails.setCheckIn("08/18/2021");
		bookingdetails.setCheckOut("08/20/2021");
		bookingdetails.setRoomNumber("101");
		bookingdetails.setRoomType("Single_Cot_Ac");
		bookingdetails.setAddress("Kovilpatti");
		bookingdetails.setEmail("punitha123@gmail.com");
		bookingdetails.setMobileNumber("9876543025");
		BookingDetails bookingdetail=modelMapper.map(bookingdetails,BookingDetails.class);
		System.out.print(bookdao.saveBookingsDAO(bookingdetail));
		Assert.assertEquals("adding booking detaisl","valid",bookdao.saveBookingsDAO(bookingdetail) );
		
	}
  

    @Test
    @Order(2)
    @DisplayName("Get Booking Details")
    void GetBookingDetails()
    {
    	Assert.assertTrue("Get Booking details",bookdao.getBookingsDetails().size()>0);
    }


    @Test
    @Order(3)
    @DisplayName("check the roomtype")
    void CheckTheRoomTest()
    {
    	String roomtype="Single_Cot_AC";
    	Assert.assertTrue("check roomtype",roomDAO.getRoomDetailsByRoomType(roomtype).size()>0);
    }
    @Test
    @Order(4)
    @DisplayName("Get Booking Details by EmailId")
    void GetBookingDetailsByEmail()
    {
    	Assert.assertTrue("Get Booking details by email",bookdao.getBookingsDetailsByEmailId("puni").size()>0);
    }


    @Test
    @Order(5)
    @DisplayName("Get User Details by Email") 
    void GetUserDetailsByEmail()
    {
    	Assert.assertNotNull("Get user details by email",userdao.getUserByEmail("punitha29@gmail.com"));
    } 

    @Test
    @Order(6)
    @DisplayName("Get User Details")
    void GetUserDetails()
    {
    	Assert.assertTrue("Get user details",userdao.getAllUserInfo().size()>0);
    }


}
