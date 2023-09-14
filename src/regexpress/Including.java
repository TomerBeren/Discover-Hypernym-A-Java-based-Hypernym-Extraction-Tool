//209625946 Tomer Berenstein
package regexpress;

import java.util.regex.Pattern;

/**
 * The Including class represents a specific pattern matcher for the "including" pattern.
 *
 * @author Tomer Berenstein tomerbrotem@gmail.com
 * @version 19.0.2
 * @since 2023-01-17
 */
public class Including extends BaseRegex {
    @Override
    public int getGroupIndex() {
        return 1;
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile("<np>([^<]+)</np>( |, | , | ,)including <np>[^<]+</np>"
                + "((, | , | ,)<np>[^<]+</np>)*(( |, | , | ,)(and |or |)<np>[^<]+</np>)?");
    }
}
