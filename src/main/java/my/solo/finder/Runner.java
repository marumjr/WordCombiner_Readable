package my.solo.finder;

import java.util.Set;

/**
 * Class responsible for running the application
 * 
 * @author marumjr
 */
public class Runner {

	/**
	 * Main method.
	 * <p>
	 * It loads a word list into a dictionary and then starts combining words, trying to found the ones with an exactly
	 * certain number of characters and printing it when it also exists in the dictionary
	 * 
	 * @param args
	 *            Not used
	 */
	public static void main(String[] args) {
		int fixLength = 6;

		// Creates the dictionary of words
		Dictionary dictionary = new Dictionary();

		// Starts combining words...
		WordCombiner wordCombiner = new WordCombiner(dictionary);
		Set<String> results = wordCombiner.combineIntoNLetterWords(fixLength);

		// ... and prints the found results
		for (String result : results) {
			System.out.println(result);
		}
	}

}
