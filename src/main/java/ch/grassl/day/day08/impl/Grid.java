package ch.grassl.day.day08.impl;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Grid {

    private final Tree[][] trees;

    public Grid(Tree[][] trees) {
        this.trees = trees;
        prepareTrees();
    }

    public int findHighestScenicScore() {
        int maxScenicScore = 0;
        for (int i = 0; i < trees.length; i++) {
            for (int j = 0; j < trees[i].length; j++) {
                Tree tree = trees[i][j];
                int scenicScore = getScoreNorth(i, j, tree) * getScoreEast(i, j, tree) * getScoreSouth(i, j, tree) * getScoreWest(i, j, tree);
                if (scenicScore > maxScenicScore) {
                    maxScenicScore = scenicScore;
                }
            }
        }
        return maxScenicScore;
    }

    private int getScoreWest(int i, int j, Tree tree) {
        int scoreWest = 0;
        for (int k = j - 1; k >= 0; k--) {
            Tree west = trees[i][k];
            if (west.getSize() < tree.getSize()) {
                scoreWest++;
            } else {
                scoreWest++;
                break;
            }
        }
        return scoreWest;
    }

    private int getScoreSouth(int i, int j, Tree tree) {
        int scoreSouth = 0;
        for (int k = i + 1; k < trees.length; k++) {
            Tree south = trees[k][j];
            if (south.getSize() < tree.getSize()) {
                scoreSouth++;
            } else {
                scoreSouth++;
                break;
            }
        }
        return scoreSouth;
    }

    private int getScoreEast(int i, int j, Tree tree) {
        int scoreEast = 0;
        for (int k = j + 1; k < trees[i].length; k++) {
            Tree east = trees[i][k];
            if (east.getSize() < tree.getSize()) {
                scoreEast++;
            } else {
                scoreEast++;
                break;
            }
        }
        return scoreEast;
    }

    private int getScoreNorth(int i, int j, Tree tree) {
        int scoreNorth = 0;
        for (int k = i - 1; k >= 0; k--) {
            Tree north = trees[k][j];
            if (north.getSize() < tree.getSize()) {
                scoreNorth++;
            } else {
                scoreNorth++;
                break;
            }
        }
        return scoreNorth;
    }

    public int numberOfVisibleTrees() {
        return Arrays.stream(trees)
                .mapToInt(column -> (int) Arrays.stream(column).filter(Tree::isVisible).count())
                .sum();
    }

    private void prepareTrees() {
        for (int i = 0; i < trees.length; i++) {
            for (int j = 0; j < trees[i].length; j++) {
                trees[i][j].populate(trees, i, j);
            }
        }
    }
}
