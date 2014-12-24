package usta.onur.ceng599.starter;

import usta.onur.ceng599.communication.ArduinoSerialConnector;
import usta.onur.ceng599.controller.GPRController;
import usta.onur.ceng599.controller.KeyboardListener;
import usta.onur.ceng599.view.GPRRenderer;
import usta.onur.ceng599.view.GPRSimulator;
import usta.onur.ceng599.view.GPRView;

public class Singleton {
	public static GPRView gprView;
	public static GPRController gprController;
	public static GPRRenderer gprRenderer;
	public static GPRSimulator gprKeyboard;
	public static KeyboardListener keyboardListener;
	public static ArduinoSerialConnector arduinoSerialConnector;
	public static void initialize() {
		gprView = new GPRView();
		gprController = new GPRController();
		gprController.initialize();
		gprRenderer = new GPRRenderer();
		gprRenderer.initialize();
		gprKeyboard = new GPRSimulator("Keyboard");
		keyboardListener = new KeyboardListener();
		keyboardListener.initialize();
		arduinoSerialConnector = new ArduinoSerialConnector();
	}
}
