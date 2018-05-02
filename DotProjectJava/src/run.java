import java.awt.EventQueue;

import userint.userInt;

//this class runs the program
public class run {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			userInt run = new userInt();
			run.setVisible(true);
		});
		// TODO Auto-generated method stub

	}

}
