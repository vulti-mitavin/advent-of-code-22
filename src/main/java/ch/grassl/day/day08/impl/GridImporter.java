package ch.grassl.day.day08.impl;

import ch.grassl.common.Importer;
import org.jetbrains.annotations.NotNull;

public class GridImporter implements Importer<Grid> {

    public static GridImporter of() {
        return new GridImporter();
    }

    @Override
    public Grid importData(@NotNull String resource) {
        String[] lines = Importer.read(resource);
        return mapToGrid(lines);
    }

    private Grid mapToGrid(String[] lines) {
        Tree[][] trees = new Tree[lines[0].length()][lines.length];
        for (int i = 0; i < trees.length; i++) {
            String line = lines[i];
            for (int j = 0; j < trees[i].length; j++) {
                trees[i][j] = new Tree(Integer.parseInt(String.valueOf(line.charAt(j))));
            }
        }
        return new Grid(trees);
    }
}
