import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Bài 4 - Java Sort.
 * Nhập: dòng đầu là số sinh viên N, tiếp theo N dòng "id tên cgpa".
 * Xuất: tên các sinh viên sau khi sắp xếp, mỗi tên một dòng.
 *
 * Tên lớp là Solution để nộp thẳng lên HackerRank được
 * (khi nộp một file, dán thêm Student và StudentComparator vào cùng file, bỏ "public").
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}
