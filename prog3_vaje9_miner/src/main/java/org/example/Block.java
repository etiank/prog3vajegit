package org.example;

import java.security.MessageDigest;

public class Block {

    String content;
    String hash;
    int blockNumber;

    public Block(){}

    public Block(String content, String hash, int blockNumber) {
        this.content = content;
        this.hash = hash;
        this.blockNumber = blockNumber;
    }

    public void computeHash(){
        MessageDigest digest = null;
        byte[] encodedHash = new byte[32];
        try {
            digest = MessageDigest.getInstance("SHA-256");
            encodedHash = digest.digest(this.content.getBytes("UTF-8"));
        }catch (Exception e){
            System.out.println(e);
        }
        StringBuilder hexString = new StringBuilder(64);
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length()==1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        this.hash=hexString.toString();
    }

    public int getBlockDifficulty(){
        for (int i = 0; i < hash.length(); i++) {
            if (hash.charAt(i)!='0'){
                return i;
            }
        }
        return hash.length();
    }

}
