import java.util.Arrays;
import java.util.Random;

/** Kiểm tra tính đúng đắn của MergeSort và NaturalMergeSort so với Arrays.sort. */
public class SortCheck {

    interface Sorter { void sort(int[] a); }

    static boolean check(String name, Sorter s, int[] data) {
        int[] expected = data.clone();
        Arrays.sort(expected);
        int[] actual = data.clone();
        s.sort(actual);
        if (!Arrays.equals(expected, actual)) {
            System.out.println("SAI: " + name + " với mảng " + Arrays.toString(
                    Arrays.copyOf(data, Math.min(data.length, 20))));
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] names = {"MergeSort", "NaturalMergeSort"};
        Sorter[] sorters = {MergeSort::sort, NaturalMergeSort::sort};
        Random rnd = new Random(1);
        boolean ok = true;
        int cases = 0;

        for (int k = 0; k < sorters.length; k++) {
            // các trường hợp biên
            int[][] fixed = {
                {}, {5}, {2, 1}, {1, 2}, {3, 3, 3}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1},
                {1, 3, 5, 2, 4, 6}, {4, 5, 1, 2, 3, 0}, {2, 1, 2, 1, 2, 1}
            };
            for (int[] d : fixed) { ok &= check(names[k], sorters[k], d); cases++; }

            // ngẫu nhiên: nhiều kích thước, nhiều khoảng giá trị (có trùng lặp)
            for (int n = 0; n <= 200; n++) {
                for (int range : new int[]{2, 10, 1000}) {
                    int[] d = new int[n];
                    for (int i = 0; i < n; i++) d[i] = rnd.nextInt(range);
                    ok &= check(names[k], sorters[k], d); cases++;
                }
            }
            // các loại dữ liệu của đề
            for (int n : new int[]{1000, 5000}) {
                ok &= check(names[k], sorters[k], DataGenerator.random(n, rnd));
                ok &= check(names[k], sorters[k], DataGenerator.ascending(n));
                ok &= check(names[k], sorters[k], DataGenerator.descending(n));
                ok &= check(names[k], sorters[k], DataGenerator.allEqual(n));
                cases += 4;
            }
        }
        System.out.println(ok ? "TAT CA " + cases + " TEST DEU DUNG" : "CO TEST SAI");
    }
}
