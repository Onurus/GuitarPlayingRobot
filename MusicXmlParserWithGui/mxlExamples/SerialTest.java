/*serialPort.setSerialPortParams(DATA_RATE,
SerialPort.DATABITS_8,
SerialPort.STOPBITS_1,
SerialPort.PARITY_NONE);
so i commented this line. then the program was able to get the number of byte available for reception. but when it executes the line

input.read(chunk, 0, available);

it throws an exception.

here is the whole program that i modified*/



import java.io.InputStream;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class SerialTest implements SerialPortEventListener {
SerialPort serialPort;
/** The port we're normally going to use. */
private static final String PORT_NAMES[] = {
"COM3" // Windows
};
/** Buffered input stream from the port */
private InputStream input;
/** The output stream to the port */
private OutputStream output;
/** Milliseconds to block while waiting for port open */
private static final int TIME_OUT = 2000;
/** Default bits per second for COM port. */
private static final int DATA_RATE = 1200; //9600
public static int a1;
public static int a2;
public static MSP430_COM_PORT_LISTENER a3;

@SuppressWarnings("rawtypes")
public void initialize() {
	CommPortIdentifier portId = null;
	Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
	// iterate through, looking for the port
	while (portEnum.hasMoreElements()) {
		CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
		System.out.println(currPortId.getName());
		for (String portName : PORT_NAMES) {
			System.out.println(portName);
			if (currPortId.getName().equals("COM3")) {
				portId = currPortId;
				System.out.println("portId");
				System.out.println(portId.getName());
				break;
			}
		}
	}
	if (portId == null) {
		System.out.println("Could not find COM port.");
		return;
	}

	try { // open serial port, and use class name for the appName.
		serialPort = (SerialPort) portId.open("com4",TIME_OUT);
		System.out.println(portId.getClass().getName());
		serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
		serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
		System.out.println("Parameter set");
		input = serialPort.getInputStream();
		output = serialPort.getOutputStream();
		System.out.println("Streams set");

		serialPort.addEventListener(this);
		serialPort.notifyOnDataAvailable(true);
		System.out.println("INPUT OUTPUT");
	} catch (Exception e) {
		System.out.println("HEREEEEEEEEEEEEEEEE");
		System.err.println(e.toString());
	}
}

/**
* This should be called when you stop using the port.
* This will prevent port locking on platforms like Linux.
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
public synchronized void serialEvent(SerialPortEvent oEvent) {
	if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
		try {
			//System.out.println("FINALLLLLLLLLLLLLLLLLLLLL");
			int available = input.available();
			//System.out.println(available);
			byte chunk[] = new byte[available];
			//System.out.println("Starting");
			input.read(chunk, 0, available);
			
			//System.out.println("data received");

			// Displayed results are codepage dependent
			
			
		
			for(int c=0;c<chunk.length;c++){
				//System.out.print(chunk[c]+" ");
				//System.out.println(  ((int)chunk[c] + 512) % 256);
				a1=((int)chunk[c] + 512) % 256;
				if(a2==0){
					a2=a1;
				}else{
					a3.editList(a2, a1);
					a1=0;
					a2=0;
				}
			}
			
		} catch (Exception e) {
			System.out.println("here atleastttttttt");
			System.err.println(e.toString());
		}
	}// Ignore all the other eventTypes, but you should consider the other ones.
}

public static void main(String[] args) throws Exception {
	a3 = new MSP430_COM_PORT_LISTENER();
	a3.setVisible(true);
	SerialTest main = new SerialTest();
	main.initialize();
}
}