package usta.onur.ceng599.model;

public class NoteCommand {
	public GPRCommand press;
	public GPRCommand touch;

	public NoteCommand(GPRCommand press, GPRCommand touch) {
		super();
		this.press = press;
		this.touch = touch;
	}

}
