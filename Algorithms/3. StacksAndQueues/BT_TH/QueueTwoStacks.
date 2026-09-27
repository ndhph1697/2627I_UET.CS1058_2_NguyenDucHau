import java.util.ArrayList;
import java.util.List;

public class QueueTwoStacks<T> {
    private final MyStack<T> inStack = new MyStack<>();
    private final MyStack<T> outStack = new MyStack<>();

    public void enqueue(T item) {
        inStack.push(item);
    }

    public T dequeue() {
        moveIfNeeded();
        if (outStack.isEmpty()) throw new RuntimeException("Queue rỗng, không dequeue được");
        return outStack.pop();
    }

    public T peekFront() {
        moveIfNeeded();
        if (outStack.isEmpty()) throw new RuntimeException("Queue rỗng, không peek được");
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public void print() {
        moveIfNeeded();

        MyStack<T> temp = new MyStack<>();
        List<T> order = new ArrayList<>(); 

        while (!outStack.isEmpty()) {
            T val = outStack.pop();
            order.add(val);
            temp.push(val);
        }

        while (!temp.isEmpty()) {
            outStack.push(temp.pop());
        }

        System.out.println(order);
    }

    public static void main(String[] args) {
        QueueTwoStacks<Integer> q = new QueueTwoStacks<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.print(); // [1, 2, 3]

        System.out.println("Dequeue: " + q.dequeue()); // 1
        q.print(); // [2, 3]

        q.enqueue(4);
        q.print(); // [2, 3, 4]

        System.out.println("Dequeue: " + q.dequeue()); // 2
        System.out.println("Dequeue: " + q.dequeue()); // 3
        q.print(); // [4]
    }
}
