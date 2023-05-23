package work.schwarzmaier;

import java.io.IOException;
import java.util.List;

public class App {

    public static void main(String[] args) {

        TwentyOne twentyOne;

        try {
            if (args.length != 0 && args[0] != null) {
                FileReader fileReader = new FileReader();
                List<Suits> deck = fileReader.read(args[0]);
                twentyOne = new TwentyOne(deck);
            } else {
                twentyOne = new TwentyOne();
            }

            twentyOne.run();
        } catch (IOException e) {
            System.out.println("There is problem for reading the file");
        }
    }

}
