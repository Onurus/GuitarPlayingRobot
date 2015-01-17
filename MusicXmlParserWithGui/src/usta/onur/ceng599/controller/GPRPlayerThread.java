package usta.onur.ceng599.controller;

import java.util.List;

import usta.onur.ceng599.converter.MusicalConverter;
import usta.onur.ceng599.model.GPRCommand;
import usta.onur.ceng599.model.GPRNote;
import usta.onur.ceng599.model.NoteCommand;
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
		
		NoteCommand noteCommand = MusicalConverter.noteToPressAndTouchCommand(node);
		if(noteCommand !=null){
			System.out.println("noteCommand.press: " + noteCommand.press);
			send(noteCommand.press);
			sleep(totalDuration/5);
			System.out.println("noteCommand.touch: " + noteCommand.touch);
			send(noteCommand.touch);
			System.out.println("totalDuration :" + totalDuration);
			sleep(totalDuration);
		}else {
			System.err.println("Bulunan nota uygun deðil");
		}

	}

	private void send(GPRCommand command) {
		Singleton.arduinoSerialConnector.write(command.getValue());
	}
}
