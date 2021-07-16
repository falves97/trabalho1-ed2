package Utils;

import java.util.*;

public class Sort {

    /**
     * Métedo que será chamado recursivamente, dividindo a lista de valores pela metade, resolvendo cada metade,
     * logo em seguida juntando as duas metades de forma ordenado.
     * */
    public static <T extends Comparable<T>> List<T> merge(List<T> arrayA, List<T> arrayB, int init, int last) {
        int midle;

        if (arrayB == null) {
            arrayB = new ArrayList<>(arrayA);
        }

        if (init < last) {
            midle = (init + last) / 2;
            merge(arrayA, arrayB, init, midle);
            merge(arrayA, arrayB, midle + 1, last);
            toMerge(arrayA, arrayB, init, midle, last);
        }

        return arrayB;
    }

    /**
     * Métedo que junta as duas metades ordenadas em uma linsta nova com os elementos das duas ordenademate.
     * */
    public static <T extends Comparable<T>> void toMerge(List<T> arrayA, List<T> arrayB, int init, int middle, int last) {
        int initA;
        int initB;
        int posFree;
        int numElem;

        initA = init;
        initB = middle + 1;
        posFree = init;
        numElem = last - init + 1;

        while (initA <= middle && initB <= last) {
            if (arrayA.get(initA).compareTo(arrayA.get(initB)) <= 0) {
                arrayB.set(posFree, arrayA.get(initA));
                initA++;
            }
            else {
                arrayB.set(posFree, arrayA.get(initB));
                initB++;
            }
            posFree++;
        }

        while (initA <= middle) {
            arrayB.set(posFree, arrayA.get(initA));
            posFree++;
            initA++;
        }

        while (initB <= last) {
            arrayB.set(posFree, arrayA.get(initB));
            posFree++;
            initB++;
        }

        for (int i = 0; i < numElem; i++, last--) {
            arrayA.set(last, arrayB.get(last));
        }
    }

    /**
     * Métedo que será chamado recursivamente, dividindo a lista de valores pela metade, resolvendo cada metade,
     * logo em seguida juntando as duas metades de forma ordenado.
     *
     * Esse método ultiliza um Comparator para fazer as comparações, não necessitando que o objeto do tipo T
     * faça aimplementação da interface Comparable;
     * */
    public static <T extends Comparable<T>> List<T> merge(List<T> arrayA, List<T> arrayB, int init, int last, Comparator<T> comparator) {
        int midle;

        if (arrayB == null) {
            arrayB = new ArrayList<>(arrayA);
        }

        if (init < last) {
            midle = (init + last) / 2;
            merge(arrayA, arrayB, init, midle, comparator);
            merge(arrayA, arrayB, midle + 1, last, comparator);
            toMerge(arrayA, arrayB, init, midle, last, comparator);
        }

        return arrayB;
    }

    /**
     * Métedo que junta as duas metades ordenadas em uma linsta nova com os elementos das duas ordenademate
     * usando Comparator.
     * */
    public static <T extends Comparable<T>> void toMerge(List<T> arrayA, List<T> arrayB, int init, int middle, int last, Comparator<T> comparator) {
        int initA;
        int initB;
        int posFree;
        int numElem;

        initA = init;
        initB = middle + 1;
        posFree = init;
        numElem = last - init + 1;

        while (initA <= middle && initB <= last) {
            if (comparator.compare(arrayA.get(initA), arrayB.get(initB)) <= 0) {
                arrayB.set(posFree, arrayA.get(initA));
                initA++;
            }
            else {
                arrayB.set(posFree, arrayA.get(initB));
                initB++;
            }
            posFree++;
        }

        while (initA <= middle) {
            arrayB.set(posFree, arrayA.get(initA));
            posFree++;
            initA++;
        }

        while (initB <= last) {
            arrayB.set(posFree, arrayA.get(initB));
            posFree++;
            initB++;
        }

        for (int i = 0; i < numElem; i++, last--) {
            arrayA.set(last, arrayB.get(last));
        }
    }
}
