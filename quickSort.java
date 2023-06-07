public class quickSort {
    public static void quicksort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pIdx = parition(arr, si, ei);
        quicksort(arr, si, pIdx - 1); // left
        quicksort(arr, pIdx + 1, ei);// right
    }

    public static int parition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // last element ko pivot lena hai
        int i = si - 1; // to make place element smaller than pivot
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
