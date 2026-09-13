## Câu A: Số lượng thành phần liên thông

**Trả lời:** 1 thành phần liên thông

**Giải thích:**

Sau khi thực hiện tất cả các phép union, toàn bộ các phần tử từ 1 đến n-1 đều được kết nối với phần tử 0. Kết quả là chỉ có **1 thành phần liên thông** duy nhất chứa tất cả các phần tử.

---

## Câu B: Quick-Find - Số lần cập nhật mảng

**Trả lời:** ~ 1.5n²

**Giải thích:**

Trong quick-find, mỗi phần tử có một giá trị ID chỉ ra thành phần liên thông của nó. Khi `union(p, q)`, ta thay đổi tất cả phần tử có cùng ID với p thành ID của q.

Với dãy `union(0, k)` (k từ 1 đến n-1):
- Mỗi phép `union(0, k)` cần duyệt toàn bộ mảng (n truy cập) để tìm phần tử
- Số phần tử cần cập nhật trong lần thứ k là k
- Tổng truy cập:

$$\sum_{k=1}^{n-1}(n + k) = (n-1) \cdot n + \frac{(n-1)n}{2} = \frac{3n^2 - 3n}{2}$$

**Kết quả: ~ 1.5n²**

---

## Câu C: Quick-Union - find(0) sau các phép union

**Trả lời:** Θ(1)

**Giải thích:**

Trong quick-union, mỗi phần tử trỏ đến cha của nó. Dãy thao tác `union(0, 1), union(0, 2), ...` tạo ra một cấu trúc cây.

Vì theo cách cài đặt quick-union trong đề bài không bao giờ thay đổi `parent[q]`, chuỗi union này sẽ tạo ra:
- 0 ← 1 ← 2 ← 3 ← ... ← n-1

Khi gọi `find(0)`, phần tử 0 chính là gốc (root) của cây, nên chỉ cần **1 lần truy cập** để xác nhận.

**Kết quả: Θ(1)**

*Lưu ý: Nếu gọi `find(n-1)` thay vì `find(0)`, kết quả sẽ là Θ(n) vì phải truyền qua toàn bộ chuỗi.*

---

## Câu D: Weighted Quick-Union - find(0) sau các phép union

**Trả lời:** Θ(1)

**Giải thích:**

Weighted quick-union cân bằng cây bằng cách luôn gắn cây nhỏ hơn dưới cây lớn hơn.

Với dãy `union(0, k)`:
- Phần tử 0 luôn là gốc và kích thước của nó tăng dần
- Các phần tử khác (1, 2, 3, ..., n-1) được gắn dưới 0
- Cây kết quả có cấu trúc **hình sao** với gốc tại 0, tất cả các nút khác là lá

`find(0)` chỉ cần **1 lần truy cập** để xác nhận 0 là gốc.

**Kết quả: Θ(1)**

---

