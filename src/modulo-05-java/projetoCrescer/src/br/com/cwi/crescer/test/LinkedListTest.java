package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionarPrimeiroNaLista() {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionarUltimoNaLista() {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");

        assertEquals(linkedList.getLast(), "ultimo");
    }

    @Test
    public void removerPrimeiroItemDaLista() {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.removeFirst();

        assertEquals(linkedList.getFirst(), "segundo");
    }

    @Test
    public void adicionarNodeNoMeioDaLista() {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        linkedList.add(1, "quarto");

        assertEquals(linkedList.getFirst(), "quarto");
    }

}
