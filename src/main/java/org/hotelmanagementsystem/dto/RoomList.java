package org.hotelmanagementsystem.dto;

import java.util.List;

public class RoomList {

    private List<RoomDetailsDTO> roomDetailsList;

    public List<RoomDetailsDTO> getRoomDetailsList() {
        return roomDetailsList;
    }

    public void setRoomDetailsList(List<RoomDetailsDTO> roomDetailsList) {
        this.roomDetailsList = roomDetailsList;
    }

    @Override
    public String toString() {
        return "RoomList{" +
                "roomDetailsList=" + roomDetailsList +
                '}';
    }
}
