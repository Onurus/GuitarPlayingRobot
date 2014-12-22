package usta.onur.ceng599.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GPRSimulator extends JFrame {


	HashMap<String, Integer> hashMap;
	
	public GPRSimulator(String arg0) throws HeadlessException {
	
		super(arg0);
		try {
			JLabel label = new JLabel(
					new ImageIcon("resources/klavyeGitar.png"));
			setContentPane(label);
			setLayout(new BorderLayout());
			hashMap = new HashMap<String, Integer>();
			pack();
			setLocationRelativeTo(null);
		} catch (HeadlessException exp) {
			exp.printStackTrace();
		}
	}

	public void drawRectangle(char pressed) {
		if (hashMap.get(pressed + "") == null) {
			hashMap.put(pressed + "", (int) pressed);
			printHashMap();
		}

	}

	public void reliese(char pressed) {
		hashMap.remove(pressed + "");
		printHashMap();
	}

	private void printHashMap() {
		System.out.println(hashMap.keySet());

	}
}
