package ch.grassl.day.day01.impl.importer;

import ch.grassl.common.Importer;
import ch.grassl.day.day01.impl.model.Elf;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static ch.grassl.util.Util.isEmpty;

public class ElfImporter implements Importer<List<Elf>> {

    public static ElfImporter getInstance() {
        return new ElfImporter();
    }


    @NotNull
    @Override
    public List<Elf> importData(@NotNull String resource) {
        String[] data = Importer.read(resource);
        return mapToElves(data);
    }

    private static List<Elf> mapToElves(String[] data) {
        List<Elf> elves = new ArrayList<>();
        int i = 0;
        while (i < data.length) {
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
            i++;
        }
        return elves;
    }
}
