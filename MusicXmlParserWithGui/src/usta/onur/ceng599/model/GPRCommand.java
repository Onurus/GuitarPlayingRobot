package usta.onur.ceng599.model;

public enum GPRCommand {

	Press10(10), Press11(11), Press12(12), Press13(13), Press14(14), Press20(20), Press21(
			21), Press22(22), Press23(23), Press24(24), Touch1(71), Touch2(72);


	int value;

	private GPRCommand(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
