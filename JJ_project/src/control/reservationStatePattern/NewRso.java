package control.reservationStatePattern;


public class NewRso implements ReservationStatusOperations
{

    @Override
    public ReservationStatus accept(Reservation reservation) {
        System.out.println("Your reservation has been accepted.");
        return ReservationStatus.ACCEPTED;
    }

    @Override
    public ReservationStatus charge(Reservation reservation) {
        System.out.println("Your reservation has been charged.");
        return ReservationStatus.PAID;
    }

    @Override
    public ReservationStatus cancel(Reservation reservation) {
        System.out.println("Your reservation has been cancelled.");
        return ReservationStatus.CANCELLED;
    }
}
