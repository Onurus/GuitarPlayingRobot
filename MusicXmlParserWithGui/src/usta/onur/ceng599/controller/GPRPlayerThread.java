package usta.onur.ceng599.controller;

import java.util.List;

import usta.onur.ceng599.converter.MusicalConverter;
import usta.onur.ceng599.model.GPRCommand;
import usta.onur.ceng599.model.GPRNote;
import usta.onur.ceng599.model.GuitarPosition;
import usta.onur.ceng599.starter.Singleton;

public class GPRPlayerThread extends Thread implements Runnable {

	static final int moveTimeMilisecond = 300;
	private double durationCoefficient = 5;
	private List<GPRNote> noteList;
	private int index;

	boolean isPlaying;
	private int length;
	public GPRPlayerThread(int shortestDuration, List<GPRNote> list) {
		super();
		this.durationCoefficient = moveTimeMilisecond / shortestDuration;
		System.out.println(durationCoefficient);
		this.noteList = list;
		isPlaying = false;
		index = 0;
		length = noteList.size();
	}

	@Override
	public void run() {
		isPlaying = true;
		Singleton.gprView.setStatus("Playing");
		try {
			while (true) {
				if (length > index) {
					GPRNote node = noteList.get(index);
					playNote(node);
					Singleton.gprView.setProgres((index * 100) / length);
					index++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void playNote(GPRNote node) throws InterruptedException {
		long totalDuration = (long) (node.getDuration() * durationCoefficient);
		
		List<GuitarPosition> possiblePositions = MusicalConverter
				.convertNoteToListOfPossiblePositions(node);
		if (possiblePositions.size() > 0) {
			GuitarPosition guitarPosition = possiblePositions.get(0);
			sleep(totalDuration / 10);
			send(MusicalConverter.convertGoPosition(guitarPosition));
			sleep(totalDuration / 10);
			send(MusicalConverter.convertPushPosition(guitarPosition));
			sleep(totalDuration * 2 / 10);
			send(MusicalConverter.convertTouchPosition(guitarPosition));
			sleep(totalDuration * 5 / 10);
			send(MusicalConverter.convertPullPosition(guitarPosition));
			sleep(totalDuration / 10);
		} else {
			System.err.println("Nota bulunamadý");
		}
	}

	private void send(GPRCommand command) {
		Singleton.arduinoSerialConnector.write(command.getValue());
	}
}
