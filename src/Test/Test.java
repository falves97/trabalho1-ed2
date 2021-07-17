package Test;

import Utils.Item;
import Utils.Table;

import java.security.SecureRandom;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        makeTestStringDouble(10000000);
    }

    public static void makeTestStringDouble(int length) {
        Table<String, Double> stringDoubleTable = new Table<>();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++ ) {
            String str = TestAssist.randomString(10);
            double doubleValue = random.nextDouble() * 100;

            stringDoubleTable.put(str, doubleValue);
        }

        long instantBegin;
        long instantEnd;

        instantBegin = System.currentTimeMillis();
        stringDoubleTable.sort();
        instantEnd = System.currentTimeMillis();

        System.out.println("instantBegin: " + instantBegin + "; instantEnd: " + instantEnd);
        System.out.println("Tempo para ordenar <String, Double>: " + (instantEnd - instantBegin));
    }

}
