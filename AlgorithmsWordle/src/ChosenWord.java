import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 * words.txt file is from charlesreid1 on github, titled five-letter-words
 */

/**
 *  chosenWord reads the file and randomly selects a word
 * This word is then returned if one is sucessfully retrieved
 * the word returns to become randomWord.
 */

class ChosenWord {
    static String chosenWord(String words) {
        try (BufferedReader reader = new BufferedReader(new FileReader(words))) {

            /**
             * Gets a random line from the words.txt file, bound
             * by the number of files inside it.
             */
            Random rand = new Random();
            int whichline = rand.nextInt(5758);

            String word = "";
            for (int i = 0; i < whichline; i++) {
                word = reader.readLine();
            }
            return word;
        } 
        catch (Exception e) {
            System.err.println("Error");
            return "";
        }
    }
}
