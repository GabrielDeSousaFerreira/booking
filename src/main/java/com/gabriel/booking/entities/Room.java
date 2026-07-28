package com.gabriel.booking.entities;

import com.gabriel.booking.enums.RoomStatus;
import com.gabriel.booking.enums.RoomType;

public class Room {
    private int roomNumber;
    private int floor;
    private RoomType roomType;
    private RoomStatus roomStatus;

    public Room(int roomNumber, int floor) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.roomType = defineRoomType();
        this.roomStatus = RoomStatus.AVALIABLE;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    private RoomType defineRoomType(){
        if (floor > 0 && floor <= 7){
            return RoomType.COMUM;
        }

        if (floor <= 15){
            return RoomType.PREMIUM;
        }

        if (floor < 1 || floor > 20){
            System.out.println("Andar invàlido!");
        }

        return RoomType.LUXO;
    }

    @Override
    public String toString() {
        return "=== Quarto ===" +
                "\nNúmero: " + roomNumber +
                "\nAndar: " + floor + "º" +
                "\nTipo: " + roomType +
                "\nStatus: " + roomStatus;
    }
}
