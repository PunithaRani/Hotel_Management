package org.hotelmanagementsystem.controller;

import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dto.RoomList;
import org.hotelmanagementsystem.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rooms")
public class GetDetailsController {

    private static Logger logger = Logger.getLogger(GetDetailsController.class);

    @Autowired
    private IRoomService roomService;

    @GetMapping("/getAllDetails")
    public RoomList getAllRoom() {
        RoomList roomList = new RoomList();
        roomList.setRoomDetailsList(roomService.getRoomDetails());
        logger.info(roomList);
        return roomList;
    }
}
