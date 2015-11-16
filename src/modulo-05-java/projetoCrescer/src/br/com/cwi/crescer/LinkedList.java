package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node last, first;

    public void addFirst(String value) {
        Node node = new Node(value, first);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    public void addLast(String value) {
        Node node = new Node(value);
        if (first == null) {
            node = first;
        }
        last = node;
    }

    public void add(int index, String value) {
        Node previousNode = getNode(index - 1);
        Node newNode = new Node(value, previousNode.getNext());
        previousNode.setNext(newNode);
    }

    public void removeFirst() {
        Node node = first;
        first = node.getNext();
    }

    public void remove(int index) {

    }

    public Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String getFirst() {
        return first.getValue();
    }

    public String getLast() {
        return last.getValue();
    }

    public class Node {

        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
