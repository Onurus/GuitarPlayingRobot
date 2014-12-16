package usta.onur.ceng599.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.midi.Sequencer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.jfugue.MidiRenderer;
import org.jfugue.MusicStringParser;
import org.jfugue.Pattern;
import org.jfugue.Player;

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
							fileChoosen(file);
						}
					}
				});

		Singleton.gprView.getPlayBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Player player = new Player();
				player.play("E5s A5s C6s B5s E5s B5s D6s C6i E6i G#5i E6i | A5s E5s A5s C6s B5s E5s B5s D6s C6i A5i Ri");

			}
		});

	}

	protected void fileChoosen(File zippedFile) {
		try {
			ZipFile file = new ZipFile(zippedFile);
			file.extractAll(unzipDir);
			System.out.println(file.getFile());
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Singleton.gprView.setProgres(10);
		Singleton.gprView.setStatus("mxl File unzipped");



		for (final File fileEntry : new File(unzipDir).listFiles()) {

			if (fileEntry.getName().endsWith(".xml"))
				parseXml(fileEntry);
		}

	}

	private Sequencer sequencer;
	private MusicStringParser parser;
	private MidiRenderer renderer;

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
