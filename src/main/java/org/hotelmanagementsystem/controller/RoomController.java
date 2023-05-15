package org.hotelmanagementsystem.controller;

import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(value = "/rooms")
public class RoomController {

    private static final String VALID_MESSAGE = "Valid";
    private static final String REDIRECT_PAGE = "/admin/addRooms";
    private static final String REDIRECT_MESSAGE = "Redirecting to admin page";

    private static Logger logger = Logger.getLogger(RoomController.class);

    @Autowired
    private IRoomService roomService;

    @PostMapping(value = "/addDetails", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void createRoom(RoomDetailsDTO roomDetails, HttpServletResponse response, HttpServletRequest request) throws IOException {
        logger.info("Entering into a create room handler");
        String result = roomService.storeRoom(roomDetails);
        logger.info(result);
        HttpSession session = request.getSession();
        if (result.equals(VALID_MESSAGE)) {
            session.setAttribute("store_message", "Room Details are successfully stored");
        } else {
            session.setAttribute("store_message_error", result);
        }
        logger.info(REDIRECT_MESSAGE);
        response.sendRedirect(REDIRECT_PAGE);
    }

    @PostMapping(value = "/updateDetails", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateRoom(RoomDetailsDTO roomDetails, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("Entering into an update room handler");
        String result = roomService.updateRoom(roomDetails);
        logger.info(result);
        HttpSession session = request.getSession();
        if (result.equals(VALID_MESSAGE)) {
            session.setAttribute("valid_message", "valid");
        } else {
            session.setAttribute("valid_message", "invalid");
            session.setAttribute("output_message", result);
        }
        logger.info("Redirecting to update room handler");
        response.sendRedirect("/admin/updateRooms?roomNumber=" + roomDetails.getRoomNumber());
    }

    @GetMapping("/getDetailsById")
    public void getRoom(@RequestParam(name = "roomNumber", required = false) String roomNumber, HttpServletResponse response, Model model, HttpServletRequest request) throws IOException {
        logger.info("Entering into a get room handler");
        HttpSession session = request.getSession();
        try {
            RoomDetailsDTO roomDetails = roomService.getRoom(Integer.valueOf(roomNumber));
            logger.info(roomDetails);
            if (roomDetails != null) {
                session.setAttribute("roomNumber", roomDetails.getRoomNumber());
                session.setAttribute("roomType", roomDetails.getRoomType());
                session.setAttribute("roomAvailability", roomDetails.getRoomAvailability());
                session.setAttribute("roomSection", roomDetails.getRoomSection());
                session.setAttribute("accept_room", "true");
            } else {
                session.setAttribute("message1", "Invalid");
            }
            logger.info(REDIRECT_MESSAGE);
            response.sendRedirect(REDIRECT_PAGE);
        } catch(Exception e) {
            response.sendRedirect(REDIRECT_PAGE);
        }
        logger.info(REDIRECT_MESSAGE);
    }

    @GetMapping("/deleteDetailsById")
    public void deleteRoom(@RequestParam(name = "roomNumber") String roomNumber, HttpServletResponse response, HttpServletRequest request) throws IOException {
        logger.info("Entering into a delete room handlera");
        HttpSession session = request.getSession();
        String result = roomService.deleteRoom(Integer.parseInt(roomNumber));
        logger.info(result);
        if (result.equals(VALID_MESSAGE)) {
            session.setAttribute("delete_message", "Room No: " + roomNumber + " are successfully deleted");
        } else {
            session.setAttribute("delete_message1", "Details are not present in the database");
        }
        logger.info(REDIRECT_MESSAGE);
        response.sendRedirect(REDIRECT_PAGE);
    }

}
