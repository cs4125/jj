package control.userFactory;

import boundary.Guest_UI;


public class Guest extends User {

	private final Guest_UI gui_guest = new Guest_UI();


	protected Guest(String username, String password, String userType, boolean gui) {

		super(username, password, userType);

		if (gui) {
			gui_guest.displayGUI(username);
		}
	}

	public Guest(String username, String password, String userType, String passportNo, String address, String
			telephone, boolean gui) {

		super(username, password, userType, passportNo, address, telephone);

		if (gui) {
			gui_guest.displayGUI(username);
			System.out.println("Guest GUI launched");
		}
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
