package tournamentftc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {

    public static void sort(Double[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Double[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = (begin + end) / 2;
            int pos = partition(array, begin, end, pivotIndex);
            sort(array, begin, pos - 1);
            sort(array, pos + 1, end);
        }
    }

    public static void sort(ArrayList<Double> array) {
        sort(Arrays.copyOf(array.toArray(), array.toArray().length, Double[].class));
    }

    public static void sort(ArrayList<Double> array, int begin, int end) {
        sort(Arrays.copyOf(array.toArray(), array.toArray().length, Double[].class), begin, end);
    }

    private static void swap(Double[] array, int i, int j) {
        double t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private static int partition(Double[] a, int left, int right, int pivotIndex) {
        swap(a, pivotIndex, right);
        int pos = left;
        for (int i = left; i < right; i++) {
            if (a[i] < a[right]) {
                swap(a, i, pos);
                pos++;
            }
        }
        swap(a, right, pos);
        return pos;
    }

    public static ArrayList rank(ArrayList values) {
        ArrayList sortedValues = new ArrayList(values);
        Collections.sort(sortedValues);

        ArrayList<Integer> ranks = new ArrayList();

        for (int i = 0; i < values.size(); i++) {
            ranks.add(sortedValues.indexOf(values.get(i)));
        }
        return ranks;
    }
}
