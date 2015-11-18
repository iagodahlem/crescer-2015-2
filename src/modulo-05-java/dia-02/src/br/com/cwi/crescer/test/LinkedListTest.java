package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionarPrimeiroNaLista() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionarUltimoNaLista() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addLast("ultimo");

        assertEquals(linkedList.getLast(), "ultimo");
    }

    @Test
    public void removerPrimeiroItemDaLista() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.removeFirst();

        assertEquals(linkedList.getFirst(), "segundo");
    }

    @Test
    public void adicionarNodeNaPosicao2() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addFirst("primeiro");
        linkedList.addLast("segundo");
        linkedList.addLast("quarto");
        linkedList.add(2, "terceiro");

        assertEquals(linkedList.getNode(2).getValue(), "terceiro");
    }

    @Test
    public void adicionarNumerosInteirosNaLista() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.addFirst(1);
        linkedList.addLast(2);

        assertEquals(linkedList.getFirst(), 1, 0);
        assertEquals(linkedList.getLast(), 2, 0);
    }

}
