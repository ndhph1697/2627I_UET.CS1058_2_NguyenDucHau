# Bài 2 – Khảo sát MergeSort (tùy chọn: merge "tự nhiên")

Thực hiện tương tự khảo sát Insertion Sort (xem `../bai1-insertion-sort`), thay bằng Mergesort, dùng cùng bộ dữ liệu và so sánh thời gian chạy với Insertion Sort theo từng loại dữ liệu và kích thước.

Phần tùy chọn: cài đặt **Natural Mergesort** (merge "tự nhiên") và so sánh với Mergesort chuẩn.

## File trong thư mục
| File | Vai trò |
|---|---|
| `src/MergeSort.java` | Mergesort chuẩn (top-down, đệ quy) và hàm `merge()` dùng chung |
| `src/NaturalMergeSort.java` | **Tùy chọn**: Natural Mergesort, tận dụng các đoạn đã sắp xếp sẵn |
| `src/InsertionSort.java`, `src/DataGenerator.java` | Bản sao từ Bài 1 để thư mục này tự chạy được |
| `src/Bai2Main.java` | Đo thời gian 3 thuật toán, in bảng thời gian và bảng tỉ lệ |
| `src/SortCheck.java` | Kiểm tra tính đúng đắn của hai Mergesort so với `Arrays.sort` |
| `results/` | Lưu output khi chạy (`bai2.md`) |


## Natural Mergesort hoạt động thế nào
Mergesort chuẩn luôn chia đôi mảng đến tận từng phần tử, không quan tâm dữ liệu đã có thứ tự hay chưa. Natural Mergesort làm ngược lại:

1. Quét mảng một lần, tìm các **run** (đoạn con không giảm, dài nhất có thể) và ghi lại vị trí bắt đầu.
2. Mỗi lượt, trộn từng cặp run kề nhau thành một run dài hơn (dùng chung hàm `merge()`).
3. Lặp lại đến khi chỉ còn một run, khi đó mảng đã sắp xếp.

Ví dụ `3 5 8 | 1 4 | 2 9 | 0` có 4 run, sau lượt 1 còn 2 run (`1 3 4 5 8 | 0 2 9`), sau lượt 2 còn 1 run.

Số lượt trộn là log₂(số run) thay vì log₂N. Run càng ít (dữ liệu càng gần sắp xếp) thì càng nhanh.


