//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Pattern;

/**
 * The WhichIs class represents a specific pattern matcher for the "which is" pattern.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class WhichIs extends BaseRegex {
    @Override
    public int getGroupIndex() {
        return 4;
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile("<np>[^<]+</np>( |, | , | ,)which is ((an example|a kind|a class) of )?"
                + "<np>([^<]+)</np>");
    }
}
