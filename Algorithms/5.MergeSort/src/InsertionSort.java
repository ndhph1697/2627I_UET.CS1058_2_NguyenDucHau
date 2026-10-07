/** Thuật toán sắp xếp chèn (Insertion Sort) cho mảng int. */
public class InsertionSort {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];   // dịch phần tử lớn hơn key sang phải
                j--;
            }
            a[j + 1] = key;
        }
    }
}
