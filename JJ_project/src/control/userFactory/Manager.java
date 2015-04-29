package control.userFactory;

import boundary.Manager_UI;


public class Manager extends User {

	private final Manager_UI gui_manager = new Manager_UI();

	public Manager(String username, String password, String userType, boolean gui) {

		super(username, password, userType);
		if (gui) {
			gui_manager.displayGUI(username);
			System.out.println("Manager GUI launched");
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
