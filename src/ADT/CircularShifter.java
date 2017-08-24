package ADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CircularShifter implements CircularShift {
    
    private List<String> titles;
    private List<String> ignoreWords;
    private List<String> shiftedTitles;
    
    //Constructor
    public CircularShifter(List<String> titles, List<String> ignoreWords) {
        this.titles = titles;
        this.ignoreWords = ignoreWords;
        shiftedTitles = circularShift(titles, ignoreWords);     
    }
    
    public CircularShifter(){
        this.titles = new LinkedList<>();
    }

    private List<String> circularShift(List<String> titles, List<String> ignoreWords) {       
        List<String> shiftedTitles = new LinkedList<>();
        for (String title: titles) {
            String[] wordsInTitle = title.split(" ");
            List<String> words = new ArrayList<>(Arrays.asList(wordsInTitle));
            for (int i = 0; i < words.size() ; ++i) {
                words.add(0,words.remove(words.size() - 1));
                //ignore word 
                String newTitle = convertToString(words);
                String[] wordsInNewTitle = newTitle.split(" ");
                if(!ignoreWords.contains(wordsInNewTitle[0].toLowerCase())){
                    shiftedTitles.add(newTitle);
                }
            }
        }
        return shiftedTitles;
    }
    
    private String convertToString(List<String> array) {
        StringBuilder sb = new StringBuilder();
        for (String e : array) {
            sb.append(e);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public List<String> getShiftedTitles() {
        return shiftedTitles;
    }
}
