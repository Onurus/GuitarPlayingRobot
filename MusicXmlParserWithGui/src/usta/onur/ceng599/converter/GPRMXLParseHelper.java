package usta.onur.ceng599.converter;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.jfugue.MusicXmlParser;

public class GPRMXLParseHelper {
	public static GPRXmlParserListener getParsListener(File fileXML) {
		GPRXmlParserListener onurXmlParserListener = null;
		try {
			FileInputStream fisXML = new FileInputStream(fileXML);
			FileChannel fc = fisXML.getChannel();
			ByteBuffer buf = ByteBuffer.allocate((int) fc.size());
			fc.read(buf);
			buf.flip();
			MusicXmlParser MusicXMLIn = new MusicXmlParser();
			onurXmlParserListener = new GPRXmlParserListener();
			MusicXMLIn.addParserListener(onurXmlParserListener);
			MusicXMLIn.parse(fileXML);
			fisXML.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return onurXmlParserListener;
	}
}
