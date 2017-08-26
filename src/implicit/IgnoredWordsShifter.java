package implicit;

import java.util.Iterator;
import java.util.List;

public class IgnoredWordsShifter implements Shifter {

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		if(c.wasAdded()){
			@SuppressWarnings("unchecked")
			List<String> words = (List<String>) c.getAddedSubList();
			Iterator<? extends String> it = c.getList().iterator();
			while(it.hasNext() ){
				String firstWord = it.next().split(" ")[0];
				if(words.contains(firstWord)){
					it.remove();
				}
				
			}
		}
		
	}

	@Override
	public List<String> shift(List<String> toShift) {
		// TODO Auto-generated method stub
		return null;
	}

}
