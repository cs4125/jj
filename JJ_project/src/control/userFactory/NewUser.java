package control.userFactory;

import control.Login_Controller;
import control.Main;

import javax.swing.*;


public class NewUser extends User {


	public NewUser(String newUser) {
		super();
	}

	public NewUser(String username, String password, String userType,
	               String address, String passport, String telephone) {

		// create instance of UserFactory
		UserFactory userF = new UserFactory();

		// add new user to database - no Login_UI gui
		Login_Controller newUser_ = new Login_Controller(true);

		// cast to approprite instance of User
		if (userType.equals("Guest")) {

			Guest guest = (Guest) userF.createUser(username, password, userType, false);
			guest.setPassportNo(passport);
			guest.setAddress(address);
			guest.setTelephone(telephone);
			// add to entity database
			newUser_.singletonDatabase.getRegisteredUsers().add(guest);
			System.out.println("New Guest added");

		} else if (userType.equals("Receptionist")) {
			Receptionist receptionist = (Receptionist) userF.createUser(username, password, userType, false);
			receptionist.setPassportNo(passport);
			receptionist.setAddress(address);
			receptionist.setTelephone(telephone);
			// add to entity database
			newUser_.singletonDatabase.getRegisteredUsers().add(receptionist);
			System.out.println("New Receptionist added");

		} else if (userType.equals("Manager")) {
			Manager manager = (Manager) userF.createUser(username, password, userType, false);
			manager.setPassportNo(passport);
			manager.setAddress(address);
			manager.setTelephone(telephone);
			// add to entity database
			newUser_.singletonDatabase.getRegisteredUsers().add(manager);
			System.out.println("New Manager added");
		}


		// announce
		JOptionPane.showMessageDialog(null, username + " registered as " + userType, null, 1);

		// display GUI
		JOptionPane.showMessageDialog(null, "jim 123 = Manager"
				+ "\npat 456 = Receptionist"
				+ "\njoe 789 = Guest", null, 1);
	}


	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUserType() {
		return userType;
	}

	@Override
	public String getPassportNo() {
		return passportNo;
	}

	@Override
	protected String getAddress() {
		return null;
	}

	@Override
	protected String getTelephone() {
		return telephone;
	}

	@Override
	protected void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Override
	protected void setAddress(String address) {
		this.address = address;
	}

	@Override
	protected void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

}

