package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        setTitle("I.O.U. from...");

        ListView listView = (ListView) findViewById(R.id.inboxList);
        String[] contacts = new String[] {"My love","Enemy"};
        List<String> contactsList = new ArrayList<>(Arrays.asList(contacts));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,contactsList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position) {
                    case 0:
                        // my love
                        Intent intent = new Intent(InboxActivity.this,ApproveActivity.class);
                        intent.putExtra("ID","myLoveID");
                        intent.putExtra("IOU","Love me forever");
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(InboxActivity.this,ApproveActivity.class);
                        intent.putExtra("ID","enemyID");
                        intent.putExtra("IOU","I promise I will get revenge on you");
                        startActivity(intent);
                        break;
                }
            }
        });


    }
}