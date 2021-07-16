package Test;

import Utils.Table;

import java.security.SecureRandom;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Table<Integer, Integer> dbInt = new Table<>();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            dbInt.put(random.nextInt(10) + 1, i);
        }

        System.out.println(dbInt);

        dbInt.sortByKey();

        System.out.println(dbInt);
    }
}
