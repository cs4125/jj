package control.reservationStatePattern;

import java.util.Date;


public class Reservation {

    private int id;

    private String name;

    private Date date;

    private double price;

    private ReservationStatus status = ReservationStatus.NEW;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void accept() {

        setStatus(status.accept(this));
    }

    public void charge() {

        setStatus(status.charge(this));

    }

    public void cancel() {

        setStatus(status.cancel(this));
    }

    public void setStatus(ReservationStatus status) {

        if (status != null && status != this.status) {

            System.out.println("Reservation#" + id + ": changing status from " + this.status + " to " + status);

            this.status = status;
        }
    }
}
