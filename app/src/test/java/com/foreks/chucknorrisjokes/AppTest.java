package com.foreks.chucknorrisjokes;

import com.foreks.chucknorrisjokes.utils.StringUtils;

import org.junit.Assert;
import org.junit.Test;


public class AppTest {

    private StringUtils stringUtils = new StringUtils();

    @Test
    public void testSplitSentenceIntoWords() throws Exception {
        String textToEvaluate = "When Chuck Norris goes to out to eat, he orders a whole chicken, but he only eats its soul";
        String[] expectedResult = {"when", "chuck", "norris", "goes", "to", "out", "to", "eat", "he", "orders", "a",
                "whole", "chicken", "but", "he", "only", "eats", "its", "soul"};

        String[] evaluatedTextArray = stringUtils.splitSentenceIntoWords(textToEvaluate);

        Assert.assertArrayEquals(expectedResult, evaluatedTextArray);
    }


    @Test
    public void testCreateStringWithOccurenceNumbers() throws Exception {
        String[] arrayToEvaluate = {"when", "chuck", "norris", "goes", "to", "out", "to", "eat", "he", "orders", "a",
                "whole", "chicken", "but", "he", "only", "eats", "its", "soul"};
        String expectedResult = "when (1), chuck (1), norris (1), goes (1), to (2), out (1), eat" +
                " (1), he (2), orders (1), a (1), whole (1), chicken (1), but (1), only (1)," +
                " eats (1), its (1), soul (1)";

        String evaluatedSentence = stringUtils.createStringWithOccurenceNumbers(arrayToEvaluate);

        Assert.assertEquals(expectedResult, evaluatedSentence);
    }

    @Test
    public void testToCharacterArray() throws Exception {
        String textToEvaluate = "Chuck Norris ordered a Big Mac at Burger King, and got one.";
        String[] expectedResult = {"c", "h", "u", "c", "k", "n", "o", "r", "r", "i", "s", "o", "r", "d", "e",
                "r", "e", "d", "a", "b", "i", "g", "m", "a", "c", "a", "t", "b", "u", "r", "g", "e", "r", "k",
                "i", "n", "g", "a", "n", "d", "g", "o", "t", "o", "n", "e"};

        String[] evaluatedSentence = stringUtils.toCharacterArray(textToEvaluate);

        Assert.assertArrayEquals(expectedResult, evaluatedSentence);
    }
}