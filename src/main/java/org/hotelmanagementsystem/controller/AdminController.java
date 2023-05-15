package org.hotelmanagementsystem.controller;


import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dto.BookingDTOList;
import org.hotelmanagementsystem.dto.BookingDetailsDTO;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.dto.RoomList;
import org.hotelmanagementsystem.service.BookingService;
import org.hotelmanagementsystem.service.IRoomService;
import org.hotelmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;


@Controller
@RequestMapping(value = "/admin", method = {RequestMethod.GET, RequestMethod.POST})
public class AdminController {

    private static Logger logger = Logger.getLogger(AdminController.class);
    @Autowired
    private BookingService roomService;

    @Autowired
    private UserService userService;

    @Autowired
    private IRoomService service;

    private static final String USER_INFO = "user_info";

    private static final String MESSAGE = "message";

    @GetMapping("/addRooms")
    public String addRoom(HttpServletRequest request, Model model, RestTemplate restTemplate) {
        logger.info("Enter into the admin page");
        HttpSession session = request.getSession();
        try {
            RoomList roomDetailsList = restTemplate.getForObject("http://127.0.0.1:8081/rooms/getAllDetails", RoomList.class);
            if (roomDetailsList != null && !roomDetailsList.getRoomDetailsList().isEmpty()) {
                model.addAttribute("rooms", roomDetailsList.getRoomDetailsList());
                session.setAttribute("accept_rooms", "true");
            }
        } catch(NullPointerException e) {
            session.setAttribute("rooms", null);
        }
        logger.info("Returning a room page");
        return "Admin/Rooms";
    }

    @GetMapping
    public String index(Model model) {
        logger.info("Enter into the index page");
        int totalRooms = service.getRoomDetails().size();
        logger.info(totalRooms);
        model.addAttribute("total_room", totalRooms);
        List<UserInfoDTO> userInfoDTOS = userService.userInfo();
        if (!userInfoDTOS.isEmpty()) {
            model.addAttribute(USER_INFO, userInfoDTOS);
            model.addAttribute("total_user", userInfoDTOS.size());
        } else {
            model.addAttribute(USER_INFO, null);
            model.addAttribute("total_user", 0);
        }
        logger.info("Returning an admin page");
        return "Admin/Admin";
    }

    @GetMapping("/updateRooms")
    public String updateRoom(Model model, @RequestParam(name = "roomNumber") int roomNumber) {
        logger.info("Entering into an update room handler");
        model.addAttribute("roomNumber", roomNumber);
        logger.info("Returning an update room page");
        return "Admin/updateRooms";
    }

    @GetMapping("/deleteRooms")
    public String deleteRoom(Model model, @RequestParam(name = "roomNumber") int roomNumber) {
        logger.info("Entering into a delete room handler");
        model.addAttribute("roomNumber", roomNumber);
        logger.info("Redirecting to admin page");
        return "redirect:/rooms/deleteDetailsById?roomNumber="+ roomNumber;
    }

    @GetMapping("/bookings")
    public String bookingDetails(Model model) {
        logger.info("Entering into a bookings handler");
        List<BookingDetailsDTO> bookingDetails = roomService.getBookingDetails();
        if (!bookingDetails.isEmpty()) {
            model.addAttribute("bookingDetails", bookingDetails);
        } else {
            model.addAttribute("bookingDetails", null);
        }
        logger.info("Returning a booking page");
        return "Admin/booking";
    }

    @GetMapping("/userdetails")
    public String userDetails(Model model) {
        logger.info("Entering into a userdetails handler");
        List<UserInfoDTO> userInfo = userService.userInfo();
        if (!userInfo.isEmpty()) {
            model.addAttribute(USER_INFO, userInfo);
        } else {
            model.addAttribute(USER_INFO, null);
        }
        logger.info("Returning a user details page");
        return "Admin/UserDetails";
    }

    @GetMapping(value = "/getBookingsByName")
    public void getBookingsByName(@RequestParam(value = "name") String bookingName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("Entering into a get bookings by name handler");
        HttpSession session = request.getSession();
        BookingDTOList bookingDetailsDTO = new BookingDTOList();
        bookingDetailsDTO.setBookingDetailsDTOList(roomService.getBookingsByEmailId(bookingName));
        logger.info(bookingDetailsDTO);
        if (!bookingDetailsDTO.getBookingDetailsDTOList().isEmpty() || bookingName.equals("")) {
            session.setAttribute("search_field", "open");
            session.setAttribute("bookingDetail", bookingDetailsDTO.getBookingDetailsDTOList());
        } else {
            session.setAttribute("search_field", "close");
            session.setAttribute("bookingDetail", null);
        }
        logger.info("Redirecting to booking page");
        response.sendRedirect("/admin/bookings");
    }

    @GetMapping("/getUserByEmail")
    public void getUserByEmail(@RequestParam(name = "email") String email, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("Entering into a get user by email handler");
        UserInfoDTO userInfoDTO = userService.getUserInfoByEmail(email);
        logger.info(userInfoDTO);
        HttpSession session = request.getSession();
        if (userInfoDTO != null || email.equals("")) {
            session.setAttribute(MESSAGE, "valid");
            session.setAttribute("userinfobyemail", userInfoDTO);
        }
        else {
            session.setAttribute(MESSAGE, "invalid");
            session.setAttribute("userinfobyemail", null);
        }
        logger.info("Redirecting to userdetails page");
        response.sendRedirect("/admin/userdetails");
    }

    @GetMapping("/updateAvailability")
    public void updateAvailability(@RequestParam(name = "roomNumber") int roomNumber, HttpServletResponse response, HttpServletRequest request) throws IOException {
        logger.info("Entering into a update availability handler");
        String result = service.updateAvailability(roomNumber);
        HttpSession session = request.getSession();
        if (result != null) {
            session.setAttribute(MESSAGE, "Updated successfully");
        } else {
            session.setAttribute(MESSAGE, "Updation failed");
        }
        logger.info("Redirecting to room page");
        response.sendRedirect("/admin/addRooms");
    }
}
