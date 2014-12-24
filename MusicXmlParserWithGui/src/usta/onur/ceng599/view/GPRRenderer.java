package usta.onur.ceng599.view;

import usta.onur.ceng599.model.GPRStates;
import usta.onur.ceng599.starter.Singleton;


public class GPRRenderer {
	private GPRStates mxlFile;
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
		if (this.connect == GPRStates.Connected) {
			Singleton.gprView.setStatus("Connected :)");
			Singleton.gprView.setProgres(100);
		} else {
			Singleton.gprView.setStatus("Failed !");
		}
		Singleton.gprView.getConnectBtn().setEnabled(true);
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

	public GPRStates getMxlFile() {
		return mxlFile;
	}

	public GPRStates getConnect() {
		return connect;
	}

	public GPRStates getPlayingStatus() {
		return playingStatus;
	}

	public GPRStates getKeybordStatus() {
		return keybordStatus;
	}
}
