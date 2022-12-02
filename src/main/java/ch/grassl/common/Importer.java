package ch.grassl.common;

import ch.grassl.util.ResourceReader;

import java.util.List;

public interface Importer<T> {

    List<T> importData(String resource);

    static String[] read(String resource) {
        return ResourceReader.of(resource).read();
    }
}
