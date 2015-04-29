package control.roomDecoratorPattern;

/*
* Decorator pattern allows a user to add new functionality
* to an existing object without altering its structure.
*
* The pattern creates a decorator class which wraps the original class
* and provides additional functionality keeping class methods signature intact.
*
*/

import control.reservationStatePattern.Reservation;

// room interface
public interface I_Room
{
    String getDescription();
    double getCost();
    int getNumber();
    Reservation getReservation();
    String getRoomType();
}
