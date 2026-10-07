/**
 * Natural Mergesort (merge "tự nhiên").
 *
 * Ý tưởng: thay vì chia đôi mảng một cách máy móc, tận dụng các đoạn đã được
 * sắp xếp sẵn trong dữ liệu (gọi là "run" = đoạn con không giảm tối đa).
 *   1. Quét mảng một lần để tìm ranh giới các run.
 *   2. Mỗi lượt, trộn từng cặp run kề nhau thành một run dài hơn.
 *   3. Lặp lại cho đến khi chỉ còn một run, khi đó mảng đã được sắp xếp.
 *
 * Hệ quả:
 *   - Mảng đã sắp xếp (hoặc toàn giá trị bằng nhau): chỉ có 1 run, không cần trộn, O(N).
 *   - Mảng sắp ngược: có N run độ dài 1, tương đương Mergesort bottom-up, O(N log N).
 *   - Mảng ngẫu nhiên: khoảng N/2 run (độ dài trung bình 2), tiết kiệm được khoảng một lượt trộn.
 *
 * Độ phức tạp tối đa vẫn là O(N log N); bộ nhớ phụ: mảng aux (N) và mảng ranh giới run (N + 1).
 */
public class NaturalMergeSort {

    public static void sort(int[] a) {
        int n = a.length;
        if (n < 2) return;

        int[] aux = new int[n];
        int[] starts = new int[n + 1];       // starts[i] = vị trí bắt đầu của run thứ i
        int runs = findRuns(a, starts);

        while (runs > 1) {
            runs = mergePass(a, aux, starts, runs);
        }
    }

    /** Tìm các run không giảm. Trả về số run; starts[runs] = n làm mốc kết thúc. */
    static int findRuns(int[] a, int[] starts) {
        int runs = 1;
        starts[0] = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) starts[runs++] = i;   // a[i] bắt đầu một run mới
        }
        starts[runs] = a.length;
        return runs;
    }

    /** Một lượt: trộn các cặp run kề nhau, cập nhật starts. Trả về số run còn lại. */
    static int mergePass(int[] a, int[] aux, int[] starts, int runs) {
        int newRuns = 0;
        int i = 0;
        while (i < runs) {
            int lo = starts[i];
            if (i + 1 < runs) {
                int mid = starts[i + 1] - 1;     // hết run thứ i
                int hi  = starts[i + 2] - 1;     // hết run thứ i + 1
                MergeSort.merge(a, aux, lo, mid, hi);
                i += 2;
            } else {
                i++;                             // run lẻ ở cuối, giữ nguyên cho lượt sau
            }
            starts[newRuns++] = lo;
        }
        starts[newRuns] = a.length;
        return newRuns;
    }
}
