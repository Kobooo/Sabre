package com.example.LetterIndex.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Indexer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private HashMap<Character, SortedSet<String>> indexedWords = new HashMap<>();

    public HashMap<Character, SortedSet<String>> indexWordsToLetters(String text) {

        text = text.toLowerCase();
        String[] words = text.split("\\W+");
        logger.info("List of found words: " + Arrays.toString(words) + "\n");

        for(String word : words) {
            for(Character letter:word.toCharArray()) {
                SortedSet<String> sortedWords = new TreeSet<>();
                if(indexedWords.get(letter)!=null) {
                    sortedWords = indexedWords.get(letter);
                }
                sortedWords.add(word);
                indexedWords.put(letter,sortedWords);
            }
        }
        indexedWords.entrySet().forEach(entry -> {
            logger.info(entry.getKey() + ": " + entry.getValue());
        });
        return indexedWords;
    }
}