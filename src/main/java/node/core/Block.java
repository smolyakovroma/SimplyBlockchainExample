package node.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import transaction.Transaction;

import java.util.LinkedList;

@Getter
@Setter
@ToString
public class Block {

    private Block prevBlock;
    private String titleBlock;
    private String prevTitleBlock;
    private LinkedList<Transaction> list = new LinkedList();

    public Block(Block prevBlock, String titleBlock) {
        this.prevBlock = prevBlock;
        this.titleBlock = titleBlock;
    }

    public Block() {
    }
}
