package lab3.binaryTree;

import lab3.data.Dish;

import java.util.List;
import java.util.Objects;

public class Tree {
    private NodeForTree head;

    public Tree() {
        head = null;
    }

    public NodeForTree getHead() {
        return head;
    }

    public void insertNode(Dish dish) {
        NodeForTree newNode = new NodeForTree();
        newNode.setValue(dish);

        if (head == null) {
            head = newNode;
        }
        else {

            NodeForTree currentNode = head;
            NodeForTree parentNode;
            while (true)
            {
                parentNode = currentNode;

                if(Objects.equals(dish.getId(),currentNode.getValue().getId())) {
                    return;
                } else  if (dish.getId() < currentNode.getValue().getId()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }


    public Dish findNodeByID(int id) {
        NodeForTree currentNode = head;
        while (currentNode.getValue().getId() != id) {

            if (id < currentNode.getValue().getId()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.getValue();
    }

    public boolean remove(int value) {
        NodeForTree root = null;
        NodeForTree current = head;
        boolean isLeftChild = false;

        while (current != null) {
            if (current.getValue().getId() == value) {
                break;
            }
            root = current;
            if (value < current.getValue().getId()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }


        if (current == null) {
            return false;
        }


        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == head) { // если нода у нас корень
                head = null;
            } else if (isLeftChild) {
                root.setLeftChild(null);
            } else {
                assert root != null;
                root.setRightChild(null);
            }
        } else if (current.getLeftChild() == null) { // если нет левой ноды у удаляемого элемента
            if (current == head) {
                head = current.getRightChild();
            } else if (isLeftChild) {
                root.setLeftChild(current.getRightChild());
            } else {
                assert root != null;
                root.setRightChild(current.getRightChild());
            }
        } else if (current.getRightChild() == null) { //если нет правой ноды
            if (current == head) {
                head = current.getLeftChild();
            } else if (isLeftChild) {
                root.setLeftChild(current.getLeftChild());
            } else {
                assert root != null;
                root.setRightChild(current.getLeftChild());
            }
        } else { //если есть и правая и левая
            NodeForTree successor = getSuccessor(current);
            if (current == head) {
                head = successor;
            } else if (isLeftChild) {
                root.setLeftChild(successor);
            } else {
                assert root != null;
                root.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private NodeForTree getSuccessor(NodeForTree deleteNode) {
        NodeForTree successorParent = deleteNode;
        NodeForTree successor = deleteNode;
        NodeForTree current = deleteNode.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }


    public void printTree(NodeForTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue().getId() + " ");
        printTree(node.getLeftChild());
        printTree(node.getRightChild());
    }


    public void insertionFromDataBase(List<Dish> list){
        for (int i = 0; i < list.size(); i++) {
            insertNode(list.get(i));
        }
    }

    public void printPreOrder(NodeForTree node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue().getId() + " ");
        printPreOrder(node.getLeftChild());
        printPreOrder(node.getRightChild());
    }


    public  void printPostOrder(NodeForTree node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getLeftChild());
        printPostOrder(node.getRightChild());
        System.out.print(node.getValue().getId() + " ");
    }


    public  void printInOrder(NodeForTree node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild());
        System.out.print(node.getValue().getId() + " ");
        printInOrder(node.getRightChild());
    }
}
