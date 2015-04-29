package entity;

import control.reservationStatePattern.Reservation;
import control.reservationStatePattern.ReservationStatus;
import control.roomDecoratorPattern.*;
import control.userFactory.Guest;
import control.userFactory.Manager;
import control.userFactory.Receptionist;
import control.userFactory.User;

import java.util.ArrayList;


public class SingletonDatabase {

    private static SingletonDatabase instance;

    private static ArrayList<Room> allRooms = new ArrayList<Room>();
    private static ArrayList<User> registeredUsers = new ArrayList<User>();


    // declared private constructor
    private SingletonDatabase()
    {
	    // false == do not show gui
        registeredUsers.add(new Manager("jim", "123", "Manager", false));
        registeredUsers.add(new Receptionist("pat", "456", "Receptionist", false));
        registeredUsers.add(new Guest("joe", "789", "Guest", "123456","limerick", "(087)789654", false));

        // create rooms using decorator pattern
        Room_Family one = new Room_Family(new Room_Base("Sleeps 3", 1, 30.00, new Reservation()));
        Room_Family two = new Room_Family(new Room_Base("Sleeps 3", 2, 30.00, new Reservation()));
        Room_Family three = new Room_Family(new Room_Base("Sleeps 3", 3, 30.00, new Reservation()));

        Room_KingSize four = new Room_KingSize(new Room_Base("Sleeps 5", 4, 30.00, new Reservation()));
        Room_KingSize five = new Room_KingSize(new Room_Base("Sleeps 5", 5, 30.00, new Reservation()));
        Room_KingSize six = new Room_KingSize(new Room_Base("Sleeps 5", 6, 30.00, new Reservation()));

        Room_Single seven = new Room_Single(new Room_Base("Sleeps 1", 7, 30.00, new Reservation()));
        Room_Single eight = new Room_Single(new Room_Base("Sleeps 1", 8, 30.00, new Reservation()));
        Room_Single nine = new Room_Single(new Room_Base("Sleeps 1", 9, 30.00, new Reservation()));

        // add to allRooms
        allRooms.add(one);
        allRooms.add(two);
        allRooms.add(three);

        allRooms.add(four);
        allRooms.add(five);
        allRooms.add(six);

        allRooms.add(seven);
        allRooms.add(eight);
        allRooms.add(nine);


        for(int i = 0; i < allRooms.size(); i++) {
            allRooms.get(i).getReservation().setStatus(ReservationStatus.NEW);
        }

    }

    // access to the static database
    public static SingletonDatabase getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonDatabase();
	        System.out.println("Singleton database instanced");
        }
        return instance;
    }

    public User searchUsers(String username)
    {
        for(int i = 0; i < registeredUsers.size(); i++)
        {
            if(registeredUsers.get(i).getUsername().equals(username))
            {
                return registeredUsers.get(i);
            }
        }
        return null;
    }


    public Room searchRooms(int roomNumber)
    {
        for(int i = 0; i < allRooms.size(); i++)
        {
            if(allRooms.get(i).getNumber() == (roomNumber))
            {
                return allRooms.get(i);
            }
        }
        return null;
    }


    public ArrayList<Room> getRooms() {
        return allRooms;
    }



    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }
}
