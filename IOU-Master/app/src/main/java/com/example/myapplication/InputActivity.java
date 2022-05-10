package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {

    private Blockchain blockchain;
    private Block block;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        setTitle("Send I.O.U");

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String id = extra.getString("ID");
            setRecipientID(id);
            blockchain = (Blockchain) extra.getSerializable("Blockchain");
            count = (int) extra.getSerializable("count");
        }

        Button sendIOUButton = findViewById(R.id.sendIOUButton);
        sendIOUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendIOU(view);
                SentDialog sentDialog = new SentDialog();
                sentDialog.show(getSupportFragmentManager(),"Sent");
            }
        });
    }

    private void setRecipientID(String id) {
        EditText recipientID = findViewById(R.id.recipientIDField);
        recipientID.setText(id);
    }

    private void sendIOU(View view) {
        EditText idET = findViewById(R.id.recipientIDField);
        EditText iouET = findViewById(R.id.iouField);
        String id = idET.getText().toString();
        String iou = iouET.getText().toString();

        if(count == 0) {
            block = new Block(id, "Dom", iou, null);
        } else {
            block = new Block(id, "Dom", iou, blockchain.getBlock(count).getHash());
        }
//        System.out.println("constructor fine");
        blockchain.addBlock(block);
//        System.out.println("add block fine");
//
//        Toast.makeText(getApplicationContext(),
//                "An IOU has been created.",
//                Toast.LENGTH_LONG).show();

    }



}