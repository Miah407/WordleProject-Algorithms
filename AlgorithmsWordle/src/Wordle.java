import java.util.Scanner;

//public class Wordle extends ChosenWord {
public class Wordle extends ChosenWord {

    /**
     * Takes the random word from chosenWord and calls it randomWord.
     */

    static String randomWord = chosenWord("words.txt");


    public static void main(String[] args) {
        /**
         * This tallies the number of guess made, if the input is valid,
         * and if the guesser got the word correct.
         */
        int guesses = 0;
        boolean correct = false;

        while ((guesses < 6) && (correct == false)){
            System.out.println("Input your guess: ");
            Scanner guessScanner = new Scanner(System.in);
            String guess = guessScanner.next().toLowerCase();
            /**
             * If the guess is correct, the program finishes.
             */
            if (guess.equals(randomWord)) {
                System.out.println("Correct!");
                correct = true;
                guessScanner.close();
            } else if (guess.length() != 5) {
                System.out.printf("The word length must be 5!\n");
            /**
             * This goes to WordCheck, which determines if the letters are in
             * the correct spot, within the word, or not in the world at all.
             */
            } else {
                WordCheck(guess);
                guesses += 1;
            }
            
        }
        /**
         * If the user runs out of guesses, an apology is
         * printed and the answer is revealed.
         */
        if (guesses == 6) {
            System.out.printf("Sorry, you ran out of guesses.");
            System.out.printf("The correct word was " + randomWord);
        }
    }

    static void WordCheck(String word) {
        /**
         * This declares the colors that the letters will use
         */
        String GREEN = "\u001B[32m";
        String WHITE = "\u001B[37m";
        String YELLOW = "\u001B[33m";
        for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (IsCharInside(c)) {
            /**
             * If the user gets a correct letter in the correct spot,
             * the letter turns green. If they get a correct letter in
             * the wrong spot, the letter turns yellow. If the letter
             * isn't in the word, the letter stays white.
             */
            if (randomWord.charAt(i) == c) {
              System.out.printf(GREEN + word.charAt(i) + WHITE);
            } else {
              System.out.printf(YELLOW + word.charAt(i) + WHITE);
            }
          } else {
            System.out.printf(WHITE + word.charAt(i));
          }
        }
        System.out.println();
      }

    static boolean IsCharInside(char attempt) {
          /**
           * Tests to see if the letters are part of the word
           */
            for (int j = 0; j < randomWord.length(); j++) {
                if (randomWord.charAt(j) == attempt) {
                    return true;
                }
            }
        return false;
    }
}

/* Things to add:
 * Figure out logic for yellows, if the letter appears multiple times
 * then multiple of the same letter can be yellow/green.
 * Could also check that the guess is within the words.txt file, rather
 * than only limiting the user to five words.
 */