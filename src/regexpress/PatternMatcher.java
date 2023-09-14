//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Pattern;

/**
 * The PatternMatcher interface defines the contract for matching patterns and retrieving hypernyms.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public interface PatternMatcher {
    /**
     * Matches the provided line against the pattern and retrieves the hypernym.
     *
     * @param line  the line to match against
     * @param lemma the lemma to search for in the matched groups
     * @return the hypernym if found, or null otherwise
     */
    String matchAndGetHypernym(String line, String lemma);

    /**
     * Retrieves the index of the group to extract from the regex match.
     *
     * @return the index of the group
     */
    int getGroupIndex();

    /**
     * Retrieves the regex pattern to use for matching.
     *
     * @return the regex pattern
     */
    Pattern getRegex();
}
