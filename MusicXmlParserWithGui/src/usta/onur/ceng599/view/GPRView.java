package usta.onur.ceng599.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

public class GPRView extends JFrame {

	private JButton importBtn;
	private JButton playBtn;
	private JButton infoBtn;
	private JButton deleteBtn;
	private JButton exitBtn;
	private JLabel statusbar;
	private JProgressBar jProgressBar;
	private JToolBar vertical;
	
	private void addVerticalButton(JButton... btnList) {
		for (int i = 0; i < btnList.length; i++) {
			JButton btn = btnList[i];
			btn.setBorder(new EmptyBorder(4, 4, 4, 4));

			btn.setSize(50, 50);
			vertical.add(btn);
		}
	}

	public GPRView() throws HeadlessException {

		vertical = new JToolBar(JToolBar.VERTICAL);
		vertical.setFloatable(false);
		vertical.setMargin(new Insets(20, 5, 5, 5));

		exitBtn = new JButton(new ImageIcon("img/shutdown-64.png"));
		importBtn = new JButton(new ImageIcon("img/audio_file-64.png"));
		playBtn = new JButton(new ImageIcon("img/play-64.png"));
		infoBtn = new JButton(new ImageIcon("img/info-64.png"));
		deleteBtn = new JButton(new ImageIcon("img/delete-64.png"));

		addVerticalButton(infoBtn, importBtn, playBtn, deleteBtn, exitBtn);

		add(vertical, BorderLayout.EAST);

		add(new JPanel(), BorderLayout.CENTER);


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

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}
}
