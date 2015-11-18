package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.DoublyLinkedList;

public class DoublyLinkedListTest {

    @Test
    public void ListaDuplaRecebeFirst() {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();

        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addFirst("segundo");

        assertEquals(doublyLinkedList.getFirst(), "segundo");
    }

    @Test
    public void ListaDuplaRecebeLast() {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();

        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addLast("segundo");

        assertEquals(doublyLinkedList.getLast(), "segundo");
    }

}
