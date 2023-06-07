public class heapsorting {
    // descending order
    public static void heapsort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step -2 push largeer element into last
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minidx = i;
        if (left < arr.length && arr[minidx] < arr[left]) {
            minidx = left;
        }
        if (right < arr.length && arr[minidx] < arr[right]) {
            minidx = right;
        }
        if (minidx != i) {
            int temp = arr[i];
            arr[i] = arr[minidx];
            arr[minidx] = temp;

            heapify(arr, minidx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 7 };
        heapsort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
