package assignment.weight_watchers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ProblemOne {

	LinkedHashMap<String, String[]> wordMap = new LinkedHashMap<String, String[]>();

	private void doesFileExist(String path) {

		wordMap.clear();
		File file = null;
		BufferedReader reader = null;
		try {
			file = new File(path);
			reader = new BufferedReader(new FileReader(file));
			String line;
			while (reader.ready()) {
				line = reader.readLine();
				// System.out.println(line);
				String word = line.substring(0, line.indexOf("–"));
				// System.out.println(word);
				String[] meaning = line.substring(line.indexOf("–") + 1).split(",");
				wordMap.put(word, meaning);

			}
		} catch (IOException e) {
			System.out.println("Exception Found: " + e.getMessage());
			// e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Exception Found: " + e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				file = null;
				reader.close();
			} catch (IOException e2) {
				System.out.println("Exception Found: " + e2.getMessage());
			}

		}

	}

	private void printLine() {
		for (String key : wordMap.keySet()) {
			System.out.println(key.trim());
			String meanings[] = wordMap.get(key);
			for (int i = 0; i < meanings.length; i++) {
				System.out.println(meanings[i].trim());
			}
		}
	}

	public static void main(String[] args) {

		ProblemOne printWordsWithMeaning = new ProblemOne();
		printWordsWithMeaning.doesFileExist("resources/words.txt");
		printWordsWithMeaning.printLine();

	}
}
