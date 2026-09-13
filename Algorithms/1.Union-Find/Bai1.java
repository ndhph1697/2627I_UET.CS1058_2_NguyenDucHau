package Week_1;

public void union(int p, int q) {
    for (int i = 0; i < leader.length; i++) {
        if (leader[i] == leader[p]) {
            leader[i] = leader[q];
        }
    }
}

/*
 Bug: Lỗi xảy ra do giá trị gốc của leader[p] bị ghi đè ngay trong vòng lặp.
 -> Do đó, các phần tử nằm phía sau có cùng giá trị nhóm với p sẽ không thỏa mãn điều kiện if nữa, dẫn đến việc cập nhật bị sót.

 Test case minh họa sự cố:
 * Cho n = 3. Khởi tạo mảng gốc là: leader = [0, 1, 2]
 * Bước 1: Chạy union(1, 0)
   -> p=1 cập nhật theo q=0. Mảng hiện tại: [0, 0, 2] (Phần tử 0 và 1 đang chung nhóm 0).
 * Bước 2: Chạy union(0, 2)
  -> Khi vòng lặp xét i = 0: leader[0] được gán thành leader[2] (giá trị 2).
   -> Khi vòng lặp xét đến i = 1: do leader[0] đã biến thành 2, phép so sánh leader[1] == leader[0] (0 == 2) trả về sai.
  -> Kết quả mảng: [2, 0, 2]. Phần tử số 1 bị kẹt lại nhãn cũ, thuật toán chạy sai.
*/