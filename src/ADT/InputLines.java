/**
 * Implemented by Apoorva, A0141138N
 */

package ADT;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputLines implements Input {
	
	List<String> inputLines;
	List<String> ignoreWords;
	
	//Constructor
	public InputLines(List<String> inputLines, List<String> ignoreWords) {
		this.inputLines = inputLines;
		this.ignoreWords = ignoreWords;
	}
	
	@Override
	public int readInput(List<String> inputLines, List<String> ignoreWords) throws IOException {
		int designChoice;
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to KWIC!");
		System.out.println("Enter lines: ");
		while (sc.hasNextLine()) {
			String newLine = sc.nextLine();
			if (newLine.isEmpty()) {
				break;
			}
			inputLines.add(newLine);

		}
		System.out.println("Enter words to ignore: ");
		while (sc.hasNextLine()) {
			String newLine = sc.nextLine();
			if (newLine.isEmpty()) {
				break;
			}
			ignoreWords.add(newLine.toLowerCase());
		}
		System.out.println("Choose architecutre design. Type 1 for Abstract Data Type and 2 for XXX: ");
		designChoice = sc.nextInt();
		return designChoice;
	}

}
