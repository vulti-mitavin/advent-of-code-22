package ch.grassl.day02.impl.importer;


import ch.grassl.day02.impl.model.Move;
import ch.grassl.day02.impl.model.Result;
import ch.grassl.day02.impl.model.Shape;

/**
 * Imports the input data based on the assumption: first column = opponent move, second column = result.
 */
public class StrategyImporter extends GameImporter {

    public static StrategyImporter getInstance() {
        return new StrategyImporter();
    }

    @Override
    protected Move mapToMove(String datum) {
        String[] split = datum.split(" ");
        return new Move(getShape(split[0]), getResult(split[1]));
    }

    private static Shape getShape(String s) {
        return switch (s) {
            case "A" -> Shape.ROCK;
            case "B" -> Shape.PAPER;
            case "C" -> Shape.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }

    private static Result getResult(String s) {
        return switch (s) {
            case "X" -> Result.LOSS;
            case "Y" -> Result.DRAW;
            case "Z" -> Result.WIN;
            default -> throw new IllegalStateException("Unexpected value: " + s);
        };
    }
}
