import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {

        //Test Case 1: Basic sentence with some words that appear once, some more than once
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

    }
}