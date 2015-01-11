package usta.onur.ceng599.view;

import java.awt.HeadlessException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class GPRSimulator extends JFrame {
	HashMap<String, Integer> hashMap;
	ArrayList<String> pressedNotes;
	NoteToggleButton[][] buttons = new NoteToggleButton[6][6];
	private NoteToggleButton btn0;
	private NoteToggleButton btn1;
	private NoteToggleButton btn2;
	private NoteToggleButton btn3;
	private NoteToggleButton btn4;
	private NoteToggleButton btn5;
	private NoteToggleButton btn6;
	private NoteToggleButton btn12;
	private NoteToggleButton btn18;
	private NoteToggleButton btn24;
	private NoteToggleButton btn30;
	private NoteToggleButton btn7;
	private NoteToggleButton btn13;
	private NoteToggleButton btn19;
	private NoteToggleButton btn25;
	private NoteToggleButton btn31;
	private NoteToggleButton btn8;
	private NoteToggleButton btn14;
	private NoteToggleButton btn9;
	private NoteToggleButton btn15;
	private NoteToggleButton btn10;
	private NoteToggleButton btn16;
	private NoteToggleButton btn11;
	private NoteToggleButton btn17;
	private NoteToggleButton btn20;
	private NoteToggleButton btn21;
	private NoteToggleButton btn22;
	private NoteToggleButton btn23;
	private NoteToggleButton btn26;
	private NoteToggleButton btn27;
	private NoteToggleButton btn28;
	private NoteToggleButton btn29;
	private NoteToggleButton btn32;
	private NoteToggleButton btn33;
	private NoteToggleButton btn34;
	private NoteToggleButton btn35;

	public GPRSimulator(String arg0) throws HeadlessException {
		super(arg0);
		initialize();
	}

	private void initialize() {
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				hashMap.clear();
			}
		});
		hashMap = new HashMap<String, Integer>();
		pressedNotes = new ArrayList<String>();
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("50px"), }, new RowSpec[] {
						FormFactory.UNRELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"),
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("50px"), }));
		this.btn0 = new NoteToggleButton("N");
		this.btn0.setFocusable(false);
		getContentPane().add(this.btn0, "2, 2, fill, fill");
		this.btn1 = new NoteToggleButton("M");
		this.btn1.setFocusable(false);
		getContentPane().add(this.btn1, "4, 2, fill, fill");
		this.btn2 = new NoteToggleButton("Ö");
		this.btn2.setFocusable(false);
		getContentPane().add(this.btn2, "6, 2, fill, fill");
		this.btn3 = new NoteToggleButton("Ç");
		this.btn3.setFocusable(false);
		getContentPane().add(this.btn3, "8, 2, fill, fill");
		this.btn4 = new NoteToggleButton("Þ");
		this.btn4.setFocusable(false);
		getContentPane().add(this.btn4, "10, 2, fill, fill");
		this.btn5 = new NoteToggleButton("Ý");
		this.btn5.setFocusable(false);
		getContentPane().add(this.btn5, "12, 2, fill, fill");
		this.btn6 = new NoteToggleButton("Z");
		this.btn6.setFocusable(false);
		getContentPane().add(this.btn6, "2, 4, fill, fill");
		this.btn7 = new NoteToggleButton("X");
		this.btn7.setFocusable(false);
		getContentPane().add(this.btn7, "4, 4, fill, fill");
		this.btn8 = new NoteToggleButton("C");
		this.btn8.setFocusable(false);
		getContentPane().add(this.btn8, "6, 4, fill, fill");
		this.btn9 = new NoteToggleButton("V");
		this.btn9.setFocusable(false);
		getContentPane().add(this.btn9, "8, 4, fill, fill");
		this.btn10 = new NoteToggleButton("B");
		this.btn10.setFocusable(false);
		getContentPane().add(this.btn10, "10, 4, fill, fill");
		this.btn11 = new NoteToggleButton("N");
		this.btn11.setFocusable(false);
		getContentPane().add(this.btn11, "12, 4, fill, fill");
		this.btn12 = new NoteToggleButton("H");
		this.btn12.setFocusable(false);
		getContentPane().add(this.btn12, "2, 6, fill, fill");
		this.btn13 = new NoteToggleButton("J");
		this.btn13.setFocusable(false);
		getContentPane().add(this.btn13, "4, 6, fill, fill");
		this.btn14 = new NoteToggleButton("K");
		this.btn14.setFocusable(false);
		getContentPane().add(this.btn14, "6, 6, fill, fill");
		this.btn15 = new NoteToggleButton("L");
		this.btn15.setFocusable(false);
		getContentPane().add(this.btn15, "8, 6, fill, fill");
		this.btn16 = new NoteToggleButton("Z");
		this.btn16.setFocusable(false);
		getContentPane().add(this.btn16, "10, 6, fill, fill");
		this.btn17 = new NoteToggleButton("X");
		this.btn17.setFocusable(false);
		getContentPane().add(this.btn17, "12, 6, fill, fill");
		this.btn18 = new NoteToggleButton("A");
		this.btn18.setFocusable(false);
		getContentPane().add(this.btn18, "2, 8, fill, fill");
		this.btn19 = new NoteToggleButton("S");
		this.btn19.setFocusable(false);
		getContentPane().add(this.btn19, "4, 8, fill, fill");
		this.btn20 = new NoteToggleButton("D");
		this.btn20.setFocusable(false);
		getContentPane().add(this.btn20, "6, 8, fill, fill");
		this.btn21 = new NoteToggleButton("F");
		this.btn21.setFocusable(false);
		getContentPane().add(this.btn21, "8, 8, fill, fill");
		this.btn22 = new NoteToggleButton("G");
		this.btn22.setFocusable(false);
		getContentPane().add(this.btn22, "10, 8, fill, fill");
		this.btn23 = new NoteToggleButton("H");
		this.btn23.setFocusable(false);
		getContentPane().add(this.btn23, "12, 8, fill, fill");
		this.btn24 = new NoteToggleButton("Y");
		this.btn24.setFocusable(false);
		getContentPane().add(this.btn24, "2, 10, fill, fill");
		this.btn25 = new NoteToggleButton("U");
		this.btn25.setFocusable(false);
		getContentPane().add(this.btn25, "4, 10, fill, fill");
		this.btn26 = new NoteToggleButton("I");
		this.btn26.setFocusable(false);
		getContentPane().add(this.btn26, "6, 10, fill, fill");
		this.btn27 = new NoteToggleButton("O");
		this.btn27.setFocusable(false);
		getContentPane().add(this.btn27, "8, 10, fill, fill");
		this.btn28 = new NoteToggleButton("P");
		this.btn28.setFocusable(false);
		getContentPane().add(this.btn28, "10, 10, fill, fill");
		this.btn29 = new NoteToggleButton("A");
		this.btn29.setFocusable(false);
		getContentPane().add(this.btn29, "12, 10, fill, fill");
		this.btn30 = new NoteToggleButton("Q");
		this.btn30.setFocusable(false);
		getContentPane().add(this.btn30, "2, 12, fill, fill");
		this.btn31 = new NoteToggleButton("W");
		this.btn31.setFocusable(false);
		getContentPane().add(this.btn31, "4, 12, fill, fill");
		this.btn32 = new NoteToggleButton("E");
		this.btn32.setFocusable(false);
		getContentPane().add(this.btn32, "6, 12, fill, fill");
		this.btn33 = new NoteToggleButton("R");
		this.btn33.setFocusable(false);
		getContentPane().add(this.btn33, "8, 12, fill, fill");
		this.btn34 = new NoteToggleButton("T");
		this.btn34.setFocusable(false);
		getContentPane().add(this.btn34, "10, 12, fill, fill");
		this.btn35 = new NoteToggleButton("Y");
		this.btn35.setFocusable(false);
		getContentPane().add(this.btn35, "12, 12, fill, fill");
		buttons[0][0] = this.btn0;
		buttons[0][1] = this.btn1;
		buttons[0][2] = this.btn2;
		buttons[0][3] = this.btn3;
		buttons[0][4] = this.btn4;
		buttons[0][5] = this.btn5;
		buttons[1][0] = this.btn6;
		buttons[1][1] = this.btn7;
		buttons[1][2] = this.btn8;
		buttons[1][3] = this.btn9;
		buttons[1][4] = this.btn10;
		buttons[1][5] = this.btn11;
		buttons[2][0] = this.btn12;
		buttons[2][1] = this.btn13;
		buttons[2][2] = this.btn14;
		buttons[2][3] = this.btn15;
		buttons[2][4] = this.btn16;
		buttons[2][5] = this.btn17;
		buttons[3][0] = this.btn18;
		buttons[3][1] = this.btn19;
		buttons[3][2] = this.btn20;
		buttons[3][3] = this.btn21;
		buttons[3][4] = this.btn22;
		buttons[3][5] = this.btn23;
		buttons[4][0] = this.btn24;
		buttons[4][1] = this.btn25;
		buttons[4][2] = this.btn26;
		buttons[4][3] = this.btn27;
		buttons[4][4] = this.btn28;
		buttons[4][5] = this.btn29;
		buttons[5][0] = this.btn30;
		buttons[5][1] = this.btn31;
		buttons[5][2] = this.btn32;
		buttons[5][3] = this.btn33;
		buttons[5][4] = this.btn34;
		buttons[5][5] = this.btn35;
		initiateEventHandlersForButtons();
	}

	private void initiateEventHandlersForButtons() {
		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 6; k++) {
				buttons[i][k].addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						((NoteToggleButton) e.getSource()).setSelected(true);
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						((NoteToggleButton) e.getSource()).setSelected(false);
					}
				});
			}
		}
	}

	public void keyPressed(char pressed) {
		if (hashMap.get(pressed + "") == null) {
			hashMap.put(pressed + "", (int) pressed);
			updateNotes();
		}
	}

	public void reliese(char pressed) {
		hashMap.remove(pressed + "");
		updateNotes();
	}

	private void updateNotes() {
		pressedNotes.clear();
		for (int i = 0; i < 6; i++) {
			boolean isThereNoteOnThatRow = false;
			for (int k = 5; k >= 0; k--) {
				if (hashMap.containsKey(buttons[i][k].getNoteCode()
						.toLowerCase())
						&& !isThereNoteOnThatRow
						&& !pressedNotes.contains(buttons[i][k].getNoteCode()
								.toLowerCase())) {
					isThereNoteOnThatRow = true;
					buttons[i][k].setSelected(true);
					pressedNotes.add(buttons[i][k].getNoteCode().toLowerCase());

				} else {
					buttons[i][k].setSelected(false);
				}
			}
		}
		// distributePressedNotes();
	}
}
