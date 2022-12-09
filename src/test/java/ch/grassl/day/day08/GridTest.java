package ch.grassl.day.day08;

import ch.grassl.day.day08.impl.Grid;
import ch.grassl.day.day08.impl.GridImporter;
import ch.grassl.day.day08.impl.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private final GridImporter importer = new GridImporter();

    @Test
    void testGrid_TreeNeighbours_1() {
        Grid grid = importer.importData(GridImporterTest.RESOURCE);
        Tree tree = grid.getTrees()[0][3];
        assertEquals(1, tree.getSouth().getSize());
        assertEquals(3, tree.getEast().getSize());
        assertEquals(3, tree.getWest().getSize());
        assertTrue(tree.isVisible());
    }

    @Test
    void testGrid_TreeNeighbours_2() {
        Grid grid = importer.importData(GridImporterTest.RESOURCE);
        Tree tree = grid.getTrees()[2][2];
        assertEquals(5, tree.getSouth().getSize());
        assertEquals(3, tree.getEast().getSize());
        assertEquals(5, tree.getWest().getSize());
        assertEquals(5, tree.getNorth().getSize());
        assertFalse(tree.isVisible());
    }

    @Test
    void testGrid_TreeNeighbours_3() {
        Grid grid = importer.importData(GridImporterTest.RESOURCE);
        Tree tree = grid.getTrees()[4][4];
        assertEquals(9, tree.getNorth().getSize());
        assertEquals(9, tree.getWest().getSize());
        assertTrue(tree.isVisible());
    }

    @Test
    void testGrid_NumberOfVisibleTrees() {
        Grid grid = importer.importData(GridImporterTest.RESOURCE);
        assertEquals(21, grid.numberOfVisibleTrees());
    }

    @Test
    void testGrid_ScenicScore() {
        Grid grid = importer.importData(GridImporterTest.RESOURCE);
        assertEquals(8, grid.findHighestScenicScore());
    }
}