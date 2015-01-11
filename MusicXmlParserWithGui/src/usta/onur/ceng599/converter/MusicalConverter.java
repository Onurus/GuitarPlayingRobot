package usta.onur.ceng599.converter;

import usta.onur.ceng599.model.GPRCommand;
import usta.onur.ceng599.model.GPRNote;
import usta.onur.ceng599.model.NoteCommand;

public class MusicalConverter {



	public static NoteCommand noteToPressAndTouchCommand(GPRNote note) {
		NoteCommand commands = null;
		switch (note.getValue()) {
		case 28:
			commands = new NoteCommand(GPRCommand.Press10, GPRCommand.Touch1);
			break;
		case 29:
			commands = new NoteCommand(GPRCommand.Press11, GPRCommand.Touch1);
			break;
		case 30:
			commands = new NoteCommand(GPRCommand.Press12, GPRCommand.Touch1);
			break;
		case 31:
			commands = new NoteCommand(GPRCommand.Press13, GPRCommand.Touch1);
			break;
		case 32:
			commands = new NoteCommand(GPRCommand.Press14, GPRCommand.Touch1);
			break;
		case 33:
			commands = new NoteCommand(GPRCommand.Press20, GPRCommand.Touch2);
			break;
		case 34:
			commands = new NoteCommand(GPRCommand.Press21, GPRCommand.Touch2);
			break;
		case 35:
			commands = new NoteCommand(GPRCommand.Press22, GPRCommand.Touch2);
			break;
		case 36:
			commands = new NoteCommand(GPRCommand.Press23, GPRCommand.Touch2);
			break;
		case 37:
			commands = new NoteCommand(GPRCommand.Press24, GPRCommand.Touch2);
			break;
		}

		return commands;
	}


}
