package ch.grassl.day1.impl;

import ch.grassl.util.ResourceReader;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import static ch.grassl.util.Util.isEmpty;

@UtilityClass
public class ElfImporter {

    public static List<Elf> importElves(String resource) {
        String[] data = ResourceReader.of(resource).read();
        return mapToElves(data);
    }

    private static List<Elf> mapToElves(String[] data) {
        List<Elf> elves = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (!isEmpty(data[i])) {
                int calories = 0;
                for (int j = i; j < data.length; j++) {
                    if (!isEmpty(data[j])) {
                        calories += Integer.parseInt(data[j]);
                    } else {
                        i = j;
                        break;
                    }
                }
                elves.add(new Elf(calories));
            }
        }
        return elves;
    }
}
