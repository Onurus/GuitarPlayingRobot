package usta.onur.ceng599.controller;

import java.io.File;

import org.jfugue.MusicStringParser;
import org.jfugue.MusicStringRenderer;
import org.jfugue.MusicXmlParser;
import org.jfugue.MusicXmlRenderer;
import org.jfugue.Pattern;

public class MusicXMLFileHelper {


	public void write(File outputFile, Pattern musicPattern) throws Exception {
		MusicXmlRenderer renderer = new MusicXmlRenderer();

		MusicStringParser parser = new MusicStringParser();
		parser.addParserListener(renderer);
		parser.parse(musicPattern);

		// FileHelper fileHelper = new FileHelper();
		// fileHelper.write(outputFile, renderer.getMusicXMLString());
	}

	public static Pattern read(File inputFile) throws Exception {
		MusicStringRenderer renderer = new MusicStringRenderer();

		MusicXmlParser parser = new MusicXmlParser();

		parser.addParserListener(renderer);
		parser.parse(inputFile);

		return renderer.getPattern();
	}
}
