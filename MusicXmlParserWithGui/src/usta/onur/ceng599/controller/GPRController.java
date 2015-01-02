package usta.onur.ceng599.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import usta.onur.ceng599.converter.GPRMXLParseHelper;
import usta.onur.ceng599.converter.GPRXmlParserListener;
import usta.onur.ceng599.model.GPRStates;
import usta.onur.ceng599.starter.Singleton;

public class GPRController {

	static String unzipDir = "./unzippedXml";
	private GPRXmlParserListener onurXmlParserListener;
	public void initialize() {
		onurXmlParserListener = null;
		Singleton.gprView.getImportBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.addChoosableFileFilter(new FileFilter() {
							@Override
							public boolean accept(File f) {
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

		for (final File fileDelete : new File(unzipDir).listFiles()) {
			fileDelete.delete();
		}
		try {
			ZipFile file = new ZipFile(zippedFile);
			file.extractAll(unzipDir);
		} catch (ZipException e) {
			e.printStackTrace();
		}
		Singleton.gprView.setProgres(23);
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
	}

	private void pause() {
		// TODO Auto-generated method stub

	}

	private void play() {
		if (onurXmlParserListener == null) {
			Singleton.gprView.setStatus("Song haven't been load!");
		} else {
			new GPRPlayerThread(onurXmlParserListener.smallestDuration,
					onurXmlParserListener.liste).start();
		}

	}

	/**
	 * Arduino ile baðlantýnýn kurulmasýný saðlar. Baðlantý kurulduysa buton
	 * pasif hale geçer.
	 * 
	 */
	protected void connectPressed() {
		Singleton.gprView.getConnectBtn().setEnabled(false);
		if (Singleton.arduinoSerialConnector.connect()) {
			Singleton.gprRenderer.setConnect(GPRStates.Connected);
		} else {
			Singleton.gprRenderer.setConnect(GPRStates.Not_Connected);
		}
	}


	// New XML Parser
	private void parseXml(File fileEntry) {
		onurXmlParserListener = GPRMXLParseHelper.getParsListener(fileEntry);
		Singleton.gprView.setProgres(100);
		Singleton.gprView.setStatus("Parsed - Rendered - Ready to Play");
		Singleton.gprRenderer.setMxlFile(GPRStates.Imported);

		System.out
				.println("liste.size():" + onurXmlParserListener.liste.size());
		System.out.println("smallestDuration:"
				+ onurXmlParserListener.smallestDuration);
	}

}
