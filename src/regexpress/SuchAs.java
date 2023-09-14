//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Pattern;


/**
 * The SuchAs class represents a specific pattern matcher for the "such as NP" pattern.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class SuchAs extends BaseRegex {
    @Override
    public int getGroupIndex() {
        return 1;
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile("<np>([^<]+)</np>( |, | , | ,)such as <np>[^<]+</np>"
                + "((, | , | ,)<np>[^<]+</np>)*(( |, | , | ,)(and |or |)<np>[^<]+</np>)?");
    }
}
