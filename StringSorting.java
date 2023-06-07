public class StringSorting {
    public static void sortstring(String arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        sortstring(arr, si, mid);
        sortstring(arr, mid + 1, ei);
        merge(arr, si, mid, ei);

    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int k = 0;
        int i = si;
        int j = mid + 1;
        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) < 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k++] = arr[i++];

        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        for (i = si, k = 0; k < temp.length; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mass", "mercury" };

        sortstring(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
