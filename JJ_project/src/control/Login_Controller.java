package control;

import boundary.Login_UI;
import control.loginObserverPattern.I_Observer;
import control.loginObserverPattern.I_Subject;
import control.loginObserverPattern.LogInRecord;
import control.userFactory.*;
import entity.SingletonDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;


public class Login_Controller implements I_Subject {

	private static User user;
	private String username, password, userType;
	private Date loginDate;

	// database static - persistent throughout program lifespan
	public static SingletonDatabase singletonDatabase = SingletonDatabase.getInstance();

	// Login_Controller
	private ArrayList<I_Observer> observerList;

	// constructor for boundary.GUI_Login_Register
	public Login_Controller() {
		Login_UI gui_login = new Login_UI();
		gui_login.displayGUI();
	}

	// constructor for boundary.GUI_Login_Register
	public Login_Controller(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// constructor for boundary.GUI_Login_Register
	public Login_Controller(boolean newUser_) {
		// no gui is required for a new user
	}


	// login method
	public void login() {

		// register one Login_Observer (we could have more)
		observerList = new ArrayList<I_Observer>();
		LogInRecord loginAttempt = new LogInRecord();
		registerObserver(loginAttempt);

		// create user and search in database
		user = singletonDatabase.searchUsers(username);

		if (user != null) {

			// get the password of the found user
			String dbPassword = user.getPassword();

			// successful validation - call User Factory
			if (dbPassword != null && dbPassword.equals(password)) {

				UserFactory makeUser = new UserFactory();

				// create appropriate object
				if (user instanceof Guest) {
					userType = "Guest";
					Guest guestUseCases
							= (Guest) makeUser.createUser(username, password, userType, true);

				} else if (user instanceof Receptionist) {
					userType = "Receptionist";
					Receptionist receptionistUseCases
							= (Receptionist) makeUser.createUser(username, password, userType, true);

				} else if (user instanceof Manager) {
					userType = "Manager";
					Manager managerUseCases
							= (Manager) makeUser.createUser(username, password, userType, true);
				}

				// Login_Observer
				loginDate = new GregorianCalendar().getTime();
				notifyAllObservers(username, userType, loginDate);
			}
		}
		// user does not exist
		else {
			Login_UI gui_login = new Login_UI(username, password);
			gui_login.displayGUI();
		}
	}

	public static User getUser() {
		return user;
	}

	public static String deleteUser(String username) {
		user = singletonDatabase.searchUsers(username);
		singletonDatabase.getRegisteredUsers().remove(user);
		return username + " deleted";
	}

	public static String displayAllUsers() {
		String userStringList = "\n";
		for (User user_ : singletonDatabase.getRegisteredUsers()) {
			userStringList += user_.getUsername() + "\n"
					+ user.getPassword() + "\n"
					+ user.getUserType()
					+ "\n\n";
		}
		return userStringList;
	}

	@Override
	public void registerObserver(I_Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void notifyAllObservers(String username, String guest, Date time) {
		for (I_Observer observer : observerList) {
			observer.update(this);
		}
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getUserType() {
		return userType;
	}

	@Override
	public Date getLoginDate() {
		return loginDate;
	}
}
