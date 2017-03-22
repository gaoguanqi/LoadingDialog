package com.virgo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.virgo.myapplication.dialog.LoadingDialog;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doButton();
            }
        });
    }



    private void doButton() {
        LoadingDialog dialog = LoadingDialog.newInstance("内容");
        dialog.show(getSupportFragmentManager(), "LoadingDialog");
        dialog.setDialogClickListener(new LoadingDialog.DialogClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this,"onClick",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
