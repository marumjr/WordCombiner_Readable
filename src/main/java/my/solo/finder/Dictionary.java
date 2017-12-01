package my.solo.finder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class that represents a dictionary, a list of possible words
 * 
 * @author marumjr
 */
public class Dictionary {

	private static final String ENCODING_ISO_8859_1 = "ISO-8859-1";

	private static final String DICTIONARY_LIST = "wordlist.txt";

	private Set<String> words;

	/**
	 * Default constructor
	 * <p>
	 * It loads the content of a wordlist as a collection of words to be readily accessed
	 */
	public Dictionary() {
		super();
		this.loadWordListFromFile();
	}

	/**
	 * Check if a word belongs to this dictionary
	 * 
	 * @param word
	 *            Word to be checked
	 * @return <code>true</code> if this dictionary contains the word, <code>false</code> otherwise
	 */
	public boolean contains(String word) {
		return this.words.contains(word);
	}

	/**
	 * @return the words contained in this dictionary
	 */
	public Set<String> getWords() {
		return this.words;
	}

	/**
	 * Load the content of the wordlist.txt file as words into this dictionary
	 */
	private void loadWordListFromFile() {
		this.words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

		try {
			// Load the wordlist file...
			File file = this.retrieveResourceFile(DICTIONARY_LIST);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), ENCODING_ISO_8859_1));

			// ... and store each read line in this dictionary's collection of words
			String str;
			while ((str = in.readLine()) != null) {
				this.words.add(str);
			}
			in.close();

			System.out.println("DICTIONARY COUNT: " + this.words.size());

		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieve the resource file
	 * 
	 * @param filename
	 *            Name of the resource file to retrieve
	 * @return The resource file
	 * @throws URISyntaxException
	 */
	private File retrieveResourceFile(String filename) throws URISyntaxException {
		String pkgName = this.getClass().getPackage().getName().replace(".", "/") + "/";
		URI uri = this.getClass().getClassLoader().getResource(pkgName + filename).toURI();
		File file = new File(uri);

		return file;
	}

}
