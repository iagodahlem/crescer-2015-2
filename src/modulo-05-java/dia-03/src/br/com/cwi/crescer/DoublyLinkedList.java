package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.LinkedList.Node;

public class DoublyLinkedList<T> {

    private Node<T> first, last;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (isEmpty()) {
            last = node;
        }
        first = node;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (isEmpty()) {
            node = first;
        }
        last.setNext(node);
        last.setPrevious(node.getPrevious());
        last = node;
    }
    
    public void add(int index, T value) {
        Node<T> nodeAnterior = getNode(index - 1);
        Node<T> newNode = new Node<T>(value, nodeAnterior.getNext());
        nodeAnterior.setNext(newNode);
    }
    
    public void removeFirst() {
        Node<T> node = first;
        first = node.getNext();
    }

    public void remove(int index) {
        Node<T> tmp = getNode(index - 1);
        Node<T> removido = tmp.getNext();
        tmp.setNext(removido.getNext());
    }
    
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }
    
    public Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    private boolean isEmpty() {
        return first == null;
    }

    public class Node<E> {

        private E value;
        private Node<E> next, previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        private void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        private void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

    }

}
