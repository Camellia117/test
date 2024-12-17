package com.example.finaldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class page1 extends Activity {
    private ImageButton imageButton;
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        imageButton = findViewById(R.id.imageButton);
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.phoneNumber);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString().trim();
                String phoneNumber = editText2.getText().toString().trim();
                if(name.isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(page1.this, "手机号和名字不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(page1.this, page2.class);
                    intent.putExtra("name", name);
                    intent.putExtra("phonenumber", phoneNumber);
                    startActivity(intent);
                }
            }
        });
    }
}
