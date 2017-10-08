package node.core;

import lombok.Getter;
import lombok.Setter;
import transaction.Transaction;

import java.util.LinkedList;

@Getter
@Setter
public class BlockChain {
    private static LinkedList<Block> list = new LinkedList();

    static {
        list.add(new Block(null,"start"));
    }

    public static String getLastHash(){
        return list.getLast().getTitleBlock();
    }

    public static Block getLastBlock(){
        return list.getLast();
    }

    public static LinkedList<Block> getList() {
        return list;
    }

    public static void addToChain(Block block){
        list.add(block);
    }
}
