package usta.onur.ceng599.model;

public class GuitarPosition {

	private int tel;
	private int tab;

	public GuitarPosition() {
		super();
		this.tel = 1;
		this.tab = 0;
	}

	public GuitarPosition(int tel, int tab) {
		super();
		this.tel = tel;
		this.tab = tab;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getTab() {
		return tab;
	}

	public void setTab(int tab) {
		this.tab = tab;
	}
	
}
