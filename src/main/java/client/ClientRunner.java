package client;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientRunner {


    public static void main(String[] args) {
        BlockChain bc = new ClientRunner().new BlockChain();
        bc.addBlock("tx 1, tx 2");
        bc.addBlock("tx 3");
        bc.addBlock("tx 4, tx 5");
        System.out.println(bc);
        System.out.println(bc.isValidChain());
        bc.chain.get(2).data="tx 100";
        System.out.println(bc.isValidChain());
        bc.chain.get(2).data="tx 3";
        System.out.println(bc.isValidChain());
    }

    class Block{
        private String prevHash;
        private int index;
        private String hash;
        private String data;

        public Block(String prevHash, int index, String data) {
            this.prevHash = prevHash;
            this.index = index;
            this.data = data;
            this.hash = calculateHash();
        }
        public String calculateHash() {
            return DigestUtils.sha256Hex(this.prevHash+this.index+this.data);
        }

        public String getHash() {
            return hash;
        }

        public String getPrevHash() {
            return prevHash;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "prevHash='" + prevHash + '\'' +
                    ", index=" + index +
                    ", hash='" + hash + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        }
    }

    class BlockChain{

        private int index;
        private List<Block> chain = new ArrayList<Block>();

        public BlockChain() {
            this.chain.add(createGenesisBlock());
        }

        private Block createGenesisBlock() {
            return new Block("",0,"");
        }
        public Block getLatestBlock(){
            return chain.get(chain.size()-1);
        }

        public void addBlock(String data){
            index++;
            this.chain.add(new Block(getLatestBlock().getHash(),index, data));
        }

        @Override
        public String toString() {
            return chain.toString();
        }

        public boolean isValidChain(){
            for (int i = chain.size()-1; i >0; i--) {
                if(!chain.get(i).getHash().equals(chain.get(i).calculateHash())) return false;
                if(!chain.get(i).getPrevHash().equals(chain.get(i-1).getHash())) return false;
            }

            return true;
        }
    }


}
