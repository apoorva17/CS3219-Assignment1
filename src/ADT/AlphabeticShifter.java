/**
 * Implemented by Apoorva, A0141138N
 */

package ADT;

import java.util.Collections;
import java.util.List;

public class AlphabeticShifter implements AlphabeticShift {

    private List<String> titles;
    
    //Constructor
    public AlphabeticShifter(List<String> titles) {
        this.titles = titles;
        titles = alphabeticSort(titles);
    }
    
    //Sorts lines in ascending alphabetic order
    private List<String> alphabeticSort(List<String> titles) {
        Collections.sort(titles);
        return titles;
    }

    @Override
    public List<String> getSortedTitles() {
        return titles;
    }
    
}
