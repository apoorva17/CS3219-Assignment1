package implicit;

import static javafx.collections.FXCollections.observableArrayList;

import javafx.collections.ObservableList;

public final class ObservableLines{
	
	private final ObservableList<String> lines;
	
	public ObservableLines(Shifter shifter){
		lines = observableArrayList();
		lines.addListener(shifter);
	}
	
	public ObservableLines(){
		lines = observableArrayList();
	}
	
	public ObservableList<String> get(){
		return lines;
	}
	
}
