//209625946 Tomer Berenstein

import regexpress.Especially;
import regexpress.Including;
import regexpress.PatternMatcher;
import regexpress.SuchAs;
import regexpress.SuchNpAs;
import regexpress.WhichIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * DiscoverHypernym is a class designed to identify hypernyms for a given lemma
 * in a provided corpus of text files.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class DiscoverHypernym {
    private Map<String, Integer> hypernymCount = new HashMap<>();
    private String lemma;
    private List<PatternMatcher> matchers;

    /**
     * Constructor for the DiscoverHypernym class.
     *
     * @param lemma    The lemma for which to find hypernyms.
     * @param matchers The list of pattern matchers to use when identifying hypernyms.
     */
    public DiscoverHypernym(String lemma, List<PatternMatcher> matchers) {
        this.lemma = "<np>" + lemma + "</np>";
        this.matchers = matchers;
    }

    /**
     * Returns the lemma for which the class is identifying hypernyms.
     *
     * @return The lemma.
     */
    public String getLemma() {
        return lemma;
    }

    /**
     * Processes a line of text to identify and count hypernyms for the lemma.
     *
     * @param line The line of text to process.
     */
    public void processLine(String line) {
        for (PatternMatcher matcher : matchers) {
            String hypernym = matcher.matchAndGetHypernym(line, this.lemma);
            if (hypernym != null) {
                hypernymCount.put(hypernym, hypernymCount.getOrDefault(hypernym, 0) + 1);
            }
        }

    }

    /**
     * Discovers and counts hypernyms in all text files in a specified directory.
     *
     * @param directoryPath The path to the directory containing the text files.
     */
    public void discover(String directoryPath) {
        FileProcessor processor = new FileProcessor();
        processor.processAllFilesInDirectory(directoryPath, this);
        printHypernyms();
    }

    /**
     * Prints all discovered hypernyms and their counts to the console.
     */
    private void printHypernyms() {
        if (hypernymCount.isEmpty()) {
            System.out.println("The lemma doesn't appear in the corpus.");
        } else {
            Set<Map.Entry<String, Integer>> entries = hypernymCount.entrySet();
            Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();
            valueComparator = valueComparator.reversed();
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(entries);
            sortedEntries.sort(valueComparator);
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": (" + entry.getValue() + ")");
            }
        }
    }

    /**
     * The main method, where execution begins.
     *
     * @param args The array of command-line arguments. It expects the directory path as args[0]
     *             and the lemma as args[1].
     */
    public static void main(String[] args) {
        List<PatternMatcher> matchers = Arrays.asList(
                new SuchAs(),
                new SuchNpAs(),
                new WhichIs(),
                new Especially(),
                new Including()
        );
        DiscoverHypernym discoverHypernym = new DiscoverHypernym(args[1], matchers);
        discoverHypernym.discover(args[0]);
    }
}
