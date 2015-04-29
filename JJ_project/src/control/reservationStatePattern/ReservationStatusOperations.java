package control.reservationStatePattern;

/**
 *  interface for all business methods
 */
public interface ReservationStatusOperations {

    ReservationStatus accept(Reservation reservation);

    ReservationStatus charge(Reservation reservation);

    ReservationStatus cancel(Reservation reservation);

}
