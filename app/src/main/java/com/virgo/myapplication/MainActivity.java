package com.virgo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.virgo.myapplication.dialog.LoadingDialog;
import com.virgo.myapplication.widget.VerifyCodeButton;

public class MainActivity extends AppCompatActivity  {
private VerifyCodeButton verifyCodeButton;
    private EditText editText;
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
        verifyCodeButton = (VerifyCodeButton) findViewById(R.id.verifyCodeButton);
        editText = (EditText) findViewById(R.id.editText);
        verifyCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 校验手机号是否输入正确
                String phone = editText.getText().toString();
                if(!TextUtils.isEmpty(phone)){
                    Toast.makeText(MainActivity.this, "执行发送验证码操作", Toast.LENGTH_SHORT).show();
                    // 开始倒计时
                    verifyCodeButton.start();
                }else{
                    Toast.makeText(MainActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }
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
