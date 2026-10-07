# Bài 4 – Java Sort

Sắp xếp danh sách sinh viên theo thứ tự ưu tiên:
1. CGPA giảm dần (điểm cao đứng trước)
2. Tên tăng dần theo thứ tự chữ cái
3. Mã id tăng dần

## File trong thư mục
| File | Vai trò |
|---|---|
| `src/Student.java` | Lớp sinh viên (id, fname, cgpa) |
| `src/StudentComparator.java` | **Phần cần viết**: so sánh hai sinh viên theo 3 tiêu chí |
| `src/Solution.java` | Chương trình chính: nhập, `Collections.sort(...)`, in tên |
| `input/`, `expected/` | Dữ liệu test và kết quả mong đợi |

```

## Giải thích
- `Double.compare(y.getCgpa(), x.getCgpa())`: đảo thứ tự tham số để sắp giảm dần.
- `x.getFname().compareTo(y.getFname())`: so sánh chuỗi theo bảng chữ cái, âm nếu `x` đứng trước `y`.
- `Integer.compare(x.getId(), y.getId())`: id nhỏ đứng trước.
- Chỉ xét tiêu chí tiếp theo khi tiêu chí trước cho kết quả bằng nhau (`== 0`).

## Ví dụ (`input/sample1.txt`)
Đầu vào:
```
5
33 Rumpa 3.68
85 Ashis 3.85
56 Samiha 3.75
19 Samara 3.75
22 Fahim 3.76
```
Đầu ra:
```
Ashis
Fahim
Samara
Samiha
Rumpa
```
Samara và Samiha cùng CGPA 3.75 nên xếp theo tên: Samara đứng trước Samiha.
