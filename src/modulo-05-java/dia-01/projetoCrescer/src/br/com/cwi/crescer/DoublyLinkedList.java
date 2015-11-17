package br.com.cwi.crescer;

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
