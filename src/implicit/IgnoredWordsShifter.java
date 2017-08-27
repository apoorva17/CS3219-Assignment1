package implicit;

import java.util.Iterator;
import java.util.List;

import javafx.collections.ObservableList;

public class IgnoredWordsShifter implements Shifter {
	
	private final ObservableList<String> destination;
	
	public IgnoredWordsShifter(ObservableLines destination) {
		this.destination = destination.get();
	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		c.next();
		if(c.wasAdded()){
			@SuppressWarnings("unchecked")
			List<String> words = (List<String>) c.getAddedSubList();
			shift(words);
		}
		
	}

	@Override
	public List<String> shift(List<String> toShift) {
		Iterator<? extends String> it = destination.iterator();
		while(it.hasNext() ){
			String firstWord = it.next().split(" ")[0];
			if(toShift.contains(firstWord)){
				it.remove();
			}
			
		}
		return destination.subList(0, destination.size());
	}

}
