# Bài 1 – Khảo sát Insertion Sort

## File trong thư mục
| File | Vai trò |
|---|---|
| `src/InsertionSort.java` | Cài đặt thuật toán |
| `src/DataGenerator.java` | Sinh dữ liệu: ngẫu nhiên, sắp xuôi, sắp ngược, toàn bằng nhau |
| `src/Bai1Main.java` | Đo thời gian, in bảng kết quả |
| `results/` | Lưu output khi chạy (`bai1.md`) |

## Chạy (cần `algs4.jar` và thư mục `algs4-data/` ở thư mục gốc repo)
Windows:
```bat
javac -encoding UTF-8 -cp "algs4.jar" -d out bai1-insertion-sort\src\*.java
java -cp "out;algs4.jar" Bai1Main algs4-data > bai1-insertion-sort\results\bai1.md
```
Linux/macOS:
```bash
javac -encoding UTF-8 -cp algs4.jar -d out bai1-insertion-sort/src/*.java
java -cp "out:algs4.jar" Bai1Main algs4-data > bai1-insertion-sort/results/bai1.md
```

## Phương pháp
- (1) file `1Kints.txt` … `32Kints.txt`, (2) ngẫu nhiên, (3) sắp xuôi, (4) sắp ngược, (5) toàn giá trị bằng nhau.
- Loại (1), (3), (4), (5) lấy trung bình 3 lần; loại (2) lấy trung bình 5 lần với dữ liệu khác nhau.
- N = 1000, 2000, 4000, 8000, 16000, 32000. Đơn vị: ms.

## Bảng thời gian (ms)
> Dán kết quả chạy vào đây.

| N | File test (1) | Ngẫu nhiên (2) | Sắp xuôi (3) | Sắp ngược (4) | Toàn bằng nhau (5) |
|---|---|---|---|---|---|
| 1000 | | | | | |
| 2000 | | | | | |
| 4000 | | | | | |
| 8000 | | | | | |
| 16000 | | | | | |
| 32000 | | | | | |

## Nhận xét
| Loại dữ liệu | Số phép so sánh / dịch chuyển | Độ phức tạp | N tăng gấp đôi |
|---|---|---|---|
| (1), (2) Ngẫu nhiên | ≈ N²/4 | O(N²) | thời gian ≈ ×4 |
| (3) Sắp xuôi | N − 1 so sánh, không dịch chuyển | O(N) | ≈ ×2 |
| (4) Sắp ngược | ≈ N²/2 (xấu nhất) | O(N²) | ≈ ×4 |
| (5) Toàn bằng nhau | N − 1 so sánh (`a[j] > key` luôn sai) | O(N) | ≈ ×2 |

- Dữ liệu sắp xuôi và toàn bằng nhau chạy nhanh nhất, gần tuyến tính.
- Dữ liệu sắp ngược chậm nhất, khoảng gấp 2 lần dữ liệu ngẫu nhiên vì mỗi phần tử phải dịch qua toàn bộ phần đã sắp.
- File test (1) cho kết quả gần dữ liệu ngẫu nhiên vì các file `Kints` là số nguyên ngẫu nhiên.
- Với 3 loại dữ liệu bậc hai, N nhân đôi thì thời gian tăng khoảng 4 lần, đặc trưng của O(N²).

> Sau khi có số liệu, thêm 1–2 câu đối chiếu với số đo thực tế (ví dụ tỉ lệ T(2N)/T(N)).
