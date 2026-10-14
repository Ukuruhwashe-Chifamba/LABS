import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Ex 8.3 (Intermediate)
class Stack<T> {
    private final List<T> items = new ArrayList<>();
    public void push(T item) { items.add(item); }
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return items.remove(items.size() - 1);
    }
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return items.get(items.size() - 1);
    }
    public boolean isEmpty() { return items.isEmpty(); }
}
public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3);
        System.out.println(s.pop() + " " + s.peek());
        Stack<String> t = new Stack<>();
        t.push("x");
        String str = t.pop();          // no cast needed: the compiler knows T is String
        System.out.println(str + " empty? " + t.isEmpty());
        // s.push("text");   // compile error: Stack<Integer> only accepts Integer
    }
}
