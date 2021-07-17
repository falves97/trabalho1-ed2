package Utils;

import java.security.SecureRandom;
import java.util.*;

public class Sort {
    /**
     *
     * @param list
     * @param <T>
     */
    public static <T extends Comparable<T>> void insertion(List<T> list) {
        T key;

        for (int i = 1; i < list.size(); i++) {
            key = list.get(i);
            int j = i - 1;
            /*
            *
            */
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            //coloca key no índice correto
            list.set(j + 1, key);
        }
    }

    /**
     *
     * @param arrayA
     * @param arrayB
     * @param init
     * @param middle
     * @param last
     * @param <T>
     */
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
     *
     * @param arrayA
     * @param arrayB
     * @param init
     * @param last
     * @param <T>
     * @return
     */
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
     *
     * @param arrayA
     * @param arrayB
     * @param init
     * @param last
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> List<T> mergeWithInsertion(List<T> arrayA, List<T> arrayB, int init, int last) {
        int midle;
        int numElem;

        numElem = last - init + 1;

        if (arrayB == null) {
            arrayB = new ArrayList<>(arrayA);
        }

        if (numElem > 15) {
            midle = (init + last) / 2;
            merge(arrayA, arrayB, init, midle);
            merge(arrayA, arrayB, midle + 1, last);
            toMerge(arrayA, arrayB, init, midle, last);
        }
        else {
            List<T> subList = arrayA.subList(init, last + 1);
            insertion(subList);

            for (int i = numElem - 1; i > 0; i--, last--) {
                arrayA.set(last, subList.get(i));
            }
        }

        return arrayB;
    }

    public static <T extends Comparable<T>> void toMergeWithoutAux(List<T> arrayA, List<T> arrayB, int init, int middle, int last) {
        int initA;
        int initB;
        int posFree;

        initA = init;
        initB = middle + 1;
        posFree = init;

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
    }

    public static <T extends Comparable<T>> List<T> mergeWithTest(List<T> arrayA, List<T> arrayB, int init, int last) {
        int midle;

        if (arrayB == null) {
            arrayB = new ArrayList<>(arrayA);
        }

        if (init < last) {
            midle = (init + last) / 2;
            merge(arrayA, arrayB, init, midle);
            merge(arrayA, arrayB, midle + 1, last);

            if (arrayA.get(midle).compareTo(arrayB.get(midle + 1)) != 0) {
                toMerge(arrayA, arrayB, init, midle, last);
            }

        }

        return arrayB;
    }

    public static <T extends Comparable<T>> List<T> mergeWithoutAux(List<T> arrayA, List<T> arrayB, int init, int last) {
        int midle;

        if (arrayB == null) {
            arrayB = new ArrayList<>(arrayA);
        }

        if (init < last) {
            midle = (init + last) / 2;
            merge(arrayA, arrayB, init, midle);
            merge(arrayA, arrayB, midle + 1, last);
            toMergeWithoutAux(arrayA, arrayB, init, midle, last);
            toMergeWithoutAux(arrayB, arrayA, init, midle, last);
        }

        return arrayB;
    }

    /**
     *
     * @param list
     * @param i
     * @param j
     * @param <T>
     */
    public static <T> void exchange(List<T> list, int i, int j) {
        T aux = list.get(i);
        list.set(i, list.get(j));
        list.set(j, aux);
    }

    /**
     *
     * @param list
     * @param init
     * @param last
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int randomPartition(List<T> list, int init, int last) {
        SecureRandom secureRandom;
        int i;
        int j;
        int p;
        T pivot;

        p = ((last - init) / 2) + init;
        exchange(list, init, p);
        pivot = list.get(init);
        i = init + 1;
        j = last;

        while (i <= j) {
            if (list.get(i).compareTo(pivot) <= 0) {
                i++;
            }
            else if (list.get(j).compareTo(pivot) > 0) {
                j--;
            }
            else {
                exchange(list, i, j);
                i++;
                j--;
            }
        }
        exchange(list, init, j);

        return j;
    }

    /**
     *
     * @param list
     * @param init
     * @param last
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickWithInsertion(List<T> list, int init, int last, int limit) {
        int pivot;
        int numElem = (last - init) + 1;
        if (numElem > limit){
            pivot = randomPartition(list, init, last);
            quickWithInsertion(list, init, pivot - 1, limit);
            quickWithInsertion(list, pivot + 1, last, limit);
        }
        else {
            List<T> subList = list.subList(init, last + 1);
            insertion(subList);

            for (int i = numElem - 1; i > 0; i--, last--) {
                list.set(last, subList.get(i));
            }
        }
    }

    public static <T extends Comparable<T>> void quickSameSubdivision(List<T> list, int init, int last, int limit, Integer count) {
        int pivot;
        int numElem = (last - init) + 1;
        if (numElem > limit){
            count = count + 2;
            pivot = randomPartition(list, init, last);
            quickWithInsertion(list, init, pivot - 1, limit);
            quickWithInsertion(list, pivot + 1, last, limit);
        }
        else if (count == list.size() / limit){
            List<T> subList = list.subList(init, last + 1);
            insertion(subList);

            for (int i = numElem - 1; i > 0; i--, last--) {
                list.set(last, subList.get(i));
            }
        }
    }
}
