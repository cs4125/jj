package control.loginObserverPattern;

// when a login occurs, LogRecord.txt is apppended via observer LogInRecord
// LogInRecord observes Login_Controller awaiting notification of a login

public interface I_Observer {

	void update(I_Subject subject);
}
