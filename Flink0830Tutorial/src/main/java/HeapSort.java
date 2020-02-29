import java.util.Arrays;

class HeapSort {
    public static int heapsize;

    public static void main(String[] args) {
        int[] array = {0,9,8,7,6,5,4,3,2,1};
        heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
    public static void maxHeapify(int[] arr, int i) {
        int l = 2 * i, r = 2 * i + 1, largest;
        if (l < heapsize && arr[l] > arr[i]) largest = l;
        else largest = i;
        if (r < heapsize && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void buildMaxHeap(int[] arr, int len) {
        heapsize = len;
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }
    public static void heapSort(int[] arr, int len) {
        buildMaxHeap(arr, len);
        for (int i = len - 1; i >= 1; i--) {
            swap(arr, 0, i);
            heapsize = heapsize - 1;
            maxHeapify(arr, 0);
        }
    }
}