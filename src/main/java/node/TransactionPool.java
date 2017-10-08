package node;

import transaction.Transaction;

import java.util.LinkedList;

public class TransactionPool {

    private LinkedList<Transaction> list = new LinkedList();

    public void add(Transaction trs){
        list.add(trs);
    }

    public Transaction remove(){
        Transaction remove = list.remove();
        return remove;
    }

    public LinkedList<Transaction> getList() {
        return list;
    }

    public void setList(LinkedList<Transaction> list) {
        this.list = list;
    }
}
