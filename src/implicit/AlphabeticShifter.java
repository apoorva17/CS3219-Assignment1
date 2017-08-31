package implicit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;

public final class AlphabeticShifter implements Shifter {

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends String> c) {
		while (c.next()) {
			if (c.wasAdded()) {
				FXCollections.sort(c.getList(),String.CASE_INSENSITIVE_ORDER);
			}
		}
	}

	/**
	 * NOT_USED
	 */
	@Override
	public List<String> shift(List<String> toShift) {
		List<String> shifted = new ArrayList<>(toShift);
		Collections.sort(shifted,String.CASE_INSENSITIVE_ORDER);
		return shifted;
	}

}
