package ch.grassl.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public abstract class AdventOfCodeDay {

    @Getter
    protected final LinkedList<Object> result = new LinkedList<>();

    public abstract void run();

    public void printResult() {
        String day = this.getClass().getSimpleName();
        log.info("----------- {} ------------", day);
        for (Object r : result) {
            log.info("{}: The {}. result is: {}", day, result.indexOf(r) + 1, r);
        }
    }
}
