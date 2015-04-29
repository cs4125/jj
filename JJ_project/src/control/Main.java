package control;

import boundary.Login_UI;
import entity.SingletonDatabase;

import javax.swing.*;


public class Main {

    // main method
    public static void main(String[] args) {

        // login hint
        JOptionPane.showMessageDialog(null, "jim 123 = Manager"
                + "\npat 456 = Receptionist"
                + "\njoe 789 = Guest", null, 1);

        // run program
        Login_UI loginBox = new Login_UI();
        loginBox.displayGUI();

    }
}
