package usta.onur.ceng599.model;

public class GPRNote {
	private int value;
	private int duration;

	public GPRNote(int value, int duration) {
		super();
		this.value = value;
		this.duration = duration;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
