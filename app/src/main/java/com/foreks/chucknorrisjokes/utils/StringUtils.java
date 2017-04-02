package com.foreks.chucknorrisjokes.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by ozan on 02/04/17.
 */

public class StringUtils {

    public String[] splitSentenceIntoWords(String sentence) {
        return sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public String createStringWithOccurenceNumbers(String[] wordArray) {
        String sentence = "";
        Map<String, Integer> recurringNumDict = new HashMap<>();
        HashSet<String> usedWordSet = new HashSet<>();

        for (int x = 0; x < wordArray.length; x++) {
            for (int z = x + 1; z < wordArray.length; z++) {
                if (wordArray[x].equals(wordArray[z])) {
                    if (recurringNumDict.containsKey(wordArray[x])) {
                        Integer value = recurringNumDict.get(wordArray[x]);
                        recurringNumDict.put(wordArray[x], value + 1);
                    } else {
                        recurringNumDict.put(wordArray[x], 2);
                    }
                }
            }
            if (!usedWordSet.contains(wordArray[x])) {
                if (recurringNumDict.get(wordArray[x]) != null) {
                    sentence = sentence + (wordArray[x] + " (" + recurringNumDict.get(wordArray[x]).toString() + "), ");
                } else {
                    sentence = sentence + (wordArray[x] + " (1), ");
                }
                usedWordSet.add(wordArray[x]);
            }
        }

        return sentence.substring(0, sentence.length() - 2);
    }

    public String[] toCharacterArray(String sentence){

        List<String> charArray = new ArrayList<>();

        char[] stringToCharArray = sentence.replaceAll("\\W", "").toLowerCase().toCharArray();

        for (char output : stringToCharArray) {charArray.add(String.valueOf(output));}

        String [] array = new String[charArray.size()];
        charArray.toArray(array);

        return array;
    }
}
