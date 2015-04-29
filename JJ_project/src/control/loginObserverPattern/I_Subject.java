package control.loginObserverPattern;

// When something changes with the Subject
// the list of registered observers is notified
// we have one registered observer - LogInRecord

import java.util.Date;

public interface I_Subject {

	void registerObserver(I_Observer observer);
	void notifyAllObservers(String username,String userType, Date time);
	String getUsername();
	String getUserType();
	Date getLoginDate();
}
