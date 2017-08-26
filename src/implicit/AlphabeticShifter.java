package implicit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;

public class AlphabeticShifter implements Shifter{

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		if(c.wasAdded()){
			FXCollections.sort(c.getList());
		}
	}

	/**
	 * NOT_USED
	 */
	@Override
	public List<String> shift(List<String> toShift) {
		List<String> shifted = new ArrayList<>(toShift);
		Collections.sort(shifted);
		return shifted;
	}

}
