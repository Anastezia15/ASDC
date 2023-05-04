package lab3.myLinkedList;
import lab3.data.Dish;

public class NodeForLinkedList {
    private Dish value;
    private NodeForLinkedList next;
    private NodeForLinkedList previous;

    public NodeForLinkedList(Dish value) {
        this.value = value;
    }

    public void setPrevious(NodeForLinkedList previous) {
        this.previous = previous;
    }

    public NodeForLinkedList getPrevious() {
        return previous;
    }

    public Dish getValue() {
        return value;
    }

    public NodeForLinkedList getNext() {
        return next;
    }

    public void setNext(NodeForLinkedList next) {
        this.next = next;
    }
}
