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
     * @param list
     * @param comparator
     * @param <T>
     */
    public static <T> void insertion(List<T> list, Comparator<T> comparator) {
        T key;

        for (int i = 1; i < list.size(); i++) {
            key = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

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
     * @param middle
     * @param last
     * @param comparator
     * @param <T>
     */
    public static <T> void toMerge(List<T> arrayA, List<T> arrayB, int init, int middle, int last, Comparator<T> comparator) {
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

    /**
     *
     * @param arrayA
     * @param arrayB
     * @param init
     * @param last
     * @param comparator
     * @param <T>
     * @return
     */
    public static <T> List<T> merge(List<T> arrayA, List<T> arrayB, int init, int last, Comparator<T> comparator) {
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

            for (int i = 0; i < numElem; i++, last--) {
                arrayA.set(last, subList.get(last));
            }
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

        secureRandom = new SecureRandom();
        p = secureRandom.nextInt((last + 1) - init) + init;
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
    public static <T extends Comparable<T>> void quick(List<T> list, int init, int last) {
        int pivot;

        if (init < last){
            pivot = randomPartition(list, init, last);
            quick(list, init, pivot - 1);
            quick(list, pivot + 1, last);
        }
    }



    /**
     *
     * @param list
     * @param init
     * @param last
     * @param <T>
     * @return
     */
    public static <T> int randomPartition(List<T> list, int init, int last, Comparator<T> comparator) {
        SecureRandom secureRandom;
        int i;
        int j;
        int p;
        T pivot;

        secureRandom = new SecureRandom();
        p = secureRandom.nextInt((last + 1) - init) + init;
        exchange(list, init, p);
        pivot = list.get(init);
        i = init + 1;
        j = last;

        while (i <= j) {
            if (comparator.compare(list.get(i), pivot) <= 0) {
                i++;
            }
            else if (comparator.compare(list.get(j), pivot) > 0) {
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
     * @param comparator
     * @param <T>
     */
    public static <T> void quick(List<T> list, int init, int last, Comparator<T> comparator) {
        int pivot;

        if (init < last){
            pivot = randomPartition(list, init, last, comparator);
            quick(list, init, pivot - 1, comparator);
            quick(list, pivot + 1, last, comparator);
        }
    }
}
