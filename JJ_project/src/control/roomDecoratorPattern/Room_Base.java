package control.roomDecoratorPattern;

import control.reservationStatePattern.Reservation;
import control.reservationStatePattern.ReservationStatus;

// concrete class implements room interface
public class Room_Base implements I_Room
{
    private String description;
    private int roomNumber;
    private String roomType;
    private double roomCost;
    private Reservation reservation;

    // every instance of control.roomDecoratorPattern will have a reservation which with have a state
    // this should allow us to dynamically change the state of the control.roomDecoratorPattern

    // singleton database constructor
    public Room_Base(String description, int roomNumber, double roomCost, Reservation reservation)
    {
        this.description = description;
        this.roomNumber = roomNumber;
        this.roomCost = roomCost;
        this.reservation = reservation;
        this.reservation.setStatus(ReservationStatus.NEW);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return roomCost;
    }

    @Override
    public int getNumber() {
        return roomNumber;
    }

    @Override
    public Reservation getReservation() {
        return reservation;
    }

    @Override
    public String getRoomType() {
        return null;
    }

}
