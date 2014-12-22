package usta.onur.ceng599.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.jfugue.Pattern;

import usta.onur.ceng599.model.GPRStates;
import usta.onur.ceng599.starter.Singleton;

public class GPRController {

	static String unzipDir = "./unzippedXml";

	public void initialize() {
		Singleton.gprView.getImportBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.addChoosableFileFilter(new FileFilter() {
							@Override
							public boolean accept(File f) {
								// TODO Auto-generated method stub
								return f.getName().endsWith(".mxl")
										|| f.isDirectory();
							}

							@Override
							public String getDescription() {
								return "Music XML files";
							}

						});

						int returnVal = fileChooser
								.showOpenDialog(Singleton.gprView);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File file = fileChooser.getSelectedFile();
							importPressed(file);
						}
					}
				});

		Singleton.gprView.getPlayBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				playPressed();

			}
		});

		Singleton.gprView.getConnectBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						connectPressed();
					}
				});

		Singleton.gprView.getKeyboardBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						keyboardPressed();
					}
				});
		Singleton.gprView.getInfoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoPressed();
			}
		});
	}

	/**
	 * Klavye modu açýlýp kapanmasýný saðlayan butona basýlýp basýlmadýðýný
	 * gösterir
	 */
	protected void keyboardPressed() {
		Singleton.gprKeyboard.setVisible(!Singleton.gprKeyboard.isVisible());

	}

	/**
	 * Program ve iþlevi hakkýnda bilgilendirme yapan paneli açar
	 * 
	 */
	protected void infoPressed() {
		// TODO Auto-generated method stub

	}

	/**
	 * MXL dosyasý import edildiðinde çaðýrýlýr. Ziplenmiþ dosya unziplenir
	 * 
	 * @param zippedFile
	 */
	protected void importPressed(File zippedFile) {
		try {
			ZipFile file = new ZipFile(zippedFile);
			file.extractAll(unzipDir);
			System.out.println(file.getFile());
		} catch (ZipException e) {
			e.printStackTrace();
		}
		Singleton.gprView.setProgres(10);
		Singleton.gprView.setStatus("mxl File unzipped");

		for (final File fileEntry : new File(unzipDir).listFiles()) {

			if (fileEntry.getName().endsWith(".xml"))
				parseXml(fileEntry);
		}

	}

	protected void playPressed() {

		if (Singleton.gprRenderer.getPlayingStatus() == GPRStates.Playing) {
			pause();
			Singleton.gprRenderer.setPlayingStatus(GPRStates.Paused);
		} else {
			play();
			Singleton.gprRenderer.setPlayingStatus(GPRStates.Playing);
		}

		

		// Player player = new Player();
		// player.play("E5s A5s C6s B5s E5s B5s D6s C6i E6i G#5i E6i | A5s E5s A5s C6s B5s E5s B5s D6s C6i A5i Ri");

	}

	private void pause() {
		// TODO Auto-generated method stub

	}

	private void play() {
		// TODO Auto-generated method stub

	}

	/**
	 * Arduino ile baðlantýnýn kurulmasýný saðlar. Baðlantý kurulduysa buton
	 * pasif hale geçer.
	 * 
	 */
	protected void connectPressed() {
		// TODO Auto-generated method stub

	}

	// New XML Parser
	private void parseXml(File fileEntry) {

		Pattern pattern = null;
		try {
			pattern = MusicXMLFileHelper.read(fileEntry);

			String[] list = pattern.getTokens();
			for (int i = 0; i < list.length; i++) {
				System.out.println(i + " : " + list[i]);
			}
			// System.out.println(pattern.getMusicString());
			// this.renderer.reset();
			// this.parser.parse(pattern);
			// Sequence sequence = this.renderer.getSequence();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Player player = new Player();
		// player.play(pattern);

	}

}
