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

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

public class SerialTest implements SerialPortEventListener {
	SerialPort serialPort;
	/** The port we're normally going to use. */
	private static final String PORT_NAMES[] = { "COM4" // Windows
	};
	/** Buffered input stream from the port */
	private InputStream input;
	/** The output stream to the port */
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 100;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600; // 9600

	@SuppressWarnings("rawtypes")
	public void initialize() {
		CommPortIdentifier portId = null;
		Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
		// iterate through, looking for the port
		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum
					.nextElement();
			System.out.println("currPortId.getName():" + currPortId.getName());
			for (String portName : PORT_NAMES) {
				System.out.println(portName);
				if (currPortId.getName().equals("COM4")) {
					portId = currPortId;
					break;
				}
			}
		}
		if (portId == null) {
			System.out.println("Could not find COM4 port.");
			return;
		}

		try { // open serial port, and use class name for the appName.
			serialPort = (SerialPort) portId.open("com4", TIME_OUT);
			// System.out.println(portId.getClass().getName());
			serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			// System.out.println("Parameter set");
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			System.out.println("Streams set");
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
			System.out.println("INPUT OUTPUT");
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * This should be called when you stop using the port. This will prevent
	 * port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	/**
	 * Handle an event on the serial port. Read the data and print it.
	 */
	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				int available = input.available();
				byte chunk[] = new byte[available];
				input.read(chunk, 0, available);

				// Displayed results are codepage dependent

				for (int c = 0; c < chunk.length; c++) {

					System.out.println("recieve:" + (chunk[c] + 512) % 256);
				}

			} catch (Exception e) {
				System.out.println("here atleastttttttt");
				System.err.println(e.toString());
			}
		}
	}

	public static void main(String[] args) throws Exception {

		final SerialTest com4Port = new SerialTest();
		com4Port.initialize();

		int b = 0;
		byte[] bytes = { 0, 30, 60, 90, 120, 0, 30, 60, 90, 120, 0, 30, 60, 90,
				120, 0, 30, 60, 90, 120 };

		try {
			Thread.sleep(2000L);
			// b += 30;
			// b = b % 180;

			com4Port.output.write(bytes);
			b++;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}