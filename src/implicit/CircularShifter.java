package implicit;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;

public class CircularShifter implements Shifter {

	private final List<String> ignoredWords;
	private final ObservableList<String> destination;

	public CircularShifter(ObservableList<String> ignoredWords, ObservableList<String> destination) {
		this.ignoredWords = Collections.unmodifiableList(ignoredWords);
		this.destination = destination;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		if (c.wasAdded()) {
			List<String> added = (List<String>) c.getAddedSubList();
			List<String> addedShifted = shift(added);
			destination.addAll(addedShifted);
		}

		if (c.wasRemoved()) {
			List<String> removed = (List<String>) c.getRemoved();
			List<String> removedShifted = shift(removed);
			destination.removeAll(removedShifted);
		}

	}

	@Override
	public List<String> shift(List<String> lines) {
		List<String> shifted = new LinkedList<>();
		for (String line : lines) {

			LinkedList<String> words = new LinkedList<>(Arrays.asList(line.split(" ")));
			if (words.isEmpty()) {
				throw new IllegalArgumentException("A line cannot be only composed of spaces characters");
			}

			String firstWord = words.getFirst();
			for (int i = 0; i < words.size(); i++) {
				if (!ignoredWords.contains(firstWord)) {
					StringBuilder s = new StringBuilder();
					for (String word : words) {
						s.append(word);
						s.append(' ');
					}
					shifted.add(s.substring(0, s.length() - 1));
				}
				firstWord = words.pollFirst();
				words.addLast(firstWord);
			}

		}
		return shifted;
	}

}
