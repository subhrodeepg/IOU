package com.example.myapplication;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Code modified from https://www.baeldung.com/java-blockchain


import static java.nio.charset.StandardCharsets.UTF_8;

public class Block {

    private String recipient;
    private String sender;
    private String transaction;
    private boolean completed;
    private Block next;
    private String timeStamp;
    private String previousHash;


    public Block(String recipient, String sender, String transaction, String previousHash) {
        this.recipient = recipient;
        this.sender = sender;
        this.transaction = transaction;
        this.completed = false;
        this.next = null;
        this.previousHash = previousHash;
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    }

    public String data() {
        return this.recipient + " " + this.sender + " " + this.transaction;
    }

    public String calculateBlockHash() {
        String isCompletedString;
        if (completed) {
            isCompletedString = "true";
        } else {
            isCompletedString = "false";
        }
        String dataToHash = previousHash
                + timeStamp
                + data()
                + isCompletedString;
        MessageDigest digest;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void complete() {
        completed = true;
    }

    public String getHash() {
        return calculateBlockHash();
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
