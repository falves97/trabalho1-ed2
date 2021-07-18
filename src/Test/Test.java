package Test;

import Utils.Item;
import Utils.Table;

import java.security.SecureRandom;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        long resultStringDouble = 0;
        long resultDoubleString = 0;
        long resultIntegers = 0;
        int entrys = 1000000;

        for(int i = 0; i < 1; i++) {
            resultStringDouble += makeTestStringDouble(entrys);
            resultDoubleString += makeTestDoubleString(entrys);
            resultIntegers += makeTestIntegers(entrys);
        }

        System.out.println("Média de tempo para " + entrys + " entradas:");
        System.out.println("Table<Doble, String>: " + resultDoubleString / 10);
        System.out.println("Table<String, Double>: " + resultStringDouble / 10);
        System.out.println("Table<Integer, Integer[]>: " + resultIntegers / 10);
    }

    public static long makeTestStringDouble(int length) {
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

//        System.out.println("instantBegin: " + instantBegin + "; instantEnd: " + instantEnd);
//        System.out.println("Tempo para ordenar <String, Double>: " + (instantEnd - instantBegin));

        return (instantEnd - instantBegin);
    }

    public static long makeTestDoubleString(int length) {
        Table<Double, String> doubleStringTable = new Table<>();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++ ) {
            String str = TestAssist.randomString(10);
            double doubleValue = random.nextDouble() * 100;

            doubleStringTable.put(doubleValue, str);
        }

        long instantBegin;
        long instantEnd;

        instantBegin = System.currentTimeMillis();
        doubleStringTable.sort();
        instantEnd = System.currentTimeMillis();

//        System.out.println("instantBegin: " + instantBegin + "; instantEnd: " + instantEnd);
//        System.out.println("Tempo para ordenar <String, Double>: " + (instantEnd - instantBegin));

        return (instantEnd - instantBegin);
    }

    public static long makeTestIntegers(int length) {
        Table<Integer, Integer[]> integers = new Table<>();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++ ) {
            Integer intValue = random.nextInt() + 1;
            Integer[] integersArray = new Integer[30];

            for (int j = 0; j < 30; j++) {
                integersArray[j] = random.nextInt() + 1;
            }

            integers.put(intValue, integersArray);
        }

        long instantBegin;
        long instantEnd;

        instantBegin = System.currentTimeMillis();
        integers.sort();
        instantEnd = System.currentTimeMillis();

//        System.out.println("instantBegin: " + instantBegin + "; instantEnd: " + instantEnd);
//        System.out.println("Tempo para ordenar <String, Double>: " + (instantEnd - instantBegin));

        return (instantEnd - instantBegin);
    }
}
