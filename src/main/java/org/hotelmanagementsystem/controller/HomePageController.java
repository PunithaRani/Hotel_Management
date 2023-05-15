package org.hotelmanagementsystem.controller;

import org.hotelmanagementsystem.dto.BookingDetailsDTO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.dto.UserInfoDTO;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.time.LocalDate; 
import org.hotelmanagementsystem.service.BookingService;
import org.hotelmanagementsystem.service.IRoomService;
import org.hotelmanagementsystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.temporal.ChronoUnit;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class HomePageController {

	private static final String ROOM_TYPE = "roomType";
	private static final String MESSAGE = "message";
/*private String USERNAME;
private String PROFILENAME;
private String EMAIL;*/

	@Autowired
	private IRoomService roomService;

	@Autowired
private ModelMapper modelMapper;
	
	@Autowired
	private BookingService hotelRoomService;

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public String home(Model m) {
		String username=hotelRoomService.getuserlogged().toUpperCase();
		
		m.addAttribute("username",username);
		
		return "/User/home";
	}

	@GetMapping("/room_form")
	public String roomForm(Model m) {

	//	String name[]=USERNAME.split(" ");
		//String PROFILENAME=String.valueOf(name[0].charAt(0))+String.valueOf(name[1].charAt(0));
		String profilename=hotelRoomService.getprofilename();
	m.addAttribute("profilename",profilename);
		return "/User/roomform";
	}
	
	
	@GetMapping("/profile")
	public String profile(Model m) {
		
		String profilename=hotelRoomService.getprofilename();
		m.addAttribute("profilename",profilename);
		String email=hotelRoomService.getuserEmail();
	
        UserInfoDTO userInfoDTO = userService.getUserInfoByEmail(email);
   
        
        	m.addAttribute("userinfo", userInfoDTO);
   
        
        return "/User/profile";
      
	}
	@GetMapping("/profileEdit")
	public String profileEdit(Model m)
	{
		String profilename=hotelRoomService.getprofilename();
		m.addAttribute("profilename",profilename);
		
		String email=hotelRoomService.getuserEmail();
        UserInfoDTO userInfoDTO = userService.getUserInfoByEmail(email);
   
        
        	m.addAttribute("userinfo", userInfoDTO);
   
        
		return "/User/profileEdit";
	}
	
	@PostMapping(value = "/profileUpdate", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void profileUpdate(UserInfoDTO userInfo,HttpServletResponse response,Model m) throws IOException{
		System.out.print(userInfo);
		String email=hotelRoomService.getuserEmail();
		System.out.print(email);
		 List<String> user=userService.userEmail();
		 if(user.contains(userInfo.getEmail())&&!userInfo.getEmail().equals(email))
		 {
			 System.out.print("hello");
			m.addAttribute("message","User Email Id already Exits!!!"); 
			 response.sendRedirect("/user/profileEdit");
		 }else {
		String result = userService.updateUser(userInfo,email);
		System.out.print(result);
		//EMAIL=userInfo.getEmail();
		hotelRoomService.setuserEmail(userInfo.getEmail());
		 response.sendRedirect("/user/room_form");
		 }
		//return "/user/room_form";
	}
	
	

	@GetMapping("/user_index")
	public String userIndex() {
		return "/User/userIndex";
	}

	@GetMapping("/room_search")
	public  String getRoomSearch(@RequestParam(name="roomType") String roomType, Model m, HttpServletRequest request)
	{

		HttpSession session = request.getSession();
		session.setAttribute(ROOM_TYPE, roomType);
		List<RoomDetailsDTO> roomDetails = roomService.getRoomDetailsByRoomType(roomType);
		if (!roomDetails.isEmpty()) {
			m.addAttribute("rooms", roomDetails);
		} else {
			m.addAttribute("rooms", null);
		}
		return "/User/roombook";

	}

	@GetMapping("/room_number")
	public String roomNumber(@RequestParam(name="roomNumber") int roomNumber, Model model, HttpServletRequest request)
	{
		model.addAttribute("roomNumber", roomNumber);
		model.addAttribute(ROOM_TYPE, request.getSession(false).getAttribute(ROOM_TYPE));
		return "/User/bookdetailform";
	}

	@PostMapping(value = "/room_booked", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public String adduserRoomDetails(Model m, BookingDetailsDTO book)
	{
		
		
		
		
		String result = hotelRoomService.adduserRoomDetails(book);
		String result1 = hotelRoomService.changeAvailableOption(Integer.parseInt(book.getRoomNumber()));
		int id=hotelRoomService.geLastBookingDetails();
		if (result != null && result1 != null) {
			String[] day={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
			String[] month={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			
			
			  int checkin= LocalDate.parse(book.getCheckIn(), DateTimeFormatter.ofPattern("MM/dd/yyyy")).getDayOfWeek().getValue();
			  int checkout= LocalDate.parse(book.getCheckOut(), DateTimeFormatter.ofPattern("MM/dd/yyyy")).getDayOfWeek().getValue();
	      
			  
			// Date d=new Date(book.getCheckIn());
			//int checkin=d.getDay();
			//Date d1=new Date(book.getCheckOut());
			//int checkout=d1.getDay();
			  
			String[] checkindate = book.getCheckIn().split("/");
			String[] checkoutdate = book.getCheckOut().split("/");
			LocalDate c1 = LocalDate.parse(checkindate[2]+"-"+checkindate[0]+"-"+checkindate[1]);
			LocalDate c2 = LocalDate.parse(checkoutdate[2]+"-"+checkoutdate[0]+"-"+checkoutdate[1]);
			final long between = ChronoUnit.DAYS.between(c1, c2);
			int nop;
			if(book.getRoomType().startsWith("Single"))
				nop=1;
			else if(book.getRoomType().startsWith("Double"))
				nop=2;
			else if(book.getRoomType().startsWith("Triple"))
				nop=3;
			else
				nop=4;
			String checkinDay = checkindate[1] + " - " + month[Integer.parseInt(checkindate[0])-1] + " - " + checkindate[2];
			String checkoutDay = checkoutdate[1] + " - " + month[Integer.parseInt(checkoutdate[0])-1] + " - " + checkoutdate[2];
			m.addAttribute("day", day);
			m.addAttribute("checkin_day", day[checkin]);
			m.addAttribute("checkout_day", day[checkout]);
			m.addAttribute("checkin_in_day", checkinDay);
			m.addAttribute("checkout_out_day",checkoutDay);
			m.addAttribute("month", month);
			m.addAttribute("days_between", between);
			m.addAttribute("nop", nop);
			m.addAttribute("book", book);
			m.addAttribute("id", id);
			return "/User/bookingconfirm";
		}
	    m.addAttribute("bookdetails", null);
		return "/User/bookingconfirm";
	}

	@GetMapping("/view_room")
	public String viewRoom() {
		return "/User/viewroom";
	}

}
