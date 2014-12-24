package usta.onur.ceng599.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import usta.onur.ceng599.starter.Singleton;

public class KeyboardListener implements KeyListener {


	public void initialize() {

		Singleton.gprKeyboard.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Singleton.gprKeyboard.drawRectangle(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Singleton.gprKeyboard.reliese(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
