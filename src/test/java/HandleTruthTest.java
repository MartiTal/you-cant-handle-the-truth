import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {

        //Test Case 1: Basic sentence with some words that appear once, some more than once
        // "bob eats corn on the cob for bob loves corn"
        TreeMap<Integer, Set<String>> expected = new TreeMap<>();
        Set<String> words = new HashSet<>();
        //Words that will appear twice
        words.add("bob");
        words.add("corn");
        expected.put(2, new HashSet<String>(words));
        words.clear();
        //Words that will appear once
        words.add("eats");
        words.add("on");
        words.add("the");
        words.add("cob");
        words.add("for");
        words.add("loves");
        expected.put(1, new HashSet<String>(words));
        words.clear();

        TreeMap<Integer, Set<String>> actual = HandleTruth.wordCount("bob eats corn on the cob for bob loves corn");
        assertEquals(expected, actual);


        //Test Case 2: A single word
        // "woah"
        expected = new TreeMap<>();
        //Words that will appear once
        words.add("woah");
        expected.put(1, new HashSet<String>(words));
        words.clear();

        actual = HandleTruth.wordCount("woah");
        assertEquals(expected, actual);


        //Test Case 3: A single word five times
        // "yeah yeah yeah yeah yeah"
        expected = new TreeMap<>();
        //Words that will appear five times
        words.add("yeah");
        expected.put(5, new HashSet<String>(words));
        words.clear();

        actual = HandleTruth.wordCount("yeah yeah yeah yeah yeah");
        assertEquals(expected, actual);


        //Test Case 4: No words
        // " "
        expected = new TreeMap<>();
        //No words expected

        actual = HandleTruth.wordCount(" ");
        assertEquals(expected, actual);

        //Test Case 5: Words that are very similar, yet different
        // "yo you your youre"
        expected = new TreeMap<>();
        //Words that will appear once
        words.add("yo");
        words.add("you");
        words.add("your");
        words.add("youre");
        expected.put(1, new HashSet<String>(words));
        words.clear();

        actual = HandleTruth.wordCount("yo you your youre");
        assertEquals(expected, actual);

        //Test Case 6: Unconventional words or numbers
        // "back in 2001 people were less open-minded in general"
        expected = new TreeMap<>();
        //Words that will appear twice
        words.add("in");
        expected.put(2, new HashSet<String>(words));
        words.clear();
        //Words that will appear once
        words.add("back");
        words.add("2001");
        words.add("people");
        words.add("were");
        words.add("less");
        words.add("open-minded");
        words.add("general");
        expected.put(1, new HashSet<String>(words));
        words.clear();

        actual = HandleTruth.wordCount("back in 2001 people were less open-minded in general");
        assertEquals(expected, actual);

    }
}