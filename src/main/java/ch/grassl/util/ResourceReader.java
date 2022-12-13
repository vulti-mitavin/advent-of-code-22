package ch.grassl.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
public final class ResourceReader {

    private final InputStream in;
    private final String resource;

    private ResourceReader(String resource) {
        this.resource = resource;
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
                log.warn("Error reading resource '{}': {}", resource, e.getMessage());
                return new String[0];
            }
        } else {
            log.warn("Resource '{}' not found.", resource);
            return new String[0];
        }
    }
}
