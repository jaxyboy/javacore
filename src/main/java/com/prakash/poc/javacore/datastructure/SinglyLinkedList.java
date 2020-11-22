package com.prakash.poc.javacore.datastructure;

/**
 * Implement singly LinkedList
 */
public class SinglyLinkedList {
    private Node head;

    // test implementation
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("initialize list");
        singlyLinkedList.insertAtLast(3);
        singlyLinkedList.insertAtLast(7);
        singlyLinkedList.insertAtLast(9);
        singlyLinkedList.insertAtLast(8);
        singlyLinkedList.printElements();
        System.out.println("insert at first");
        singlyLinkedList.insertFirst(11);
        singlyLinkedList.printElements();
        System.out.println("insert by position");
        singlyLinkedList.insertByPosition(1, 22);
        singlyLinkedList.insertByPosition(20, 100);
        singlyLinkedList.printElements();
        System.out.println("delete first");
        singlyLinkedList.deleteFirst();
        singlyLinkedList.printElements();
        System.out.println("delete by position");
        singlyLinkedList.deleteByPosition(8);
        singlyLinkedList.printElements();
        System.out.println("delete last");
        singlyLinkedList.deleteLast();
        singlyLinkedList.printElements();
    }

    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node curNode = this.head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;

    }

    void insertByPosition(int index, int data) {
        Node newData = new Node(data);
        if (index == 0) {
            newData.next = this.head;
            this.head = newData;
        } else {
            int curIndex = 0;
            Node curNode = this.head;
            Node prevNode = null;
            while (curIndex <= index) {
                if (curIndex == index) {
                    prevNode.next = newData;
                    newData.next = curNode;
                    return;
                }
                if (curNode.next == null) {
                    // end  of list
                    curNode.next = newData;
                    return;
                }
                prevNode = curNode;
                curNode = curNode.next;
                curIndex += 1;
            }
        }
    }

    void insertFirst(int data) {
        insertByPosition(0, data);
    }

    void deleteFirst() {
        deleteByPosition(0);

    }

    void deleteLast() {
        Node curNode = this.head;
        Node prevNode = null;
        while (curNode.next != null) {
            prevNode = curNode;
            curNode = curNode.next;
        }
        if (prevNode != null) {
            prevNode.next = null;
        } else {
            this.head = null;
        }
    }

    void deleteByPosition(int index) {
        int curIndex = 0;
        Node curNode = this.head;
        Node prevNode = null;
        while (curIndex <= index) {
            if (curNode == null) {
                System.out.println("index not found");
                return;
            }
            if (curIndex == index) {
                if (prevNode == null) {
                    this.head = curNode.next;
                } else {
                    prevNode.next = curNode.next;
                }
                return;
            }
            curIndex++;
            prevNode = curNode;
            curNode = curNode.next;
        }
    }

    // print elements
    void printElements() {
        if (this.head == null) {
            return;
        }
        Node curNode = this.head;
        int counter = 0;
        while (curNode != null) {
            System.out.println(curNode.data);
            curNode = curNode.next;
            counter++;
        }
    }
}
