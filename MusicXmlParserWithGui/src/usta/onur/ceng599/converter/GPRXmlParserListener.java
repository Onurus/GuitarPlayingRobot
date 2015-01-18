package usta.onur.ceng599.converter;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.ChannelPressure;
import org.jfugue.Controller;
import org.jfugue.Instrument;
import org.jfugue.KeySignature;
import org.jfugue.Layer;
import org.jfugue.Measure;
import org.jfugue.Note;
import org.jfugue.ParserListener;
import org.jfugue.PitchBend;
import org.jfugue.PolyphonicPressure;
import org.jfugue.Tempo;
import org.jfugue.Time;
import org.jfugue.Voice;

import usta.onur.ceng599.model.GPRNote;

public class GPRXmlParserListener implements ParserListener {

	public List<GPRNote> liste;
	public int smallestDuration;

	public GPRXmlParserListener() {
		super();
		this.liste = new ArrayList<GPRNote>();
		smallestDuration = 999999;
	}

	@Override
	public void voiceEvent(Voice voice) {
	}

	@Override
	public void tempoEvent(Tempo tempo) {
	}

	@Override
	public void instrumentEvent(Instrument instrument) {

	}

	@Override
	public void layerEvent(Layer layer) {
	}

	@Override
	public void measureEvent(Measure measure) {

	}

	@Override
	public void timeEvent(Time time) {
	}

	@Override
	public void keySignatureEvent(KeySignature keySig) {
		// System.out.println("keySig:" + keySig.getKeySig());

	}

	@Override
	public void controllerEvent(Controller controller) {

	}

	@Override
	public void channelPressureEvent(ChannelPressure channelPressure) {

	}

	@Override
	public void polyphonicPressureEvent(PolyphonicPressure polyphonicPressure) {

	}

	@Override
	public void pitchBendEvent(PitchBend pitchBend) {

	}

	@Override
	public void noteEvent(Note note) {
		addToList(new GPRNote(note.getValue(), Integer.parseInt(note
				.getDuration() + "")));


	}

	private void addToList(GPRNote gprNote) {
		liste.add(gprNote);
		if (gprNote.getDuration() < smallestDuration) {
			smallestDuration = gprNote.getDuration();
		}
	}

	@Override
	public void sequentialNoteEvent(Note note) {
		System.out.println("sequentialNoteEvent");
		System.out.println("note : " + note.getValue() + " duration:"
				+ note.getDuration() + " : " + note.getMusicString());
	}

	@Override
	public void parallelNoteEvent(Note note) {
		System.out.println("parallelNoteEvent");
		System.out.println("note : " + note.getValue() + " duration:"
				+ note.getDuration() + " : " + note.getMusicString());
	}

	public void setSmallestDuration() {
		for (GPRNote gprNote : liste) {
			if (gprNote.getDuration() < smallestDuration) {
				smallestDuration = gprNote.getDuration();
			}
		}
	}

}
