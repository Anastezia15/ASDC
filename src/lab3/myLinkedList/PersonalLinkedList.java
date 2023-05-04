package lab3.myLinkedList;

import lab3.data.Dish;

import java.util.List;

public class PersonalLinkedList {

    private NodeForLinkedList head;
    private NodeForLinkedList tail;
    private int size;

    public PersonalLinkedList() {
        head=null;
        tail=null;
        size=0;
    }

    public NodeForLinkedList getHead() {
        return head;
    }

    public NodeForLinkedList getTail() {
        return tail;
    }

    public void add(Dish value) {
        if (head == null) {
            this.head = new NodeForLinkedList(value);
            this.tail = this.head;
        } else {
            NodeForLinkedList temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new NodeForLinkedList(value));
            NodeForLinkedList newNode = temp.getNext();
            newNode.setPrevious(temp);
            this.tail = newNode;
        }
        this.size++;
    }

    public void print() {
        Dish[] result = new Dish[size];
        NodeForLinkedList temp = this.head;
        int index = 0;

        while (temp != null) {
            result[index++] = temp.getValue();
            temp = temp.getNext();
        }

        for (Dish student : result) {
            System.out.println(student.toString());
        }
    }


    public Dish get(int index) {
        if(index < size/2) {
            int currentIndex = 0;
            NodeForLinkedList temp = head;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                } else {
                    temp = temp.getNext();
                    currentIndex++;
                }
            }
        } else {
            int currentIndex = size - 1;
            NodeForLinkedList temp = tail;
            while (temp != null) {
                if (currentIndex == index) {
                    return temp.getValue();
                } else {
                    temp = temp.getPrevious();
                    currentIndex--;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        int currentIndex = 0;
        NodeForLinkedList temp = head;

        while (temp != null) {
            if (index == 0) {
                head = head.getNext();
                head.setPrevious(null);
                size--;
                return;
            }
            if (currentIndex == index - 1) {
                temp.setNext(temp.getNext().getNext());
                if(temp.getNext() != null) {
                    NodeForLinkedList newNext = temp.getNext();
                    newNext.setPrevious(temp);
                    this.tail = temp.getNext();
                } else{
                    tail = temp;
                }
                this.size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    public Dish search(int id){
        NodeForLinkedList current = head;

        while (current!=null){
            if (current.getValue().getId() == id){
                return current.getValue();
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    public void insertionFromDataBase(List<Dish> list){
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

}
