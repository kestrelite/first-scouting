package tournamentftc;

public class QuickSort {

    public void sort(double[] array) {
        sort(array, 0, array.length - 1);
    }

    public void sort(double[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = (begin + end) / 2;
            int pos = organize(array, begin, end, pivotIndex);
            sort(array, begin, pos - 1);
            sort(array, pos + 1, end);
        }
    }

    private void swap(double[] array, int i, int j) {
        double t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private int organize(double[] array, int begin, int end, int pivotIndex) {
        swap(array, pivotIndex, end);
        int pos = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[end]) {
                swap(array, i, pos);
                pos++;
            }
        }
        swap(array, end, pos);
        return pos;
    }
}
