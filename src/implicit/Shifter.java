package implicit;

import java.util.List;

import javafx.collections.ListChangeListener;

public interface Shifter extends ListChangeListener<String>{
	public List<String> shift(List<String> toShift);
}
