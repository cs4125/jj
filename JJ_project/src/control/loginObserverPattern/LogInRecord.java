package control.loginObserverPattern;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogInRecord implements I_Observer {

	@Override
	public void update(I_Subject subject) {

		String username = subject.getUsername();
		String userType = subject.getUserType();
		Date loginDate = subject.getLoginDate();

		try {
			String path = System.getProperty("user.dir");
			path += "/src/loginAttempts.txt";
			File file = new File(path);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(username + " " + userType + " " + loginDate + "\n");
			bw.close();

			System.out.println("Login Attempt Observed\nRecorded to " + path);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

