package br.com.cwi.crescer;


public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addLast("segundo");
        linkedList.addLast("terceiro");
        System.out.println(linkedList.list());
    }
}
