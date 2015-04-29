package control.userFactory;


public abstract class User {


    protected String username;
    protected String password;
    protected String userType;
    protected String passportNo;
    protected String address;
    protected String telephone;


    // new user
    protected User() {

    }

    // database user
    protected User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    // add user to database
    protected User(String username, String password, String userType,
                   String passportNo, String address, String telephone){
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.passportNo = passportNo;
        this.address = address;
        this.telephone = telephone;
    }

    public abstract String getUsername();
    public abstract String getPassword();
    public abstract String getUserType();
    public abstract String getPassportNo();
    protected abstract String getAddress();
    protected abstract String getTelephone();
    protected abstract void setPassportNo(String passportNo);
    protected abstract void setAddress (String address);
    protected abstract void  setTelephone (String telephone);
    public abstract void setUserType(String userType);
    public abstract void setUsername(String username);
    public abstract void setPassword(String password);
}
