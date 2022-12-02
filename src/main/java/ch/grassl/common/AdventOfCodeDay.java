package ch.grassl.common;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AdventOfCodeDay {

    protected final List<Object> result = new ArrayList<>();

    public abstract void run();

    public void printResult() {
        for (Object r : result) {
            log.info("{}: The {}. result is: {}", this.getClass().getSimpleName(), result.indexOf(r) + 1, r);
        }
        log.info("-------------------------");
    }
}
