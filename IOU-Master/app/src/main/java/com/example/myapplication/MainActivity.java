package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Blockchain blockchain = new Blockchain();
    private int count = 0;

    public void addBlock(Block block) {
        blockchain.addBlock(block);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Send I.O.U to...");

        ListView listView = (ListView) findViewById(R.id.contactList);
        String[] contacts = new String[] {"Good friend","Not so good friend",
                "Enemy","My love","My doggo"};
        List<String> contactsList = new ArrayList<>(Arrays.asList(contacts));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,contactsList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainActivity.this,
                                InputActivity.class);
                        intent.putExtra("ID","goodFriendID");
                        intent.putExtra("Blockchain",blockchain);
                        intent.putExtra("count", count);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,InputActivity.class);
                        intent.putExtra("ID","notSoGoodFriendID");
                        intent.putExtra("Blockchain",blockchain);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,InputActivity.class);
                        intent.putExtra("ID","enemyID");
                        intent.putExtra("Blockchain",blockchain);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,InputActivity.class);
                        intent.putExtra("ID","myLoveID");
                        intent.putExtra("Blockchain",blockchain);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,InputActivity.class);
                        intent.putExtra("ID","myDoggoID");
                        intent.putExtra("Blockchain",blockchain);
                        startActivity(intent);
                        break;
                }
            }
        });

        FloatingActionButton inputFAB = findViewById(R.id.inputFAB);
        inputFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InputActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton inboxFAB = findViewById(R.id.inboxFAB);
        inboxFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,InboxActivity.class);
                startActivity(intent);
            }
        });

    }


}