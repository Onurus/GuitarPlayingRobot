package usta.onur.ceng599.converter;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.jfugue.MusicXmlParser;

public class XMLParser {


	public static void main(String[] args) {


		File file = new File(
				"I:\\RoboticJava\\MusicXmlParserWithGui\\unzippedXml\\lg-616508990419757822.xml");

		// new XMLParser().parseXml(file);
		testMusicXmlParser(file);
	}

	private static void testMusicXmlParser(File fileXML) {

		try {
			FileInputStream fisXML = new FileInputStream(fileXML);
			FileChannel fc = fisXML.getChannel();
			ByteBuffer buf = ByteBuffer.allocate((int) fc.size());
			fc.read(buf);
			buf.flip();
			MusicXmlParser MusicXMLIn = new MusicXmlParser();
			OnurXmlParserListener onurXmlParserListener = new OnurXmlParserListener();
			MusicXMLIn.addParserListener(onurXmlParserListener);

			MusicXMLIn.parse(fileXML);

			// Playing...



		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
