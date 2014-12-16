package usta.onur.ceng599.converter;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.Note;

import usta.onur.ceng599.model.GuitarPosition;


public class MusicalConverter {

	public static List<GuitarPosition> convertNoteToListOfPossiblePositions(
			Note note) {
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
}
