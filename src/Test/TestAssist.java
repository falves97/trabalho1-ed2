package Test;

import Utils.Table;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class TestAssist {

    public static String randomString(int length) throws IllegalArgumentException {
        StringBuilder stringGen;
        SecureRandom random;

        if (length > 0) {
            String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            stringGen = new StringBuilder(length);
            random = new SecureRandom();

            for (int i = 0; i < length; i++) {
                stringGen.append(base.charAt(random.nextInt(base.length())));
            }
        }
        else {
            throw new IllegalArgumentException("Length must be positive greater than 0");
        }

        return stringGen.toString();
    }
}
