package com.las.learn.algorithm;

import org.junit.Test;

public class LinkedListReverse {

    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        public String prettyToString() {
            StringBuilder sb = new StringBuilder();
            Node h = this;
            while (h != null) {
                sb.append(h.getData());
                h = h.getNext();
                if (h != null) {
                    sb.append("->");
                }
            }
            return sb.toString();
        }
    }

    public Node reverseRecursion(Node head) {
        if (null == head || head.getNext() == null) {
            return head;
        }

        Node reHead = reverseRecursion(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return reHead;
    }

    /**
     * 0->1->2->3
     *
     * @param node
     * @return
     */
    public Node reverseIterator(Node node) {

        Node head = node;//head->0
        Node next = node.getNext();//1
        head.setNext(null);

        while (node != null) {
            node = next.getNext();
            next.setNext(head); //head->1->0
            head = next;
            next = node;
        }

        return head;
    }


    private Node node;

    {
        node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
    }

    @Test
    public void testReverseRecursion() {
        System.out.println(node.prettyToString());
        Node h = reverseRecursion(node);
        System.out.println("reverse:");
        System.out.println(h.prettyToString());
    }

    @Test
    public void testReverseIterator() {
        System.out.println(node.prettyToString());
        Node h = reverseIterator(node);
        System.out.println("reverse:");
        System.out.println(h.prettyToString());
    }
}
