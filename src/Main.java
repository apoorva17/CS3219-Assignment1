/**
 * Implemented by Apoorva, A0141138N
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import implicit.AlphabeticShifter;
import implicit.CircularShifter;
import implicit.IgnoredWordsShifter;
import implicit.ObservableLines;

public class Main {

	public static void main(String[] args) {

		int designChoice = 0;
		List<String> inputLines = new ArrayList<String>();
		List<String> ignoreWords = new ArrayList<String>();

		ADT.Input inp = new ADT.InputLines(inputLines, ignoreWords);
		try {
			designChoice = inp.readInput(inputLines, ignoreWords);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (designChoice == 1) {
			ADT.Characters characters = new ADT.LineCharacters(inputLines, ignoreWords);
			ADT.CircularShift shifter = new ADT.CircularShifter(characters.getTitles(), characters.getIgnoreWords());
			ADT.AlphabeticShift alphabetizer = new ADT.AlphabeticShifter(shifter.getShiftedTitles());
			ADT.Output out = new ADT.OutputLines(alphabetizer.getSortedTitles());
			out.printSortedTitles();
		} else if (designChoice == 2) {
			implicit.ObservableLines implicitResult = new implicit.ObservableLines(new implicit.AlphabeticShifter());

			implicit.ObservableLines implicitIgnoredWords = new implicit.ObservableLines(new implicit.IgnoredWordsShifter(implicitResult));
			implicit.ObservableLines implicitLines = new implicit.ObservableLines(new implicit.CircularShifter(implicitIgnoredWords , implicitResult));
			
			implicitIgnoredWords.get().addAll(ignoreWords);
			implicitLines.get().addAll(inputLines);
			
			ADT.Output out = new ADT.OutputLines(implicitResult.get().subList(0, implicitResult.get().size()));
			out.printSortedTitles();
			
		} else {
			System.out.println("Please enter only 1 or 2.");
		}

	}
}
