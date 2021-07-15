package Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Sort {

    /**
     * Métedo que será chamado recursivamente, dividindo a lista de valores pela metade, resolvendo cada metade,
     * logo em seguida juntando as duas metades de forma ordenado
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
     * Métedo que junta as duas metades ordenadas em uma linsta nova com os elementos das duas ordenademate
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
     * Esse método aqui de baixo vai ser modificado pra usaar a estrutura q eu criar, talvez.*/



//    public static <K extends Comparable<K>, V> Map<K, V> merge(Map<K, V> arrayA) {
//        List<K> keys = new ArrayList<>(arrayA.keySet());
//
//        List<K> keysOrdered = merge(keys, null, 0, keys.size() - 1);
//
//        Map<K, V> ordenedMap = new LinkedHashMap<>();
//
//        for (K key: keysOrdered) {
//            ordenedMap.put(key, arrayA.get(key));
//        }
//
//        return ordenedMap;
//    }
}
