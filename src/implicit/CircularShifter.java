package implicit;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class CircularShifter implements Shifter {

	private final List<String> ignoredWords;
	private final List<String> destination;

	public CircularShifter(ObservableLines ignoredWords, ObservableLines destination) {
		this.ignoredWords = Collections.unmodifiableList(ignoredWords.get());
		this.destination = destination.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public final void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		while (c.next()) {
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
	}

	@Override
	public final List<String> shift(List<String> lines) {
		List<String> shifted = new LinkedList<>();
		for (String line : lines) {

			LinkedList<String> words = new LinkedList<>(Arrays.asList(line.split(" ")));
			if (words.isEmpty()) {
				continue;
			}

			String firstWord = words.getFirst();
			for (int i = 0; i < words.size(); i++) {
				
				if (!ignoredWords.contains(firstWord) && ! firstWord.equals(" ")) {
					
					StringBuilder s = new StringBuilder();
					for (String word : words) {
						s.append(word);
						s.append(' ');
					}
					
					shifted.add(s.substring(0, s.length() - 1));
				}
				
				words.addLast(words.pollFirst());
				firstWord = words.getFirst();
				
			}

		}
		return shifted;
	}

}
