package my.solo.finder;

import java.util.Set;
import java.util.TreeSet;

/**
 * Class responsible for combining words into other existing words
 * 
 * @author marumjr
 */
public class WordCombiner {

	private Dictionary dictionary;

	/**
	 * Default constructor
	 * 
	 * @param dictionary
	 *            Dictionary to be accessed while combining words
	 */
	public WordCombiner(Dictionary dictionary) {
		super();
		this.dictionary = dictionary;
	}

	/**
	 * Make combination of words in the dictionary trying to create existing words which contain exactly a certain
	 * number of characters.
	 * 
	 * @param fixLength
	 *            Fix number of characters that the resulting existing word must have to be considered as part of the
	 *            solution
	 * @return a collection of found words
	 */
	public Set<String> combineIntoNLetterWords(int fixLength) {
		Set<String> allDictionaryWords = this.dictionary.getWords();

		Set<String> results = new TreeSet<String>();

		// Loop through the dictionary...
		for (String wordA : allDictionaryWords) {
			// ... twice...
			for (String wordB : allDictionaryWords) {
				// ... in order to combine the words there
				String combinedWord = wordA + wordB;

				// If it has exactly the certain number of characters and exists in the dictionary...
				if (combinedWord.length() == fixLength && this.dictionary.contains(combinedWord)) {
					// ... then it is part of the solution, and add it to the results found
					String result = wordA + " + " + wordB + " = " + combinedWord;
					results.add(result);
				}
			}
		}

		return results;
	}

}
