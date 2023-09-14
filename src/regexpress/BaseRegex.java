//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The BaseRegex class provides a base implementation for pattern matching with regular expressions.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public abstract class BaseRegex implements PatternMatcher {
    @Override
    public String matchAndGetHypernym(String line, String lemma) {
        Pattern pattern = getRegex();
        Matcher m = pattern.matcher(line);
        // exit the loop if no more matches are found
        while (m.find()) {
            //check if lemma is hypernym of itself.
            String npContent = "<np>" + m.group(getGroupIndex()) + "</np>";
            if (npContent.equals(lemma)) {
                String matchedString = m.group().replaceFirst(lemma, "");
                //if still contains it's the hypernym of itself.
                if (matchedString.contains(lemma)) {
                    return m.group(getGroupIndex());
                } else {
                    return null;
                }
                // the lemma is not the hypernym of itself.
            } else if (m.group().contains(lemma)) {
                return m.group(getGroupIndex());
            }
        }
        return null;
    }

    @Override
    public abstract int getGroupIndex();

    @Override
    public abstract Pattern getRegex();
}
