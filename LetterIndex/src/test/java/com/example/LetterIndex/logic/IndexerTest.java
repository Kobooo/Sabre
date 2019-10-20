package com.example.LetterIndex.logic;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.*;

class IndexerTest {

    @Test
    void indexWordsToLettersBasicTest() {
        Indexer indexer = new Indexer();
        String EntryText = "ala ma kota, kot koduje w Javie Kota";
        HashMap<Character, SortedSet<String>> actualIndexes = indexer.indexWordsToLetters(EntryText);
        HashMap<Character, SortedSet<String>> expectedIndexes = buildExpectedIndexes();

        assertEquals(expectedIndexes,actualIndexes);
    }


    private HashMap<Character, SortedSet<String>> buildExpectedIndexes() {
        HashMap<Character, SortedSet<String>> expectedCollection = new HashMap<>();

        addToCollection(expectedCollection, Arrays.asList("ala", "javie", "kota", "ma"), 'a');
        addToCollection(expectedCollection, Arrays.asList("koduje"), 'd');
        addToCollection(expectedCollection, Arrays.asList("javie", "koduje"), 'e');
        addToCollection(expectedCollection, Arrays.asList("javie"), 'i');
        addToCollection(expectedCollection, Arrays.asList("javie", "koduje"), 'j');
        addToCollection(expectedCollection, Arrays.asList("koduje", "kot", "kota"), 'k');
        addToCollection(expectedCollection, Arrays.asList("ala"), 'l');
        addToCollection(expectedCollection, Arrays.asList("ma"), 'm');
        addToCollection(expectedCollection, Arrays.asList("koduje", "kot", "kota"), 'o');
        addToCollection(expectedCollection, Arrays.asList("kot", "kota"), 't');
        addToCollection(expectedCollection, Arrays.asList("koduje"), 'u');
        addToCollection(expectedCollection, Arrays.asList("javie"), 'v');
        addToCollection(expectedCollection, Arrays.asList("w"), 'w');

        return expectedCollection;
    }

    private void addToCollection(HashMap<Character, SortedSet<String>> expectedCollection, List<String> strings, char a) {
        SortedSet<String> aSet = new TreeSet<>(strings);
        expectedCollection.put(a, aSet);
    }
}