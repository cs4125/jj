package control;

import control.reservationStatePattern.ReservationStatus;
import control.roomDecoratorPattern.Room;
import entity.SingletonDatabase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Room_Controller {

	private int roomNumber;
	private Room room_;


	// stores all hotel rooms
	private ArrayList<Room> allRooms = SingletonDatabase.getInstance().getRooms();


	public Room_Controller() {

	}

	public Room_Controller(int roomNumber) {
		this.roomNumber = roomNumber;
		room_ = SingletonDatabase.getInstance().searchRooms(roomNumber);
	}

	public String displayAllRooms() {
		String roomDetails = "\n";
		for (Room room_ : allRooms) {
			roomDetails += "Room Number: " + room_.getNumber()
					+ "\nType: " + room_.getRoomType()
					+ "\nDescription: " + room_.getDescription()
					+ "\nCost: " + room_.getCost() + "\n\n";
		}
		return roomDetails;
	}

	public String displayOccupiedRooms() {
		String roomDetails = "\n";
		for (Room room_ : allRooms) {
			if (room_.getReservation().getStatus() == ReservationStatus.ACCEPTED) {
				roomDetails += "Room Number: " + room_.getNumber()
						+ "\nType: " + room_.getRoomType()
						+ "\nDescription: " + room_.getDescription()
						+ "\nCost: " + room_.getCost() + "\n\n";
			}
		}
		return roomDetails;
	}

	public String displayAvailableRooms() {
		String roomDetails = "\n";
		for (Room room_ : allRooms) {
			if (room_.getReservation().getStatus() == ReservationStatus.NEW) {
				roomDetails += "Room Number: " + room_.getNumber()
						+ "\nType: " + room_.getRoomType()
						+ "\nDescription: " + room_.getDescription()
						+ "\nCost: " + room_.getCost() + "\n\n";
			}
		}
		return roomDetails;
	}


	public String displayCancelledReservations() {
		String roomDetails = "\n";
		for (Room room_ : allRooms) {
			if (room_.getReservation().getStatus() == ReservationStatus.CANCELLED) {
				roomDetails += "Room Number: " + room_.getNumber()
						+ "\nType: " + room_.getRoomType()
						+ "\nDescription: " + room_.getDescription()
						+ "\nCost: " + room_.getCost() + "\n\n";
			}
		}
		return roomDetails;
	}

	public void reserveRoom() {

		room_.getReservation().accept();

		if (room_.getReservation().getStatus() == ReservationStatus.NEW) {

			int i = (int) Math.random() * 100000 + 1;
			JOptionPane.showMessageDialog(null, "Reserving room_: "
					+ room_.getNumber(), "Reservation Accepted", JOptionPane.INFORMATION_MESSAGE);

			room_.getReservation().accept();
			room_.getReservation().setPrice(room_.getCost());
			room_.getReservation().setName(Login_Controller.getUser().getUsername());
			room_.getReservation().setId(i);
			room_.getReservation().setDate(new GregorianCalendar().getTime());

			JOptionPane.showMessageDialog(null, "Reservation ID: "
					+ room_.getReservation().getId() + "\nReservation Date: " + room_.getReservation().getDate()
					+ "\nName: " + room_.getReservation().getName() + "\ncontrol.roomDecoratorPattern & Cost: "
					+ room_.getNumber() + " "
					+ room_.getReservation().getPrice(), "Reservation Details", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void cancelReservation() {
		room_.getReservation().cancel();
	}

}
