// Class:		Data Structures 02
// Term:		Spring-2022
// Name:		Carlos Macias
// Program Number:	Assignment 3
// IDE: 		IntelliJ JDK 15.0.1

public class MyStackCarlosMacias<E> {
    private int size;
    private Node head;

    private class Node {
        E data;
        Node next;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public E peek() throws RuntimeException {

        if (size == 0) {
            throw new RuntimeException("in peek(): no elements in the stack");
        }

        return head.data;
    }

    public E pop() throws RuntimeException {

        if (size == 0) {
            throw new RuntimeException("in pop(): no elements in the stack");
        }

        //store location and data of top element of stack
        Node pop = head;
        E popped = pop.data;

        //make new top of stack the element right below
        head = head.next;

        //disconnect old element from stack
        pop.next = null;
        size--;

        return popped;
    }

    public E push(E element) {

        //Create new element/node with given data
        Node newNode = new Node();
        newNode.data = element;

        //insert to beginning of list and update head pointer
        newNode.next = head;
        head = newNode;
        size++;

        return head.data;
    }

    @Override
    public String toString() {
        String stackItems = "Top -> Bottom: ";

        Node temp = head;

        int currSize = size;

        // traverse list from head to tail adding string version of data values to stackItems
        while (currSize > 0) {
            stackItems += temp.data;
            currSize--;

            if (currSize > 0) {
                stackItems += ", ";
            }

            temp = temp.next;
        }


        return stackItems;
    }
}
