package org.example;

import org.example.item.Item;
import org.example.item.MinerItem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Miner implements Runnable{

    BlockingQueue<Item> queue;
    String minerName;
    Block lastBlock;
    int targetDifficulty;
    int shareDifficulty;
    volatile boolean resetNonce = false;

    Miner(String minerName,BlockingQueue<Item> queue){
        this.minerName=minerName;
        this.queue=queue;
    }


    public synchronized void newBlock(Block lastBlock,int targetDifficulty,int shareDifficulty){
        this.lastBlock=lastBlock;
        this.targetDifficulty=targetDifficulty;
        this.shareDifficulty=shareDifficulty;
        resetNonce = true;
    }


    @Override
    public void run() {
        Random r = new Random();
        long nonce = Math.abs(r.nextLong());
        Block nextBlock = new Block();
        while (true){
            nextBlock.content = lastBlock.hash+" "+this.minerName+" "+nonce;
            nextBlock.computeHash();
            if (nextBlock.getBlockDifficulty()>=targetDifficulty) {
                //smo minali novi valid block
                nextBlock.blockNumber = lastBlock.blockNumber+1;
                try {
                    queue.put(new MinerItem(nextBlock));
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                nextBlock = new Block();
            }
            if (++nonce<0){
                nonce=0;
            }
        }
    }
}
