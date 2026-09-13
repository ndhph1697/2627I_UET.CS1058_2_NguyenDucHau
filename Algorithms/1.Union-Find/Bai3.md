### (0, 4)
- Trạng thái trước khi gộp:
  - Node 0 là gốc chứa {0, 1, 2, 3} → sz = 4
  - Node 4 là gốc chứa {4, 5, 6, 7} → sz = 4
- Theo quy ước, nếu sz[p] = sz[q] thì ta nối gốc **q** vào gốc **p**. Với p = 0, q = 4, đáng lẽ phải ra cạnh 4 → 0, nhưng thực tế trong hình cạnh lại là 0 → 4.
- **Kết luận: union(0, 4) không thoả mãn** vì làm ngược chiều so với quy ước.

### (4, 0)
- Đây chính là hai cây ở trên nhưng đảo vai trò p, q: p = 4 (sz = 4), q = 0 (sz = 4).
- Hai cây bằng kích thước, gốc của q (là 0) được nối vào gốc của p (là 4) → đúng chiều 0 → 4 như trong hình.
- **Kết luận: union(4, 0) thoả mãn.**

### (2, 3)
- Hiện tại cả 2 và 3 đều có gốc là 4, tức là chúng đã nằm trong cùng một tập.
- TH1: nếu (2, 3) đã được `union` từ trước → vi phạm ngay giả thiết đề bài ("p và q thuộc hai tập khác nhau trước khi union(p,q) được chạy").
- TH2: nếu 3 là node được thêm vào sau cùng (tức 3 nối trực tiếp vào 2) thì đúng là tại thời điểm đó p, q khác tập nhau — nhưng sau đó, tập {2, 3} còn phải tiếp tục được nối lên 0 rồi lên 4. Nghĩa là còn có ít nhất một lệnh `union` khác xảy ra **sau** lệnh union(2,3), nên union(2,3) không thể là lệnh **gần nhất**.
- **Kết luận: union(2, 3) không thoả mãn.**

### (4, 5)
- Trạng thái trước khi gộp:
  - Node 4 là gốc chứa {0, 1, 2, 3, 4, 6} → sz = 6
  - Node 5 là gốc chứa {5, 7} → sz = 2
- Theo quy ước weighted union, cây nhỏ hơn được nối vào cây lớn hơn: sz[4] > sz[5] nên gốc 5 nối vào gốc 4, đúng như cạnh 5 → 4 trong hình.
- **Kết luận: union(4, 5) thoả mãn.**

### (5, 0)
- Đây thực chất là **cùng một sự kiện gộp** như (4, 5) ở trên, chỉ khác là dùng đại diện là 0 (thuộc tập gốc 4) thay vì chính node 4.
- Giả sử trạng thái trước khi gộp:
  - Node 0 thuộc root 4, chứa {0, 1, 2, 3, 4, 6} → sz = 6
  - Node 5 thuộc root 5, chứa {5, 7} → sz = 2
- Vì `find(0) = 4` và `find(5) = 5`, nên `union(5, 0)` cũng dẫn tới đúng thao tác gộp gốc 5 vào gốc 4 (do sz của tập chứa 0 lớn hơn sz của tập chứa 5).
- **Kết luận: union(5, 0) thoả mãn** — vì p, q không nhất thiết phải là chính node gốc, chỉ cần `find(p)`, `find(q)` trỏ đúng về hai gốc cần gộp.

### (5, 7)
- Tương tự trường hợp (2, 3): 7 được nối vào 5 trước, sau đó bản thân tập {5, 7} còn phải tiếp tục nối lên 4. Do đó luôn tồn tại một lệnh `union` khác xảy ra sau union(5, 7), nên nó không thể là lệnh gần nhất.
- **Kết luận: union(5, 7) không thoả mãn.**

### (6, 4)
- Trạng thái trước khi gộp: node 6 là gốc chứa duy nhất {6} → sz = 1; node 4 là gốc chứa {0, 1, 2, 3, 4, 5, 7} → sz = 7.
- Nếu 6 là node cuối cùng được thêm vào cây thì cây nhỏ (6) nối vào cây lớn (4) là hoàn toàn hợp lý và không có thao tác nào khác xảy ra sau đó liên quan đến node 6.
- **Kết luận: union(6, 4) thoả mãn.**

### (8, 9)
- Trạng thái trước khi gộp: node 8 và node 9 đều là gốc của các tập đơn {8} và {9} → sz = 1 = sz.
- Hai cây bằng kích thước, theo quy ước gốc của q (9) nối vào gốc của p (8) → đúng với cạnh 9 → 8 trong hình.
- Vì đây là cây có đúng 2 phần tử, không còn thao tác nào khác có thể xảy ra sau đó trong tập này.
- **Kết luận: union(8, 9) thoả mãn.**
