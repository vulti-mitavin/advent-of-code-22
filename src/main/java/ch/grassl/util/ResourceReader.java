package ch.grassl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class ResourceReader {

    private final InputStream in;

    private ResourceReader(String resource) {
        in = ResourceReader.class.getResourceAsStream(resource);
    }

    public static ResourceReader of(String resource) {
        return new ResourceReader(resource);
    }

    public String[] read() {
        if (in != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                return br.lines().toArray(String[]::new);
            } catch (IOException e) {
                return new String[0];
            }
        } else {
            return new String[0];
        }
    }
}
