package lab3.binaryTree;

import lab3.data.Dish;

public class NodeForTree {
    private Dish student ;
    private NodeForTree leftChild;
    private NodeForTree rightChild;

    public void printNode() {
        System.out.println(" Выбранный узел имеет значение :" + student.toString());
    }

    public Dish getValue() {
        return this.student;
    }

    public void setValue(final Dish student) {
        this.student = student;
    }

    public NodeForTree getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final NodeForTree leftChild) {
        this.leftChild = leftChild;
    }

    public NodeForTree getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final NodeForTree rightChild) {
        this.rightChild = rightChild;
    }
}
