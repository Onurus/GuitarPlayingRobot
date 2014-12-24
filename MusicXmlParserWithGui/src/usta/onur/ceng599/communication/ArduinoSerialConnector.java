package usta.onur.ceng599.communication;

/*serialPort.setSerialPortParams(DATA_RATE,
 SerialPort.DATABITS_8,
 SerialPort.STOPBITS_1,
 SerialPort.PARITY_NONE);
 so i commented this line. then the program was able to get the number of byte available for reception. but when it executes the line

 input.read(chunk, 0, available);

 it throws an exception.

 here is the whole program that i modified*/

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class ArduinoSerialConnector implements SerialPortEventListener {
	SerialPort serialPort;
	private InputStream input;
	private OutputStream output;
	private static final int TIME_OUT = 1000;
	private static final int DATA_RATE = 9600;
	private static final String portName = "COM4";

	public boolean connect() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}

		if (portId == null) {
			System.out.println("Could not find " + portName + " port.");
			return false;
		}

		try {
			serialPort = (SerialPort) portId.open("com4", TIME_OUT);
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
			return false;
		}
		return true;
	}


	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	public synchronized void write(int var) {
		try {
			output.write(var);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
	}
}