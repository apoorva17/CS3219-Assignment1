package ADT;

import java.util.List;

public class LineCharacters implements Characters{
    
    private List<String> titles;
    private List<String> ignoreWords;
    
    //Constructor
    public LineCharacters(List<String> titles, List<String> ignoreWords) {
        this.titles = titles;
        this.ignoreWords = ignoreWords;
    }

    @Override
    public void setCharacters(List<String> characters, List<String> words) {
        titles = characters;
        ignoreWords = words;
        
    }

    @Override
    public List<String> getTitles() {
        return titles;
    }
    
    @Override
    public List<String> getIgnoreWords() {
        return ignoreWords;
    }


}
