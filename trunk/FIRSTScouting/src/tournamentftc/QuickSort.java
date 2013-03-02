package tournamentftc;

import java.util.Arrays;

public class QuickSort {
    
    private static int[] index;

    public static void sort(double[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(double[] array, int begin, int end) {
        index = new int[array.length];
        if (begin < end) {
            int pivotIndex = (begin + end) / 2;
            int pos = partition(array, begin, end, pivotIndex);
            sort(array, begin, pos - 1);
            sort(array, pos + 1, end);
        }
    }

    private static void swap(double[] array, int i, int j) {
        double t = array[i];
        array[i] = array[j];
        array[j] = t;
        System.out.println("i: "+i);
        System.out.println("j: "+j);
        index[j] = i;
        System.out.println(index[j]);
    }

    private static int partition(double[] a, int left, int right, int pivotIndex) {
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
    
    public static void main(String [] args) {
        double[] d = {0.0, 80.0, 80.0, 10.0, 50.0, 70.0, 60.0, 90.0, 20.0, 30.0, 40.0, 0.0};
        System.out.println(Arrays.toString(d));
        sort(d, 0, d.length-1);
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(index));
    }
}
