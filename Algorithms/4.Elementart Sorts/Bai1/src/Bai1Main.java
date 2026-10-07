import edu.princeton.cs.algs4.In;
import java.util.Random;

/**
 * Bài 1 - Khảo sát Insertion Sort.
 *
 * 5 loại dữ liệu: (1) file test algs4-data, (2) ngẫu nhiên, (3) sắp xuôi,
 *                 (4) sắp ngược, (5) toàn giá trị bằng nhau.
 * Loại (1), (3), (4), (5): trung bình 3 lần chạy. Loại (2): trung bình 5 lần.
 * Thời gian tính bằng ms. Kết quả in ra dạng bảng markdown (tiêu đề không dấu để tránh lỗi font khi chuyển hướng ra file).
 *
 * Chạy: java -cp "out;algs4.jar" Bai1Main [thu_muc_algs4-data]
 */
public class Bai1Main {

    static final int[] SIZES = {1000, 2000, 4000, 8000, 16000, 32000};

    /** Đo một lần sort (ms) trên bản sao của mảng để không làm hỏng dữ liệu gốc. */
    static double timeOnce(int[] data) {
        int[] a = data.clone();
        long start = System.nanoTime();
        InsertionSort.sort(a);
        long end = System.nanoTime();
        return (end - start) / 1e6;
    }

    static double average(int[] data, int runs) {
        double sum = 0;
        for (int i = 0; i < runs; i++) sum += timeOnce(data);
        return sum / runs;
    }

    static double averageRandom(int n, int runs, Random rnd) {
        double sum = 0;
        for (int i = 0; i < runs; i++) sum += timeOnce(DataGenerator.random(n, rnd));
        return sum / runs;
    }

    public static void main(String[] args) {
        String dir = args.length > 0 ? args[0] : "algs4-data";
        if (!dir.endsWith("/") && !dir.endsWith("\\")) dir += "/";
        Random rnd = new Random(12345);

        // Chạy khởi động để JIT biên dịch trước, tránh lần đo đầu bị chậm bất thường
        for (int i = 0; i < 10; i++) InsertionSort.sort(DataGenerator.random(2000, rnd));

        System.out.println("| N | File test (1) | Ngau nhien (2) | Sap xuoi (3) | Sap nguoc (4) | Toan bang nhau (5) |");
        System.out.println("|---|---|---|---|---|---|");

        for (int n : SIZES) {
            double t1;
            String path = dir + (n / 1000) + "Kints.txt";
            try {
                int[] fileData = new In(path).readAllInts();
                t1 = average(fileData, 3);
            } catch (Exception e) {
                System.err.println("Khong doc duoc file: " + path);
                t1 = Double.NaN;
            }
            double t2 = averageRandom(n, 5, rnd);
            double t3 = average(DataGenerator.ascending(n), 3);
            double t4 = average(DataGenerator.descending(n), 3);
            double t5 = average(DataGenerator.allEqual(n), 3);

            System.out.printf("| %d | %.3f | %.3f | %.3f | %.3f | %.3f |%n", n, t1, t2, t3, t4, t5);
        }
    }
}
