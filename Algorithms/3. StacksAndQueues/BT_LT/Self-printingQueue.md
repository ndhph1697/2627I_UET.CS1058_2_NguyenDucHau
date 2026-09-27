## (a) Nội dung in ra

Cứ 3 thao tác thì in nội dung queue 1 lần (sau thao tác thứ 3, 6, 9, 12):

| Sau thao tác # | Queue lúc đó | In ra |
|---|---|---|
| 3 | [1] | 1 |
| 6 | [2, 3] | 2 3 |
| 9 | [3, 4, 5] | 3 4 5 |
| 12 | [4, 5, 6, 7] | 4 5 6 7 |

**→ Đáp án: `1 2 3 3 4 5 4 5 6 7.`**

## (b) Worst case của 1 lần enqueue

Enqueue bình thường là O(1), nhưng nếu đúng lúc phải in (mỗi 3 thao tác), queue có
thể đang chứa tới n phần tử → in tốn O(n).

**→ Đáp án: Θ(n)**

## (c) Amortized cost trên mỗi thao tác

Việc in xảy ra đều đặn (1/3 số thao tác), không thưa dần theo thời gian, và mỗi
lần in tốn tỉ lệ với kích thước queue lúc đó (có thể lên tới Θ(k) ở thao tác thứ k).
Tổng chi phí in trên cả chuỗi n thao tác ≈ Θ(n²), chia cho n → trung bình mỗi
thao tác vẫn là Θ(n) — không "rẻ" hơn worst case của 1 thao tác đơn lẻ.

**→ Đáp án: Θ(n)**
