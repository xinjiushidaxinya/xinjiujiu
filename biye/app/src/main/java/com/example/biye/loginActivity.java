package com.example.biye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button button1=(Button) findViewById(R.id.denglu);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(loginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(loginActivity.this, zhuyeActivity.class);//this前面为当前activty名称，class前面为要跳转到得activity名称
                startActivity(intent);
                }
        });
    }
}
