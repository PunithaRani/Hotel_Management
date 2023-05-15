package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dao.RoomDAO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;

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
class AdminServiceTest {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoomDAO roomDAO;

    @Test
    @Order(1)
    @DisplayName("Adding Rooms")
    void addRooms() {
        RoomDetailsDTO roomDetails = new RoomDetailsDTO();
        roomDetails.setRoomNumber(200);
        roomDetails.setRoomSection("F");
        roomDetails.setRoomType("Family Cot");
        RoomDetails roomDetails1 = modelMapper.map(roomDetails, RoomDetails.class);
        Assert.assertEquals("Adding the rooms in the database", "Valid", roomDAO.storeRoomDetails(roomDetails1));
    }

    @Test
    @Order(2)
    @DisplayName("Get Rooms")
    void getRooms() {
        Assert.assertTrue("Getting list of room details", roomDAO.getAllRoomDetails().size() > 0);
    }

    @Test
    @Order(3)
    @DisplayName("Update Rooms")
    void updateRooms() {
        RoomDetailsDTO roomDetailsDTO = new RoomDetailsDTO();
        roomDetailsDTO.setRoomNumber(200);
        roomDetailsDTO.setRoomType("Single cot");
        roomDetailsDTO.setRoomAvailability(true);
        roomDetailsDTO.setRoomSection("A");
        RoomDetails roomDetails = modelMapper.map(roomDetailsDTO, RoomDetails.class);
        Assert.assertEquals("Update a room details", "Valid", roomDAO.updateRoomDetails(roomDetails));
    }

    @Test
    @Order(4)
    @DisplayName("Get Room Details By Room Number")
    void getRoomDetailsByRoomNumber() {
        Assert.assertNotNull("Get Room Details By Room Number", roomDAO.getRoomDetails(200));
    }

    @Test
    @Order(5)
    @DisplayName("Get Room Details By Room Type")
    void getRoomDetailsByRoomType() {
        Assert.assertNotNull("Get Room Details By Room Type", roomDAO.getRoomDetailsByRoomType("Single cot"));
    }

    @Test
    @Order(6)
    @DisplayName("Delete Rooms")
    void deleteRooms() {
        Assert.assertEquals("Delete a room details", "Valid", roomDAO.deleteRoomDetails(200));
    }

}
