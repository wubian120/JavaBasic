package cn.brady.string;

import java.util.HashSet;
import java.util.Set;

public class KeywordProcedure {

    private String inputKeyword;
    private Set<Keyword> keywords;

    public KeywordProcedure(String input)
    {
        inputKeyword = input;
        keywords = new HashSet<>();

    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    private Set<String> getWordFromInput(String input){

        if(keywords == null){
            keywords = new HashSet<>();
        }

        



    }

}
