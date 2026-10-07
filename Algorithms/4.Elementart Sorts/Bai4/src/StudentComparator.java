import java.util.Comparator;

/**
 * So sánh hai sinh viên theo thứ tự ưu tiên:
 *   a) CGPA giảm dần (điểm cao đứng trước)
 *   b) Tên tăng dần theo thứ tự chữ cái
 *   c) Mã id tăng dần (id nhỏ đứng trước)
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student x, Student y) {
        // a) CGPA: đảo vị trí x, y để sắp giảm dần
        int byCgpa = Double.compare(y.getCgpa(), x.getCgpa());
        if (byCgpa != 0) return byCgpa;

        // b) Tên: compareTo của String cho thứ tự chữ cái tăng dần
        int byName = x.getFname().compareTo(y.getFname());
        if (byName != 0) return byName;

        // c) id: nhỏ đứng trước
        return Integer.compare(x.getId(), y.getId());
    }
}
