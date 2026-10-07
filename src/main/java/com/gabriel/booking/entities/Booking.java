package com.gabriel.booking.entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private Guest guest;
    private Room room;
    private LocalDateTime scheduledCheckIn;
    private LocalDateTime scheduledCheckOut;
    private LocalDateTime actualCheckIn;
    private LocalDateTime actualCheckOut;

    public Booking(Long id, Guest guest, Room room, LocalDateTime scheduledCheckIn, LocalDateTime scheduledCheckOut, LocalDateTime actualCheckIn, LocalDateTime actualCheckOut) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.scheduledCheckIn = scheduledCheckIn;
        this.scheduledCheckOut = scheduledCheckOut;
        this.actualCheckIn = actualCheckIn;
        this.actualCheckOut = actualCheckOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getScheduledCheckIn() {
        return scheduledCheckIn;
    }

    public void setScheduledCheckIn(LocalDateTime scheduledCheckIn) {
        this.scheduledCheckIn = scheduledCheckIn;
    }

    public LocalDateTime getScheduledCheckOut() {
        return scheduledCheckOut;
    }

    public void setScheduledCheckOut(LocalDateTime scheduledCheckOut) {
        this.scheduledCheckOut = scheduledCheckOut;
    }

    public LocalDateTime getActualCheckIn() {
        return actualCheckIn;
    }

    public void setActualCheckIn(LocalDateTime actualCheckIn) {
        this.actualCheckIn = actualCheckIn;
    }

    public LocalDateTime getActualCheckOut() {
        return actualCheckOut;
    }

    public void setActualCheckOut(LocalDateTime actualCheckOut) {
        this.actualCheckOut = actualCheckOut;
    }
}