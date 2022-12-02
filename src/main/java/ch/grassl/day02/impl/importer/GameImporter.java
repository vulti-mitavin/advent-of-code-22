package ch.grassl.day02.impl.importer;

import ch.grassl.common.Importer;
import ch.grassl.day02.impl.model.Move;
import ch.grassl.util.Util;

import java.util.ArrayList;
import java.util.List;

public abstract class GameImporter implements Importer<Move> {

    @Override
    public List<Move> importData(String resource) {
        String[] data = Importer.read(resource);
        return mapToMoves(data);
    }

    protected List<Move> mapToMoves(String[] data) {
        List<Move> moves = new ArrayList<>();
        for (String datum : data) {
            if (!Util.isEmpty(datum)) {
                moves.add(
                        mapToMove(datum)
                );
            }
        }
        return moves;
    }

    protected abstract Move mapToMove(String datum);
}
