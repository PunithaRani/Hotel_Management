package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dao.BookingDAO;
import org.hotelmanagementsystem.dao.RoomDAO;
import org.hotelmanagementsystem.dao.UserDAO;
import org.hotelmanagementsystem.dto.BookingDetailsDTO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.model.BookingDetails;
import org.hotelmanagementsystem.model.RoomDetails;
import org.hotelmanagementsystem.model.UserInfo;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.MethodOrderer.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class LoginServiceTest {


	
	@Autowired
	private UserDAO userDao;

    @Test
    @Order(1)
    @DisplayName("Find UserByEmail")
   void testFindUserByEmail() {
		String email="joeraymond@virtusa.com";
		UserInfo user=userDao.getUserByEmail(email);
		assertThat(user).isNotNull();
	}
  

    @Test
    @Order(2)
    @DisplayName("Create User")
    void testCreateUser() {
		UserInfo userinfo=new UserInfo();
		userinfo.setFirstName("joe");
		userinfo.setLastName("raymond");
		userinfo.setEmail("joeraymond@virtusa.com");
		userinfo.setMobileNumber("9629582956");
		userinfo.setPassword("Joeraymond");
		userinfo.setKeyword("name");
		userinfo.setRole("user");
		
		String savedUser=userDao.saveUser(userinfo);
		assertThat(savedUser).isNotNull();
	}
	

    @Test
    @Order(3)
    @DisplayName("check the User")
     void testCheckUser() {
		String email="joeraymond@virtusa.com";
		String keyword="name";
		String checkUser=userDao.checkUser(email, keyword);
		assertThat(checkUser).isNotNull();
	} 
    
    
    @Test
    @Order(4)
    @DisplayName("test set password")
     void testSetPassword() {
		String email="joeraymond@virtusa.com";
		String password="Joeraymond";
		String setPassword=userDao.setPassword(email, password);
		assertThat(setPassword).isNotNull();
	}
   
}
