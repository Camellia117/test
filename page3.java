package com.example.finaldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class page3 extends Activity {

    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        imageView = findViewById(R.id.picture);

        Intent intent = getIntent();
        String sport = intent.getStringExtra("sport");

        switch(sport){
            case "冰球":
                imageView.setImageResource(R.drawable.bkqq);
                break;
            case "速度滑冰":
                imageView.setImageResource(R.drawable.suduhxbk);
                break;
            case "花样滑冰":
                imageView.setImageResource(R.drawable.hxyhhxbk);
                break;
            case "短道速滑":
                imageView.setImageResource(R.drawable.drdcsuhx);
                break;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_settings){
            Intent intent = new Intent(page3.this, page1.class);
            startActivity(intent);
        }
        return true;
    }
}
