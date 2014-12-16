package usta.onur.ceng599.starter;

import usta.onur.ceng599.controller.GPRController;
import usta.onur.ceng599.view.GPRView;

public class Singleton {
	public static GPRView gprView;
	public static GPRController gprController;

	public static void initialize() {
		gprView = new GPRView();
		gprController = new GPRController();
	}
}
