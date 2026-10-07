import edu.princeton.cs.algs4.In;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * Bài 2 - Khảo sát MergeSort (tùy chọn: merge "tự nhiên") và so sánh với Insertion Sort.
 *
 * Cùng bộ dữ liệu và cách đo với Bài 1:
 *   5 loại: (1) file test algs4-data, (2) ngẫu nhiên, (3) sắp xuôi, (4) sắp ngược, (5) toàn bằng nhau.
 *   Loại (1), (3), (4), (5): trung bình 3 lần. Loại (2): trung bình 5 lần.
 *   N = 1000 ... 32000. Thời gian tính bằng ms.
 *
 * Output: bảng thời gian của 3 thuật toán và bảng tỉ lệ Insertion / MergeSort, Insertion / Natural.
 *
 * Chạy: java -cp "out;algs4.jar" Bai2Main [thu_muc_algs4-data]
 */
public class Bai2Main {

    static final int[] SIZES = {1000, 2000, 4000, 8000, 16000, 32000};
    static final String[] NAMES = {"Insertion Sort", "MergeSort", "Natural MergeSort"};
    static final String HEADER =
            "| N | File test (1) | Ngau nhien (2) | Sap xuoi (3) | Sap nguoc (4) | Toan bang nhau (5) |";
    static final String SEP = "|---|---|---|---|---|---|";

    static double timeOnce(Consumer<int[]> sorter, int[] data) {
        int[] a = data.clone();                       // sort trên bản sao
        long start = System.nanoTime();
        sorter.accept(a);
        long end = System.nanoTime();
        return (end - start) / 1e6;
    }

    static double average(Consumer<int[]> sorter, int[] data, int runs) {
        double sum = 0;
        for (int i = 0; i < runs; i++) sum += timeOnce(sorter, data);
        return sum / runs;
    }

    static double averageRandom(Consumer<int[]> sorter, int n, int runs, Random rnd) {
        double sum = 0;
        for (int i = 0; i < runs; i++) sum += timeOnce(sorter, DataGenerator.random(n, rnd));
        return sum / runs;
    }

    public static void main(String[] args) {
        String dir = args.length > 0 ? args[0] : "algs4-data";
        if (!dir.endsWith("/") && !dir.endsWith("\\")) dir += "/";
        Random rnd = new Random(12345);

        List<Consumer<int[]>> sorters = List.of(
            InsertionSort::sort, MergeSort::sort, NaturalMergeSort::sort);

        // khởi động JIT cho cả 3 thuật toán
        for (Consumer<int[]> s : sorters)
            for (int i = 0; i < 10; i++) s.accept(DataGenerator.random(2000, rnd));

        // t[thuật toán][kích thước][loại dữ liệu]
        double[][][] t = new double[sorters.size()][SIZES.length][5];

        for (int si = 0; si < SIZES.length; si++) {
            int n = SIZES[si];

            int[] fileData = null;
            String path = dir + (n / 1000) + "Kints.txt";
            try {
                fileData = new In(path).readAllInts();
            } catch (Exception e) {
                System.err.println("Khong doc duoc file: " + path);
            }
            int[] asc = DataGenerator.ascending(n);
            int[] desc = DataGenerator.descending(n);
            int[] eq = DataGenerator.allEqual(n);

            for (int k = 0; k < sorters.size(); k++) {
                t[k][si][0] = fileData == null ? Double.NaN : average(sorters.get(k), fileData, 3);
                t[k][si][1] = averageRandom(sorters.get(k), n, 5, rnd);
                t[k][si][2] = average(sorters.get(k), asc, 3);
                t[k][si][3] = average(sorters.get(k), desc, 3);
                t[k][si][4] = average(sorters.get(k), eq, 3);
            }
        }

        // bảng thời gian
        for (int k = 0; k < sorters.size(); k++) {
            System.out.println("## " + NAMES[k] + " (ms)");
            System.out.println(HEADER);
            System.out.println(SEP);
            for (int si = 0; si < SIZES.length; si++) {
                System.out.printf("| %d | %.4f | %.4f | %.4f | %.4f | %.4f |%n", SIZES[si],
                        t[k][si][0], t[k][si][1], t[k][si][2], t[k][si][3], t[k][si][4]);
            }
            System.out.println();
        }

        // bảng tỉ lệ: lớn hơn 1 nghĩa là Insertion Sort chậm hơn
        for (int k = 1; k < sorters.size(); k++) {
            System.out.println("## Ti le thoi gian: Insertion Sort / " + NAMES[k]);
            System.out.println(HEADER);
            System.out.println(SEP);
            for (int si = 0; si < SIZES.length; si++) {
                System.out.printf("| %d |", SIZES[si]);
                for (int d = 0; d < 5; d++) System.out.printf(" %.2f |", t[0][si][d] / t[k][si][d]);
                System.out.println();
            }
            System.out.println();
        }
    }
}
