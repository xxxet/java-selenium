package utils;

import org.apache.commons.text.RandomStringGenerator;

public class RandStrings {
    private static RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('a', 'z')
            .build();

    public static String getRandom(int maxLength) {
        return generator.generate(maxLength);

    }
}
