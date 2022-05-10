package com.example.myapplication;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

//Code modified from https://www.baeldung.com/java-blockchain

public class Blockchain implements Serializable {

    private LinkedList<Block> bc;

    public Blockchain() {
        bc = new LinkedList<>();
    }


    public void printBlockchain() {
        Iterator<Block> it = bc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().data());
        }
    }

    public Boolean givenBlockchain_whenValidated_thenSuccess() {
        boolean flag = true;
        for (int i = 0; i < bc.size(); i++) {
            String previousHash = i==0 ? "0" : bc.get(i - 1).getHash();
            flag = bc.get(i).getHash().equals(bc.get(i).calculateBlockHash())
                    && previousHash.equals(bc.get(i).getPreviousHash());

            if (!flag) break;
        }
        return flag;
    }

    public void addBlock(Block block) {
        bc.add(block);
    }

    public Block getBlock(int index) {
        return bc.get(index);
    }
}