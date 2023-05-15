package org.hotelmanagementsystem.service;

import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dao.RoomDAO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.model.RoomDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("RoomService")
public class RoomServiceImpl implements IRoomService {

    private static final String REDIRECT_MESSAGE =  "Enter into the Room service";
    private static final Logger logger = Logger.getLogger(RoomServiceImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoomDAO roomDAO;

    @Override
    public String storeRoom(RoomDetailsDTO roomDetailsDTO) {
        roomDetailsDTO.setRoomAvailability(true);
        RoomDetails roomDetails = modelMapper.map(roomDetailsDTO, RoomDetails.class);
        logger.info(REDIRECT_MESSAGE);
        return roomDAO.storeRoomDetails(roomDetails);
    }

    @Override
    public List<RoomDetailsDTO> getRoomDetails(){
        List<RoomDetails> roomDetails = roomDAO.getAllRoomDetails();
        if (roomDetails != null) {
            logger.info(REDIRECT_MESSAGE);
            return roomDetails.stream()
                    .map(roomDetail -> modelMapper.map(roomDetail, RoomDetailsDTO.class))
                    .collect(Collectors.toList());
        }
        logger.info("Returning to the Room Controller with empty details");
        return new ArrayList<>();
    }

    @Override
    public String updateRoom(RoomDetailsDTO roomDetailsDTO) {
        RoomDetails roomDetails = modelMapper.map(roomDetailsDTO, RoomDetails.class);
        logger.info(REDIRECT_MESSAGE);
        return roomDAO.updateRoomDetails(roomDetails);
    }

    @Override
    public RoomDetailsDTO getRoom(int roomNumber) {
        if (roomDAO.getRoomDetails(roomNumber) != null) {
            logger.info(REDIRECT_MESSAGE);
            return modelMapper.map(roomDAO.getRoomDetails(roomNumber), RoomDetailsDTO.class);
        } else {
            logger.info("Returning to the Room Controller with empty details");
            return null;
        }

    }

    @Override
    public String deleteRoom(int roomNumber) {
        logger.info(REDIRECT_MESSAGE);
        return roomDAO.deleteRoomDetails(roomNumber);
    }

    @Override
    public List<RoomDetailsDTO> getRoomDetailsByRoomType(String roomType) {
        logger.info(REDIRECT_MESSAGE);
        return roomDAO.getRoomDetailsByRoomType(roomType).stream()
                .map(roomDetails -> modelMapper.map(roomDetails, RoomDetailsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String updateAvailability(int roomNumber) {
        logger.info(REDIRECT_MESSAGE);
        return roomDAO.updateAvailability(roomNumber);
    }


}
