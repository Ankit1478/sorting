public class countInversion {
    public static int countInversions(int arr[], int si, int ei) {
        if (si >= ei) {
            return 0;
        }
        int mid = si + (ei - si) / 2;
        int count = merge(arr, si, mid, ei);
        count += countInversions(arr, si, mid);
        count += countInversions(arr, mid + 1, ei);
        return count;
    }

    public static int merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
                count += mid - i + 1; // mid tk hi jyega uske baad nhi
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        for (i = si, k = 0; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 20, 7, 6, 3 };
        System.out.println(countInversions(arr, 0, arr.length - 1));
    }
}
