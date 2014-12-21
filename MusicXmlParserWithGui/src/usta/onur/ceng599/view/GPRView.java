package usta.onur.ceng599.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class GPRView extends JFrame {

	private JButton connectBtn;
	private JButton importBtn;
	private JButton playBtn;
	private JButton keyboardBtn;
	private JButton infoBtn;

	private JLabel statusbar;
	private JProgressBar jProgressBar;
	private JToolBar vertical;
	
	private void addVerticalButton(JButton... btnList) {
		for (int i = 0; i < btnList.length; i++) {
			JButton btn = btnList[i];
			btn.setSize(50, 50);
			btn.setBorder(new EmptyBorder(4, 4, 4, 4));


			vertical.add(btn);
		}
	}

	public GPRView() throws HeadlessException {

		vertical = new JToolBar(JToolBar.VERTICAL);
		vertical.setFloatable(false);
		vertical.setMargin(new Insets(20, 5, 5, 5));

		connectBtn = new JButton(new ImageIcon("img/arduino.png"));
		importBtn = new JButton(new ImageIcon("img/audio_file-64.png"));
		playBtn = new JButton(new ImageIcon("img/play-64.png"));
		keyboardBtn = new JButton(new ImageIcon("img/keyboard.png"));
		infoBtn = new JButton(new ImageIcon("img/info-64.png"));


		addVerticalButton(connectBtn, importBtn, playBtn, keyboardBtn, infoBtn);

		add(vertical, BorderLayout.CENTER);

		// add(new JPanel(), BorderLayout.CENTER);


		statusbar = new JLabel("STATUSBAR");
		statusbar.setPreferredSize(new Dimension(300, 20));

		jProgressBar = new JProgressBar();
		jProgressBar.setPreferredSize(new Dimension(300, 20));

		JToolBar horizontal = new JToolBar(JToolBar.HORIZONTAL);
		horizontal.setFloatable(false);
		// horizontal.setMargin(new Insets(2, 2, 2, 2));

		horizontal.add(statusbar);
		horizontal.add(jProgressBar);
		add(horizontal, BorderLayout.NORTH);


		setIconImage(new ImageIcon("img/guitar-64.png").getImage());
		setTitle("Ceng 599 - Guitar Playing Robot Project");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);

	}

	public void setStatus(String txt) {
		this.statusbar.setText(txt);

	}

	public void setProgres(int value) {
		jProgressBar.setValue(value);
	}

	public JButton getImportBtn() {
		return importBtn;
	}

	public void setImportBtn(JButton importBtn) {
		this.importBtn = importBtn;
	}

	public JButton getPlayBtn() {
		return playBtn;
	}

	public void setPlayBtn(JButton playBtn) {
		this.playBtn = playBtn;
	}

	public JButton getInfoBtn() {
		return infoBtn;
	}

	public void setInfoBtn(JButton infoBtn) {
		this.infoBtn = infoBtn;
	}

	public JButton getConnectBtn() {
		return connectBtn;
	}

	public void setConnectBtn(JButton connectBtn) {
		this.connectBtn = connectBtn;
	}

	public JButton getKeyboardBtn() {
		return keyboardBtn;
	}

	public void setKeyboardBtn(JButton keyboardBtn) {
		this.keyboardBtn = keyboardBtn;
	}

}
