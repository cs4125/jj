package control.reservationStatePattern;

/**
 * take advantage of polymorphism and inheritance using Enum Class.
 * a closed set of classes that implement base class (ReservationStatus)
 * each enum value has its own distinct implementation of ReservationStatusOperations
 * there is no switch-case or if-else construct, only pure polymorphism.
 */
public enum ReservationStatus implements ReservationStatusOperations // Context
{
        NEW(new NewRso()),

        ACCEPTED(new AcceptedRso()),

        PAID(new PaidRso()),

        CANCELLED(new CancelledRso());

        private final ReservationStatusOperations operations;

        ReservationStatus(ReservationStatusOperations operations)
        {
            this.operations = operations; // setting the context
        }


        @Override

        public ReservationStatus accept(Reservation reservation) {

            return operations.accept(reservation);

        }


        @Override

        public ReservationStatus charge(Reservation reservation) {

            return operations.charge(reservation);

        }

        @Override

        public ReservationStatus cancel(Reservation reservation) {

            return operations.cancel(reservation);

        }


}
