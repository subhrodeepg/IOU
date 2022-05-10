package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ApproveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve);
        setTitle("To be or not to be");

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            String id = extra.getString("ID");
            String iou = extra.getString("IOU");
            EditText idField = findViewById(R.id.approveSender);
            idField.setText(id);
            EditText iouField = findViewById(R.id.approveIOU);
            iouField.setText(iou);
        }

        Button approveButton = findViewById(R.id.approveApproveButton);
        Button rejectButton = findViewById(R.id.approveRejectButton);

        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApproveDialog approveDialog = new ApproveDialog();
                approveDialog.show(getSupportFragmentManager(),"Approve");
                approveButton.setEnabled(false);
                rejectButton.setEnabled(false);
            }
        });

        rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RejectDialog rejectDialog = new RejectDialog();
                rejectDialog.show(getSupportFragmentManager(),"Reject");
                approveButton.setEnabled(false);
                rejectButton.setEnabled(false);
            }
        });

    }
}