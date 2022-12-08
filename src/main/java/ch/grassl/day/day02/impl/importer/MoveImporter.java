package ch.grassl.day.day02.impl.importer;

import ch.grassl.day.day02.impl.model.Move;
import ch.grassl.day.day02.impl.model.Shape;

/**
 * Imports the input data based on the assumption: first column = opponent move, second column = my move.
 */
public class MoveImporter extends GameImporter {

    public static MoveImporter getInstance() {
        return new MoveImporter();
    }

    @Override
    protected Move mapToMove(String datum) {
        String[] split = datum.split(" ");
        return new Move(getShape(split[0]), getShape(split[1]));
    }

    private static Shape getShape(String s) {
        return switch (s) {
            case "A", "X" -> Shape.ROCK;
            case "B", "Y" -> Shape.PAPER;
            case "C", "Z" -> Shape.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
