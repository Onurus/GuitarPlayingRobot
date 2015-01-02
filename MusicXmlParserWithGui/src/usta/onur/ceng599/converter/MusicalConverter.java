package usta.onur.ceng599.converter;

import java.util.ArrayList;
import java.util.List;

import usta.onur.ceng599.model.GPRCommand;
import usta.onur.ceng599.model.GPRNote;
import usta.onur.ceng599.model.GuitarPosition;

public class MusicalConverter {

	public static List<GuitarPosition> convertNoteToListOfPossiblePositions(
			GPRNote note) {
		List<GuitarPosition> resultSet = new ArrayList<GuitarPosition>();
		int noteValue = note.getValue();
		switch (noteValue) {
		case 28:
			resultSet.add(new GuitarPosition(6, 0));
			break;
		case 29:
			resultSet.add(new GuitarPosition(6, 1));
			break;
		case 30:
			resultSet.add(new GuitarPosition(6, 2));
			break;
		case 31:
			resultSet.add(new GuitarPosition(6, 3));
			break;
		case 32:
			resultSet.add(new GuitarPosition(6, 4));
			break;
		case 33:
			resultSet.add(new GuitarPosition(5, 0));
			resultSet.add(new GuitarPosition(6, 5));
			break;
		case 34:
			resultSet.add(new GuitarPosition(5, 1));
			break;
		case 35:
			resultSet.add(new GuitarPosition(5, 2));
			break;
		case 36:
			resultSet.add(new GuitarPosition(5, 3));
			break;
		case 37:
			resultSet.add(new GuitarPosition(5, 4));
			break;
		case 38:
			resultSet.add(new GuitarPosition(4, 0));
			resultSet.add(new GuitarPosition(5, 5));
			break;
		case 39:
			resultSet.add(new GuitarPosition(4, 1));
			break;
		case 40:
			resultSet.add(new GuitarPosition(4, 2));
			break;
		case 41:
			resultSet.add(new GuitarPosition(4, 3));
			break;
		case 42:
			resultSet.add(new GuitarPosition(4, 4));
			break;
		case 43:
			resultSet.add(new GuitarPosition(3, 0));
			resultSet.add(new GuitarPosition(4, 5));
			break;
		case 44:
			resultSet.add(new GuitarPosition(3, 1));
			break;
		case 45:
			resultSet.add(new GuitarPosition(3, 2));
			break;
		case 46:
			resultSet.add(new GuitarPosition(3, 3));
			break;
		case 47:
			resultSet.add(new GuitarPosition(3, 4));
			resultSet.add(new GuitarPosition(2, 0));
			break;
		case 48:
			resultSet.add(new GuitarPosition(3, 5));
			resultSet.add(new GuitarPosition(2, 1));
			break;
		case 49:
			resultSet.add(new GuitarPosition(2, 2));
			break;
		case 50:
			resultSet.add(new GuitarPosition(2, 3));
			break;
		case 51:
			resultSet.add(new GuitarPosition(2, 4));
			break;
		case 52:
			resultSet.add(new GuitarPosition(1, 0));
			resultSet.add(new GuitarPosition(2, 5));
			break;
		case 53:
			resultSet.add(new GuitarPosition(1, 1));
			break;
		case 54:
			resultSet.add(new GuitarPosition(1, 2));
			break;
		case 55:
			resultSet.add(new GuitarPosition(1, 3));
			break;
		case 56:
			resultSet.add(new GuitarPosition(1, 4));
			break;
		case 57:
			resultSet.add(new GuitarPosition(1, 5));
			break;
		default:
			break;
		}

		return resultSet;
	}

	public static GPRCommand convertGoPosition(GuitarPosition position) {
		switch (position.getTel()) {
		case 1:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO10;
			case 1:
				return GPRCommand.GO11;
			case 2:
				return GPRCommand.GO12;
			case 3:
				return GPRCommand.GO13;
			case 4:
				return GPRCommand.GO14;
			case 5:
				return GPRCommand.GO15;
			default:
				break;
			}
			break;
		case 2:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO20;
			case 1:
				return GPRCommand.GO21;
			case 2:
				return GPRCommand.GO22;
			case 3:
				return GPRCommand.GO23;
			case 4:
				return GPRCommand.GO24;
			case 5:
				return GPRCommand.GO25;
			default:
				break;
			}
			break;
		case 3:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO30;
			case 1:
				return GPRCommand.GO31;
			case 2:
				return GPRCommand.GO32;
			case 3:
				return GPRCommand.GO33;
			case 4:
				return GPRCommand.GO34;
			case 5:
				return GPRCommand.GO35;
			default:
				break;
			}
			break;
		case 4:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO40;
			case 1:
				return GPRCommand.GO41;
			case 2:
				return GPRCommand.GO42;
			case 3:
				return GPRCommand.GO43;
			case 4:
				return GPRCommand.GO44;
			case 5:
				return GPRCommand.GO45;
			default:
				break;
			}
			break;
		case 5:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO50;
			case 1:
				return GPRCommand.GO51;
			case 2:
				return GPRCommand.GO52;
			case 3:
				return GPRCommand.GO53;
			case 4:
				return GPRCommand.GO54;
			case 5:
				return GPRCommand.GO55;
			default:
				break;
			}
			break;
		case 6:
			switch (position.getTab()) {
			case 0:
				return GPRCommand.GO60;
			case 1:
				return GPRCommand.GO61;
			case 2:
				return GPRCommand.GO62;
			case 3:
				return GPRCommand.GO63;
			case 4:
				return GPRCommand.GO64;
			case 5:
				return GPRCommand.GO65;
			default:
				break;
			}
			break;

		default:
			break;
		}
		return null;

	}

	public static GPRCommand convertPushPosition(GuitarPosition position) {
		switch (position.getTel()) {
		case 1:
			return GPRCommand.PUSH1;
		case 2:
			return GPRCommand.PUSH2;
		case 3:
			return GPRCommand.PUSH3;
		case 4:
			return GPRCommand.PUSH4;
		case 5:
			return GPRCommand.PUSH5;
		case 6:
			return GPRCommand.PUSH6;

		default:
			break;
		}

		return null;

	}

	public static GPRCommand convertPullPosition(GuitarPosition position) {
		switch (position.getTel()) {
		case 1:

			return GPRCommand.PULL1;
		case 2:
			return GPRCommand.PULL2;
		case 3:
			return GPRCommand.PULL3;
		case 4:
			return GPRCommand.PULL4;
		case 5:
			return GPRCommand.PULL5;
		case 6:
			return GPRCommand.PULL6;

		default:
			break;
		}

		return null;

	}

	public static GPRCommand convertTouchPosition(GuitarPosition position) {
		switch (position.getTel()) {
		case 1:

			return GPRCommand.TOUCH1;
		case 2:
			return GPRCommand.TOUCH2;
		case 3:
			return GPRCommand.TOUCH3;
		case 4:
			return GPRCommand.TOUCH4;
		case 5:
			return GPRCommand.TOUCH5;
		case 6:
			return GPRCommand.TOUCH6;

		default:
			break;
		}

		return null;

	}
}
