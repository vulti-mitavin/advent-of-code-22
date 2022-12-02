package ch.grassl.common;

import java.util.List;

public interface Importer<T> {

    List<T> importData(String resource);
}
