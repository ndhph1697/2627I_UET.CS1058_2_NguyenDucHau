import java.util.Arrays;
import java.util.Random;

/** Sinh các loại dữ liệu test: ngẫu nhiên, sắp xuôi, sắp ngược, toàn giá trị bằng nhau. */
public class DataGenerator {

    public static int[] random(int n, Random rnd) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
        return a;
    }

    public static int[] ascending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        return a;
    }

    public static int[] descending(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = n - i;
        return a;
    }

    public static int[] allEqual(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 7);
        return a;
    }
}
