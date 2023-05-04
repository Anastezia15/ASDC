package lab3;

import lab2.ReadingFomFile;
import lab3.binaryTree.Tree;
import lab3.data.Dish;
import lab3.data.ReadingFromFile;
import lab3.myLinkedList.PersonalLinkedList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dish> list = ReadingFromFile.getList();

        System.out.println("LIST:");
        PersonalLinkedList myList = new PersonalLinkedList();
        myList.insertionFromDataBase(list);
        myList.print();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("SEARCH:");
        System.out.println(myList.search(2));
        System.out.println("DELETE:");
        myList.remove(2);
        myList.print();

        System.out.println("------------------------------------------------------------------------------");

        Tree tree = new Tree();
        tree.insertionFromDataBase(list);
        System.out.println("The tree:");
        tree.printTree(tree.getHead());

        System.out.println("\n------------------------------------------------------------------------------");

        System.out.println("SEARCH:");
        System.out.println(tree.findNodeByID(1));
        System.out.println("DELETE:");
        tree.remove(1);
        tree.printTree(tree.getHead());

        System.out.println("\n------------------------------------------------------------------------------");

        System.out.print("Pre-order traversal: ");
        tree.printPreOrder(tree.getHead());
        System.out.print("\nPost-order traversal: ");
        tree.printPostOrder(tree.getHead());
        System.out.print("\nIn-order traversal: ");
        tree.printInOrder(tree.getHead());
    }
}
