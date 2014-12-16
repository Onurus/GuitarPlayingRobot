package usta.onur.ceng599.converter;

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

public class OnurXmlParserListener implements ParserListener {

	@Override
	public void voiceEvent(Voice voice) {
		System.out.println("voice.getVoice() : " + voice.getVoice());
	}

	@Override
	public void tempoEvent(Tempo tempo) {
		System.out.println("tempo.getTempo() : " + tempo.getTempo());
	}

	@Override
	public void instrumentEvent(Instrument instrument) {
		System.out.println("instrument.getInstrumentName() : "
				+ instrument.getInstrumentName());

	}

	@Override
	public void layerEvent(Layer layer) {
		System.out.println("layer.getLayer() : " + layer.getLayer());

	}

	@Override
	public void measureEvent(Measure measure) {
		System.out.println("measure:" + measure);

	}

	@Override
	public void timeEvent(Time time) {
		System.out.println("time:" + time);
	}

	@Override
	public void keySignatureEvent(KeySignature keySig) {
		System.out.println("keySig:" + keySig.getKeySig());

	}

	@Override
	public void controllerEvent(Controller controller) {
		System.out.println("controller:" + controller);

	}

	@Override
	public void channelPressureEvent(ChannelPressure channelPressure) {
		System.out.println("channelPressure:" + channelPressure);

	}

	@Override
	public void polyphonicPressureEvent(PolyphonicPressure polyphonicPressure) {
		System.out.println("polyphonicPressure:" + polyphonicPressure);

	}

	@Override
	public void pitchBendEvent(PitchBend pitchBend) {
		System.out.println("pitchBend:" + pitchBend);

	}

	@Override
	public void noteEvent(Note note) {
		System.out.println("note : " + note.getValue() + " duration:"
				+ note.getDuration() + " : " + note.getMusicString());

	}

	@Override
	public void sequentialNoteEvent(Note note) {
		System.out.println("sequentialNoteEvent");
	}

	@Override
	public void parallelNoteEvent(Note note) {
		System.out.println("parallelNoteEvent");
	}

}
