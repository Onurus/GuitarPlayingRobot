package usta.onur.ceng599.starter;

import java.awt.EventQueue;


public class Launcher {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Singleton.initialize();
				Singleton.gprView.setVisible(true);
				Singleton.gprController.initialize();
			}
		});

	}

}