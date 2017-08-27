package ADT;

import java.util.List;

public class OutputLines implements Output{
	private List<String> titles;
	
	//Constructor
    public OutputLines(List<String> titles) {
        this.titles = titles;
    }
    
	@Override
	public void printSortedTitles() {
		 for(String title:titles){
             System.out.println(title);
        }
	}

}
