package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.item.ClientItem;
import org.example.item.Item;
import org.example.item.MinerItem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    static Gson gson = new Gson();
    static String minerName = "7palckov";
    static Block lastBlock;

    private static BlockingQueue<Item> queue = new LinkedBlockingQueue();

    public static Miner miner = new Miner(minerName,queue);
    public static Thread minerThread = new Thread(miner);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        BlockchainClient.connect(queue);

        Item item;
        while (true){
            try {
                item = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (item instanceof ClientItem){
                processClientItem((ClientItem) item);
            }
            if (item instanceof MinerItem){
                processMinerItem((MinerItem) item);
            }
        }
    }

    public static void processMinerItem(MinerItem item){
        Block nextBlock = item.block;
        if (nextBlock.blockNumber>lastBlock.blockNumber){
            //block is new
            JsonObject json = new JsonObject();
            json.addProperty("content",nextBlock.content);
            json.addProperty("hash",nextBlock.hash);
            String message = "submit-block:"+gson.toJson(json);//deluje tudi s to string
            BlockchainClient.submitBlock(message);
        }
    }


    public static void processClientItem(ClientItem item){
      if (item.message.startsWith("Welcome")){
          System.out.println(item.message);
          BlockchainClient.askLastBlock();
      }else {
          JsonObject obj = JsonParser.parseString(item.message).getAsJsonObject();
          if (obj.get("description").getAsString().equals("last-block")){
              JsonObject data = obj.get("data").getAsJsonObject();
              lastBlock = new Block(data.get("content").getAsString(),data.get("hash").getAsString(),data.get("num").getAsInt());
              int targetDifficulty = obj.get("difficulty").getAsInt();



              miner.newBlock(lastBlock,targetDifficulty,targetDifficulty-1);
              if (! minerThread.isAlive()){//start if not running
                  minerThread.start();
              }


          }
      }


    }

}