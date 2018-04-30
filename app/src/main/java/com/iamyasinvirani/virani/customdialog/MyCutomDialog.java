package com.iamyasinvirani.virani.customdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyCutomDialog extends AppCompatActivity {

    public Dialog dialog;
    public Button showDialog, btnOk, btnRetry;
    public TextView tvTitle, tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cutom_dialog);

        dialog = new Dialog(MyCutomDialog.this);
        dialog.setContentView(R.layout.dialog_layout);

        showDialog = (Button) findViewById(R.id.btnShow);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Window window = dialog.getWindow();
                WindowManager.LayoutParams windowManager = window.getAttributes();
                windowManager.gravity = Gravity.BOTTOM;
                windowManager.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
                window.setAttributes(windowManager);

                dialog.setTitle("My Custom Dialog");

                btnOk = (Button) dialog.findViewById(R.id.btnOk);
                btnRetry = (Button) dialog.findViewById(R.id.btnRetry);
                tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
                tvMessage = (TextView) dialog.findViewById(R.id.tvMessage);

                tvTitle.setText("My Custom Dialog");
                tvMessage.setText("A demo app for creating a custom dialog.");

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //code for Ok button
                        Toast.makeText(MyCutomDialog.this, "Ok Clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                btnRetry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        //code for retry button
                        Toast.makeText(MyCutomDialog.this, "Retry Clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.setCancelable(false);
                dialog.show();
            }
        });

    }
}
