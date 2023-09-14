//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Pattern;

/**
 * The SuchNpAs class represents a specific pattern matcher for the "such NP as" pattern.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class SuchNpAs extends BaseRegex {
    @Override
    public int getGroupIndex() {
        return 1;
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile("such <np>([^<]+)</np> as <np>[^<]+</np>"
                + "((, | , | ,)<np>[^<]+</np>)*(( |, | , | ,)(and |or |)<np>[^<]+</np>)?");
    }
}
