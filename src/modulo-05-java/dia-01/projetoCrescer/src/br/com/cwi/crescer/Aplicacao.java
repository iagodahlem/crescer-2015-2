package br.com.cwi.crescer;


public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // linkedList.addFirst("primeiro");
        // linkedList.addLast("segundo");
        // linkedList.addLast("terceiro");

        LinkedList linkedList1 = new LinkedList();
        linkedList1.addFirst("primeiro");
        linkedList1.addLast("segundo");
        linkedList1.addLast("quarto");

        linkedList1.add(2, "terceiro");

        System.out.println(linkedList1.list());
    }
}
