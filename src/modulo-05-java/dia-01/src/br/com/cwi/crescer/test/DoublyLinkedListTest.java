package br.com.cwi.crescer.test;

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

    private void assertEquals(String first, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void ListaDuplaRecebeLast() {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<String>();

        doublyLinkedList.addFirst("primeiro");
        doublyLinkedList.addLast("segundo");

        assertEquals(doublyLinkedList.getLast(), "segundo");
    }

}
