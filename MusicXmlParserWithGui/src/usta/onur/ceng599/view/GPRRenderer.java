package usta.onur.ceng599.view;

import usta.onur.ceng599.model.GPRStates;


public class GPRRenderer {
	private  GPRStates mxlFile;
	private GPRStates connect;
	private GPRStates playingStatus;
	private GPRStates keybordStatus;
	
	public void initialize() {
		mxlFile = GPRStates.No_File_Imported;
		connect = GPRStates.Not_Connected;
		playingStatus = GPRStates.Finished;
		keybordStatus = GPRStates.Keyboard_Off;
	}

	public void setMxlFile(GPRStates mxlFile) {
		this.mxlFile = mxlFile;
		renderAgain();
	}

	public void setConnect(GPRStates connect) {
		this.connect = connect;
		renderAgain();
	}

	public void setPlayingStatus(GPRStates playingStatus) {
		this.playingStatus = playingStatus;
		renderAgain();
	}

	public void setKeybordStatus(GPRStates keybordStatus) {
		this.keybordStatus = keybordStatus;
		renderAgain();
	}

	private void renderAgain() {

	}
}
