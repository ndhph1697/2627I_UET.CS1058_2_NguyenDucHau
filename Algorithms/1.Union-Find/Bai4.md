## Bài 4 — Tóm tắt

`parent[8]` có thể là **0, 4, hoặc 8** — vì đó là những node có thể có kích thước cây ≥ 2 (kích thước của {8,9}) tại thời điểm gộp; các node còn lại (1, 2, 3, 6, 7 là lá, size 1) đều nhỏ hơn nên phải là bên bị gắn vào chứ không thể nhận, còn node 5 dẫn tới mâu thuẫn kích thước khi gộp lên 4.
