package ch.grassl.day.day08.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Tree {

    private final int size;

    private Tree north;
    private Tree east;
    private Tree south;
    private Tree west;

    public void populate(Tree[][] trees, int i, int j) {
        this.north = getNorth(trees, i, j);
        this.east = getEast(trees, i, j);
        this.south = getSouth(trees, i, j);
        this.west = getWest(trees, i, j);
    }

    private Tree getNorth(Tree[][] trees, int i, int j) {
        try {
            return trees[i - 1][j];
        } catch (IndexOutOfBoundsException ignore) {
            // first row
            return null;
        }
    }

    private Tree getEast(Tree[][] trees, int i, int j) {
        try {
            return trees[i][j + 1];
        } catch (IndexOutOfBoundsException ignore) {
            // last column
            return null;
        }
    }

    private Tree getSouth(Tree[][] trees, int i, int j) {
        try {
            return trees[i + 1][j];
        } catch (IndexOutOfBoundsException ignore) {
            // last row
            return null;
        }
    }

    private Tree getWest(Tree[][] trees, int i, int j) {
        try {
            return trees[i][j - 1];
        } catch (IndexOutOfBoundsException ignore) {
            // first column
            return null;
        }
    }

    public boolean isVisible() {
        return isBorderTree()
                || isHighestNorth(new Tree(0)).equals(this)
                || isHighestEast(new Tree(0)).equals(this)
                || isHighestSouth(new Tree(0)).equals(this)
                || isHighestWest(new Tree(0)).equals(this);
    }

    private boolean isBorderTree() {
        return north == null || east == null || south == null || west == null;
    }

    private Tree isHighestNorth(Tree max) {
        if (north != null) {
            max = north.isHighestNorth(max);
        }
        if (size > max.size) {
            return this;
        } else {
            return max;
        }
    }

    private Tree isHighestEast(Tree max) {
        if (east != null) {
            max = east.isHighestEast(max);
        }
        if (size > max.size) {
            return this;
        } else {
            return max;
        }
    }

    private Tree isHighestSouth(Tree max) {
        if (south != null) {
            max = south.isHighestSouth(max);
        }
        if (size > max.size) {
            return this;
        } else {
            return max;
        }
    }

    private Tree isHighestWest(Tree max) {
        if (west != null) {
            max = west.isHighestWest(max);
        }
        if (size > max.size) {
            return this;
        } else {
            return max;
        }
    }
}
