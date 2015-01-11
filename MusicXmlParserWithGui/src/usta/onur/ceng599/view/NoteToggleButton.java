package usta.onur.ceng599.view;

import javax.swing.JToggleButton;

public class NoteToggleButton extends JToggleButton
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String noteCode = "";

	public NoteToggleButton(String noteCode)
	{
		super(noteCode);
		this.noteCode = noteCode;
	}

	public String getNoteCode()
	{
		return noteCode;
	}

	public void setNoteCode(String noteCode)
	{
		this.noteCode = noteCode;
	}
}
