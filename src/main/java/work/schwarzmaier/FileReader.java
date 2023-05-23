package work.schwarzmaier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public List<Suits> read(String path) throws IOException {

        String s = Files.readString(Paths.get(path));
        String[] raw_deck = s.split(",");
        List<Suits> deck = new ArrayList<>();
        for (String ele : raw_deck) {
            deck.add(Suits.valueOf(ele.trim()));
        }
        return deck;

    }

}
