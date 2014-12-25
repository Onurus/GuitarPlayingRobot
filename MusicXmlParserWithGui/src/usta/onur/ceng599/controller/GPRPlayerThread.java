package usta.onur.ceng599.controller;

import java.util.List;

import usta.onur.ceng599.model.GPRNote;
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
					// TODO STUB
					System.out.println(node.getValue());
					Singleton.gprView.setProgres((index * 100) / length);

					sleep((long) (node.getDuration() * durationCoefficient));
					index++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
