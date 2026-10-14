import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

// Ex 4.5 (Challenge): composition version
class Stack<T> {
    private final List<T> items = new ArrayList<>();       // HAS-A list, not IS-A list

    public void push(T item) { items.add(item); }
    public T pop() {
        if (items.isEmpty()) throw new EmptyStackException();
        return items.remove(items.size() - 1);
    }
    public T peek() {
        if (items.isEmpty()) throw new EmptyStackException();
        return items.get(items.size() - 1);
    }
    public boolean isEmpty() { return items.isEmpty(); }
    public int size() { return items.size(); }
}

// The inheritance version (class Stack<T> extends ArrayList<T>) wrongly exposes every ArrayList
// method: add(0, x), remove(index), set(i, x), get(i), sort(...). A caller could insert or remove in
// the middle and break the last-in-first-out rule. Inheritance says "a Stack IS-A list", which is
// false, because a stack deliberately offers LESS than a list. It also locks us to ArrayList forever.
// With composition the public interface is exactly push/pop/peek/isEmpty/size, and the
// internal list could become a LinkedList later without any caller noticing.
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a"); s.push("b"); s.push("c");
        System.out.println(s.pop() + " " + s.peek() + " size=" + s.size());
        // s.add(0, "x");   // would not compile: no such method, which is the point
        try { new Stack<Integer>().pop(); } catch (EmptyStackException e) { System.out.println("Cannot pop an empty stack"); }
    }
}
