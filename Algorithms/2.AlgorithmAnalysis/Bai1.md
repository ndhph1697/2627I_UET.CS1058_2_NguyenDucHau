# COS226 – s26 – Precept 1: Phân tích số lần gọi `op()`
## Bài 1

### Đề bài

```java
for (int i = 10; i < n + 5; i += 2)
    op();
```

### Trả lời

- `i` chạy từ 10, 12, 14, … cho tới khi `i ≥ n + 5`, bước nhảy là 2.
- Số lần lặp = ⌈(n + 5 − 10) / 2⌉ = ⌈(n − 5) / 2⌉.
- Khi `n` lớn, hằng số cộng/trừ không đáng kể, nên số lần lặp xấp xỉ `n/2`.

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ n / 2** |
| Big Theta | **Θ(n)** |

---

## Bài 2

### Đề bài

```java
for (int i = 1; i <= n * n * n; i *= 2)
    op();
```

### Trả lời

- `i` nhân đôi sau mỗi vòng: `i = 1, 2, 4, …, 2^k`.
- Vòng lặp dừng khi `2^k > n³`, tức `k > log₂(n³) = 3·log₂ n`.
- Số lần lặp = ⌊3·log₂ n⌋ + 1.
- Khi `n` lớn: số lần lặp xấp xỉ `3·log₂ n`.

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ 3 log₂ n** |
| Big Theta | **Θ(log n)** |


---

## Bài 3

### Đề bài

```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < 100; j++)
        op();
```

### Trả lời

- Vòng ngoài chạy `n` lần.
- Vòng trong luôn chạy đúng 100 lần (hằng số, không phụ thuộc `n`).
- Tổng số lần gọi = n × 100 = 100n.

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ 100 n** |
| Big Theta | **Θ(n)** |

---

## Bài 4

### Đề bài

```java
for (int i = 0; i * i < n; i++)
    for (int j = 1; j < n; j *= 3)
        op();
```

### Trả lời

- **Vòng ngoài:** điều kiện `i² < n` ⇔ `i < √n`, nên chạy khoảng `√n` lần.
- **Vòng trong:** `j = 1, 3, 9, …, 3^k` và dừng khi `3^k ≥ n`, tức `k ≈ log₃ n`. Vòng trong chạy khoảng `log₃ n` lần.
- Hai vòng lặp độc lập với nhau (vòng trong không phụ thuộc `i`), nên nhân số lần lặp:

  Tổng ≈ √n × log₃ n = (1 / ln 3) · √n · ln n

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ √n · log₃ n** |
| Big Theta | **Θ(√n · log n)** |

---

## Bài 5

### Đề bài

```java
for (int i = 0; i < n; i++)
    for (int j = 1; j < n; j *= 2)
        op();
```

### Trả lời

- Vòng ngoài chạy `n` lần.
- Vòng trong: `j = 1, 2, 4, …, 2^k` với `2^k < n`, nên chạy khoảng `log₂ n` lần.
- Tổng số lần gọi ≈ n × log₂ n.

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ n log₂ n** |
| Big Theta | **Θ(n log n)** |

---

## Bài 6

### Đề bài

```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < 100; j++)
        for (int k = 0; k < n; k++)
            for (int l = k; l < n; l++)
                op();
```

### Trả lời

- Vòng `i`: chạy `n` lần.
- Vòng `j`: chạy 100 lần (hằng số).
- Hai vòng `k` và `l` lồng nhau, với `l` bắt đầu từ `k`. Với mỗi `k`, vòng `l` chạy `n − k` lần, nên tổng:

  Σ (n − k) với k = 0 … n−1 = n + (n−1) + … + 1 = n(n + 1) / 2 ~ n² / 2

- Tổng số lần gọi ≈ n × 100 × n²/2 = 50 n³.

| Ký hiệu | Kết quả |
|---|---|
| Tilde | **~ 50 n³** |
| Big Theta | **Θ(n³)** |




