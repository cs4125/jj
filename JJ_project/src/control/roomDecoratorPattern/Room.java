package control.roomDecoratorPattern;

import control.reservationStatePattern.Reservation;

// abstract decorator class implements room interface
// has room object as instance variable
public abstract class Room implements I_Room
{
    protected I_Room tempI_room;

    public Room(I_Room i_room)
    {
        tempI_room = i_room;
    }

    @Override
    public String getDescription() {
        return tempI_room.getDescription();
    }

    @Override
    public double getCost() {
        return tempI_room.getCost();
    }

    @Override
    public int getNumber() {
        return tempI_room.getNumber();
    }

    @Override
    public Reservation getReservation() {
        return tempI_room.getReservation();
    }

    public String getRoomType() {
        return tempI_room.getRoomType();
    }
}
