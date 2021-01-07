import java.util.function.Consumer;

public
class Stack {
    private static
    class Node {
        private int element;
        private Node prev;

        private
        Node (int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public
    Stack () {

    }

    public
    void push (int element) {
        Node newNode = new Node (element);
        if (this.top == null) {
            this.top = newNode;
        } else {
            newNode.prev = this.top;
            this.top = newNode;
        }
        size++;
    }

    public
    int pop () {
        ensureNonNullElement ();
        int result = this.top.element;
        this.top = this.top.prev;

        this.size--;

        return result;
    }

    private
    void ensureNonNullElement () {
        if (this.top == null) {
            throw new IllegalStateException ("Empty Stack");
        }
    }

    public
    int size () {
        return this.size;
    }

    public
    boolean isEmpty () {
        return this.size == 0;
    }

    public
    int peek () {
        ensureNonNullElement ();
        return this.top.element;
    }

    public
    void forEach (Consumer<Integer> consumer) {
        Node currant = this.top;
        while (currant != null) {
            consumer.accept (currant.element);
            currant = currant.prev;
        }

    }
}






