package ch.grassl.day.day08;

import ch.grassl.day.day08.impl.Grid;
import ch.grassl.day.day08.impl.GridImporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridImporterTest {

    public static final String RESOURCE = "/day08/day08_test.txt";

    private final GridImporter importer = new GridImporter();

    @Test
    void importData() {
        Grid grid = importer.importData(RESOURCE);
        assertEquals(3, grid.getTrees()[0][0].getSize());
        assertEquals(2, grid.getTrees()[1][0].getSize());
        assertEquals(6, grid.getTrees()[2][0].getSize());
        assertEquals(3, grid.getTrees()[3][0].getSize());
        assertEquals(3, grid.getTrees()[4][0].getSize());

        assertEquals(3, grid.getTrees()[0][4].getSize());
        assertEquals(2, grid.getTrees()[1][4].getSize());
        assertEquals(2, grid.getTrees()[2][4].getSize());
        assertEquals(9, grid.getTrees()[3][4].getSize());
        assertEquals(0, grid.getTrees()[4][4].getSize());
    }
}